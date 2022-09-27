package com.johan.user.controller;

import com.johan.user.model.User;
import com.johan.user.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Slf4j
public class UserController {

    private UserService service;

    @PostMapping("/users")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        log.info("Execute save user method - " + user);
        return new ResponseEntity<>(service.saveUser(user), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDTO> findUserByIdWithDepartment(@PathVariable("id") Long userId) {
        return new ResponseEntity<>(service.findUserWithDepartment(userId), HttpStatus.OK);
    }

}
