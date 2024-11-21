package ru.yandex.practicum.catsgram.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.model.User;
import ru.yandex.practicum.catsgram.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> findUser() {
        return userService.findUser();
    }

    @PostMapping
    // указываем, что код успешного ответа должен быть 201 Created
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User newUser) {
        return userService.updateUser(newUser);
    }

    @GetMapping("/user/{userId}")
    public Optional<User> getUser(@PathVariable Long userId) {
        return userService.findUserById(userId);
    }
}