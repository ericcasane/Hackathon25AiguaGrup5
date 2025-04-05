package org.tecnocampus.aquaactua.application;

import org.springframework.stereotype.Service;
import org.tecnocampus.aquaactua.domain.User;
import org.tecnocampus.aquaactua.persistence.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(String name, String email, String password) {
        User user = new User(name, email, password);
        return userRepository.save(user);
    }

    public User login(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password).orElseThrow();
    }
}