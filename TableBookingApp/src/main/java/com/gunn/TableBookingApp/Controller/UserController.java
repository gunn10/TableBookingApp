package com.gunn.TableBookingApp.Controller;

import com.gunn.TableBookingApp.Model.User;
import com.gunn.TableBookingApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // POST request for registration
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {


            System.out.println(user.toString());

            userService.register(
//DTO
                    user.getName(),
                    user.getEmail(),
                    user.getPassword(),
                     user.getPhone(),
                    user.getUser_address()
            );
            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while registering the user: " + e.getMessage());
//        }
    }

    // GET request to retrieve user by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        try {
            User user = userService.findById(id);
            if (user != null) {
                return ResponseEntity.ok(user);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // GET request to retrieve all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            List<User> users = userService.findAll();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }




private String validateUser(User user) {
        // Validate name
        if (user.getName() == null || user.getName().trim().isEmpty() || user.getName().length() > 100) {
            return "Invalid name. Must be between 1 and 100 characters.";
        }

        // Validate email
        if (user.getEmail() == null || !user.getEmail().matches("^[A-Za-z0-9._%+-]+@gmail\\.com$")) {
            return "Invalid email. Must be a valid Gmail address.";
        }

        // Validate password
        if (user.getPassword() == null || user.getPassword().length() <= 4) {
            return "Invalid password. Must be greater than 4 characters.";
        }

        // Validate phone
        if (user.getPhone() == null || !user.getPhone().matches("^[0-9]{10}$")) {
            return "Invalid phone number. Must be 10 digits.";
        }

        // Validate user_address
        if (user.getUser_address() == null || user.getUser_address().trim().isEmpty()) {
            return "Invalid address. Address cannot be empty.";
        }

        return null; // No validation errors
    }
}
