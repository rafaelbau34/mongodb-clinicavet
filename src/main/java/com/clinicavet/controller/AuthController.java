package com.clinicavet.controller;

import com.clinicavet.model.User;
import com.clinicavet.repository.UserRepository;
import com.clinicavet.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        String password = body.get("password");

        authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        String token = jwtUtil.generateToken(username);
        return Map.of("token", token);
    }

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody Map<String, String> body) {
        User user = User.builder()
                .username(body.get("username"))
                .password(passwordEncoder.encode(body.get("password")))
                .role(User.Role.valueOf(body.get("role").toUpperCase()))
                .build();
        userRepository.save(user);
        return Map.of("message", "Usuario registrado con éxito");
    }
}