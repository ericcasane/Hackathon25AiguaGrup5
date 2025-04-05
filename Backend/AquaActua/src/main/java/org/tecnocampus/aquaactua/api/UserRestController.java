package org.tecnocampus.aquaactua.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tecnocampus.aquaactua.application.UserService;
import org.tecnocampus.aquaactua.domain.User;

@Tag(name = "Use" , description = "Controller to manage users")
@RestController
@RequestMapping("/user")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        return userService.register(name, email, password);
    }

    @PostMapping("/login")
    public User login(@RequestParam String email, @RequestParam String password) {
        return userService.login(email, password);
    }


}