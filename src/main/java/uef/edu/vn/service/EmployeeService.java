package uef.edu.vn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uef.edu.vn.model.Employee;
import uef.edu.vn.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // ==========================
    // FIND ALL
    // ==========================
    public List<Employee> findAll() {

        return employeeRepository.findAll();
    }

    // ==========================
    // FIND BY ID
    // ==========================
    public Employee findById(int employeeId) {

        return employeeRepository.findById(
                employeeId);
    }

    public Employee findByUserId(int userId) {

        return employeeRepository.findByUserId(
                userId);
    }

    // ==========================
    // SAVE
    // ==========================
    public int save(Employee employee) {

        return employeeRepository.save(
                employee);
    }

    // ==========================
    // UPDATE
    // ==========================
    public int update(Employee employee) {

        return employeeRepository.update(
                employee);
    }

    // ==========================
    // DELETE
    // ==========================
    public int delete(int employeeId) {

        return employeeRepository.delete(
                employeeId);
    }

    // ==========================
    // COUNT EMPLOYEES
    // ==========================
    public int countEmployees() {

        return employeeRepository.countEmployees();
    }

    // ==========================
    // SEARCH BY NAME
    // ==========================
    public List<Employee> searchByName(
            String keyword) {

        return employeeRepository.searchByName(
                keyword);
    }
}
