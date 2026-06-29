package uef.edu.vn.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import uef.edu.vn.model.Employee;
import uef.edu.vn.model.User;
import uef.edu.vn.service.EmployeeService;
import uef.edu.vn.service.MediaService;
import uef.edu.vn.service.UserService;

@Controller
@RequestMapping("/admin/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private UserService userService;

    @Autowired
    private MediaService mediaService;

    // ==========================
    // DANH SÁCH
    // ==========================
    @GetMapping
    public String employeeList(Model model) {

        List<Employee> employees
                = employeeService.findAll();

        model.addAttribute(
                "employees",
                employees);

        return "admin/employee/employee-list";
    }

    // ==========================
    // FORM THÊM
    // ==========================
    @GetMapping("/add")
    public String showAddForm() {

        return "admin/employee/employee-add";
    }

    // ==========================
    // LƯU NHÂN VIÊN
    // ==========================
    @PostMapping("/save")
    public String saveEmployee(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String role,
            @RequestParam String fullName,
            @RequestParam(required = false) String imagePath,
            @RequestParam(required = false) String phone,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) Date hireDate,
            @RequestParam(required = false) Double salary
    ) {

        if (password == null
                || password.length() < 6) {

            return "redirect:/admin/employees/add";
        }

        // ===== TẠO USER =====
        User user = new User();

        user.setUsername(username);

        user.setPassword(password);

        user.setRole(role);

        user.setStatus(true);

        userService.save(user);

        // ===== LẤY USER_ID =====
        int userId
                = userService.getLastUserId();

        // ===== TẠO EMPLOYEE =====
        Employee employee
                = new Employee();

        employee.setUserId(userId);

        employee.setMediaId(
                mediaService.saveImagePath(
                        imagePath,
                        "EMPLOYEE"));

        employee.setFullName(fullName);

        employee.setPhone(phone);

        employee.setEmail(email);

        employee.setAddress(address);

        employee.setHireDate(hireDate);

        if (salary != null) {

            employee.setSalary(
                    java.math.BigDecimal
                            .valueOf(salary));
        }

        employeeService.save(employee);

        return "redirect:/admin/employees";
    }

    // ==========================
    // CHI TIẾT
    // ==========================
    @GetMapping("/detail/{id}")
    public String detailEmployee(
            @PathVariable int id,
            Model model) {

        Employee employee
                = employeeService.findById(id);

        model.addAttribute(
                "employee",
                employee);

        return "admin/employee/employee-detail";
    }

    // ==========================
    // FORM SỬA
    // ==========================
    @GetMapping("/edit/{id}")
    public String showEditForm(
            @PathVariable int id,
            Model model) {

        Employee employee
                = employeeService.findById(id);

        model.addAttribute(
                "employee",
                employee);

        return "admin/employee/employee-edit";
    }

    // ==========================
    // CẬP NHẬT
    // ==========================
    @PostMapping("/update")
    public String updateEmployee(
            @ModelAttribute Employee employee,
            @RequestParam(required = false) String imagePath) {

        Integer mediaId
                = mediaService.saveImagePath(
                        imagePath,
                        "EMPLOYEE");

        if (mediaId != null) {

            employee.setMediaId(mediaId);
        }

        employeeService.update(employee);

        return "redirect:/admin/employees";
    }

    @PostMapping("/reset-password/{id}")
    public String resetPassword(
            @PathVariable int id,
            @RequestParam(defaultValue = "123456") String password) {

        Employee employee
                = employeeService.findById(id);

        if (employee != null) {

            userService.updatePassword(
                    employee.getUserId(),
                    password);
        }

        return "redirect:/admin/employees";
    }

    @PostMapping("/role/{id}")
    public String updateRole(
            @PathVariable int id,
            @RequestParam String role) {

        Employee employee
                = employeeService.findById(id);

        if (employee != null) {

            userService.updateRole(
                    employee.getUserId(),
                    role);
        }

        return "redirect:/admin/employees";
    }

    @PostMapping("/status/{id}")
    public String updateAccountStatus(
            @PathVariable int id,
            @RequestParam boolean status) {

        Employee employee
                = employeeService.findById(id);

        if (employee != null) {

            userService.updateStatus(
                    employee.getUserId(),
                    status);
        }

        return "redirect:/admin/employees";
    }

    // ==========================
    // XÓA
    // ==========================
    @GetMapping("/delete/{id}")
    public String deleteEmployee(
            @PathVariable int id) {

        employeeService.delete(id);

        return "redirect:/admin/employees";
    }

    // ==========================
    // TÌM KIẾM
    // ==========================
    @GetMapping("/search")
    public String searchEmployee(
            @RequestParam String keyword,
            Model model) {

        model.addAttribute(
                "employees",
                employeeService.searchByName(
                        keyword));

        model.addAttribute(
                "keyword",
                keyword);

        return "admin/employee/employee-list";
    }
}
