package ua.dragunov.watchlyapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.dragunov.watchlyapi.dto.UserResponse;
import ua.dragunov.watchlyapi.service.UserService;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable("id") int id) {
        return ResponseEntity.ok(userService.findById(id));
    }


}
