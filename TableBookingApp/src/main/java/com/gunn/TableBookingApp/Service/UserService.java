package com.gunn.TableBookingApp.Service;

import com.gunn.TableBookingApp.Model.User;
import com.gunn.TableBookingApp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register( String name, String email, String password, String phone, String user_address) {
        // Check if the email or phone already exists
        if (userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Email is already in use");
        }
        if (userRepository.existsByPhone(phone)) {
            throw new IllegalArgumentException("Phone number is already in use");
        }

        // Create a new User object with the provided parameters
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password); // Store password as-is
        user.setPhone(phone);
        user.setUser_address(user_address);

        // Save the user object to the repository
        userRepository.save(user);
    }

    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
