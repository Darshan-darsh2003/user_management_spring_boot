// package com.darshan.usermanagement.controller;

// import com.darshan.usermanagement.model.User;
// import com.darshan.usermanagement.service.UserService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/users")
// public class UserController {

//     @Autowired
//     private UserService userService;

//     @GetMapping
//     public List<User> getAllUsers() {
//         return userService.getAllUsers();
//     }

//     @GetMapping("/{id}")
//     public User getUserById(@PathVariable Long id) {
//         return userService.getUserById(id);
//     }

//     @PostMapping
//     public User createUser(@RequestBody User user) {
//         return userService.createUser(user);
//     }

//     @PutMapping("/{id}")
//     public User updateUser(@PathVariable Long id, @RequestBody User user) {
//         return userService.updateUser(id, user);
//     }

//     @DeleteMapping("/{id}")
//     public void deleteUser(@PathVariable Long id) {
//         userService.deleteUser(id);
//     }
// }


package com.darshan.usermanagement.controller;

import com.darshan.usermanagement.dto.ApiResponse;
import com.darshan.usermanagement.model.User;
import com.darshan.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController
// @RequestMapping("/api/users")
// public class UserController {

//     @Autowired
//     private UserService userService;

//     @GetMapping
//     public ResponseEntity<ApiResponse<List<User>>> getAllUsers() {
//         List<User> users = userService.getAllUsers();
//         ApiResponse<List<User>> response = new ApiResponse<>(true, "Users retrieved successfully", users);
//         return ResponseEntity.ok(response);
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<ApiResponse<User>> getUserById(@PathVariable Long id) {
//         User user = userService.getUserById(id);
//         ApiResponse<User> response = new ApiResponse<>(true, "User retrieved successfully", user);
//         return ResponseEntity.ok(response);
//     }

//     @PostMapping
//     public ResponseEntity<ApiResponse<User>> createUser(@RequestBody User user) {
//         User createdUser = userService.createUser(user);
//         ApiResponse<User> response = new ApiResponse<>(true, "User created successfully", createdUser);
//         return ResponseEntity.status(HttpStatus.CREATED).body(response);
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<ApiResponse<User>> updateUser(@PathVariable Long id, @RequestBody User user) {
//         User updatedUser = userService.updateUser(id, user);
//         ApiResponse<User> response = new ApiResponse<>(true, "User updated successfully", updatedUser);
//         return ResponseEntity.ok(response);
//     }

//     @DeleteMapping("/{id}")
//     public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable Long id) {
//         userService.deleteUser(id);
//         ApiResponse<Void> response = new ApiResponse<>(true, "User deleted successfully", null);
//         return ResponseEntity.ok(response);
//     }
// }

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ApiResponse<List<User>> getAllUsers() {
        try {
            List<User> users = userService.getAllUsers();
            return new ApiResponse<>(true, "Users retrieved successfully", users);
        } catch (Exception e) {
            return new ApiResponse<>(false, e.getMessage(), null);
        }
    }

    @GetMapping("/{id}")
    public ApiResponse<User> getUserById(@PathVariable Long id) {
        try {
            User user = userService.getUserById(id);
            return new ApiResponse<>(true, "User retrieved successfully", user);
        } catch (Exception e) {
            return new ApiResponse<>(false, e.getMessage(), null);
        }
    }

    @PostMapping
    public ApiResponse<User> createUser(@RequestBody User user) {
        try {
            User createdUser = userService.createUser(user);
            return new ApiResponse<>(true, "User created successfully", createdUser);
        } catch (Exception e) {
            return new ApiResponse<>(false, e.getMessage(), null);
        }
    }

    @PutMapping("/{id}")
    public ApiResponse<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        try {
            User updatedUser = userService.updateUser(id, user);
            return new ApiResponse<>(true, "User updated successfully", updatedUser);
        } catch (Exception e) {
            return new ApiResponse<>(false, e.getMessage(), null);
        }
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteUser(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return new ApiResponse<>(true, "User deleted successfully", null);
        } catch (Exception e) {
            return new ApiResponse<>(false, e.getMessage(), null);
        }
    }
}

