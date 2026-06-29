package uef.edu.vn.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uef.edu.vn.model.User;
import uef.edu.vn.service.UserService;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showLoginPage() {

        return "auth/login";
    }

    @GetMapping("/login")
    public String loginPage() {

        return "auth/login";
    }

    @GetMapping("/auth/login")
    public String legacyLoginPage() {

        return "redirect:/login";
    }

    @GetMapping("/auth/access-denied")
    public String accessDenied() {

        return "auth/access-denied";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession session,
            Model model) {

        User user
                = userService.login(
                        username,
                        password);

        if (password == null
                || password.length() < 6) {

            model.addAttribute(
                    "error",
                    "Mat khau phai co it nhat 6 ky tu!");

            return "auth/login";
        }

        if (user == null) {

            model.addAttribute(
                    "error",
                    "Tên đăng nhập hoặc mật khẩu không đúng!");

            return "auth/login";
        }

        session.setAttribute(
                "loggedUser",
                user);

        session.setAttribute(
                "role",
                user.getRole());

        if ("ADMIN".equals(user.getRole())) {

            return "redirect:/admin/dashboard";
        }

        if ("STAFF".equals(user.getRole())) {

            return "redirect:/staff/dashboard";
        }

        if ("KITCHEN".equals(user.getRole())) {

            return "redirect:/kitchen/dashboard";
        }

        return "auth/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();

        return "redirect:/login";
    }
}
