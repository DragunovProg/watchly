package ua.dragunov.watchlyapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ua.dragunov.watchlyapi.dto.UserCreateRequest;
import ua.dragunov.watchlyapi.dto.UserResponse;
import ua.dragunov.watchlyapi.dto.UserUpdateRequest;
import ua.dragunov.watchlyapi.model.User;
import ua.dragunov.watchlyapi.service.UserService;

import java.net.Authenticator;

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

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") long id, @RequestBody UserUpdateRequest userUpdateRequest) {
        userService.updateById(id, userUpdateRequest);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/me")
    public ResponseEntity<UserResponse> getCurrentUser(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        UserResponse userResponse = userService.findByEmail(user.getEmail());

        return ResponseEntity.ok(userResponse);
    }

    @PutMapping("/me")
    public ResponseEntity<Void> updateCurrentUser(Authentication authentication, @RequestBody UserUpdateRequest userUpdateRequest) {
        User user = (User) authentication.getPrincipal();
        userService.update(user.getEmail(), userUpdateRequest);

        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<UserResponse> register(@RequestBody UserCreateRequest createRequest) {
        return ResponseEntity.ok(userService.register(createRequest));
    }

}
