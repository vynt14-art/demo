package uef.edu.vn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uef.edu.vn.model.User;
import uef.edu.vn.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // ==========================
    // LOGIN
    // ==========================
    public User login(String username,
            String password) {

        return userRepository.login(
                username,
                password);
    }

    // ==========================
    // FIND BY USERNAME
    // ==========================
    public User findByUsername(
            String username) {

        return userRepository.findByUsername(
                username);
    }

    // ==========================
    // FIND BY ID
    // ==========================
    public User findById(int userId) {

        return userRepository.findById(
                userId);
    }

    // ==========================
    // FIND ALL
    // ==========================
    public List<User> findAll() {

        return userRepository.findAll();
    }

    // ==========================
    // SAVE
    // ==========================
    public int save(User user) {

        return userRepository.save(user);
    }

    // ==========================
    // UPDATE PASSWORD
    // ==========================
    public int updatePassword(
            int userId,
            String password) {

        return userRepository.updatePassword(
                userId,
                password);
    }

    // ==========================
    // UPDATE ROLE
    // ==========================
    public int updateRole(
            int userId,
            String role) {

        return userRepository.updateRole(
                userId,
                role);
    }

    // ==========================
    // LOCK / UNLOCK ACCOUNT
    // ==========================
    public int updateStatus(
            int userId,
            boolean status) {

        return userRepository.updateStatus(
                userId,
                status);
    }

    // ==========================
    // DELETE
    // ==========================
    public int delete(int userId) {

        return userRepository.delete(
                userId);
    }

    // ==========================
    // COUNT USERS
    // ==========================
    public int countUsers() {

        return userRepository.countUsers();
    }

    public int getLastUserId() {

        return userRepository.getLastUserId();
    }
}
