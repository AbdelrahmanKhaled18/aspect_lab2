package com.example.lab2.controller;

import com.example.lab2.entity.AppUser;
import com.example.lab2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Create AppUser
    @PostMapping
    public ResponseEntity<AppUser> createUser(@RequestBody AppUser appUser) {
        return ResponseEntity.ok(userService.createUser(appUser));
    }

    // Find AppUser by ID
    @GetMapping("/{id}")
    public ResponseEntity<AppUser> getUserById(@PathVariable Long id) {
        AppUser appUser = userService.getUserById(id);
        return appUser != null ? ResponseEntity.ok(appUser) : ResponseEntity.notFound().build();
    }

    // Update AppUser
    @PutMapping("/{id}")
    public ResponseEntity<AppUser> updateUser(@PathVariable Long id, @RequestBody AppUser appUser) {
        AppUser updatedAppUser = userService.updateUser(id, appUser);
        return updatedAppUser != null ? ResponseEntity.ok(updatedAppUser) : ResponseEntity.notFound().build();
    }

    // Delete AppUser
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}