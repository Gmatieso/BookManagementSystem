package org.example.gmatieso.bookmgnmentsystem.auth.controller;


import org.example.gmatieso.bookmgnmentsystem.auth.service.AuthService;
import org.example.gmatieso.bookmgnmentsystem.auth.dtos.LoginRequest;
import org.example.gmatieso.bookmgnmentsystem.auth.dtos.LoginResponse;
import org.example.gmatieso.bookmgnmentsystem.auth.dtos.SignupRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request){
        String token = authService.login(request.username(), request.password());
        return new LoginResponse(token);
    }

    @PostMapping("/signup")
    public LoginResponse signup(@RequestBody SignupRequest request){
        String token = authService.signup(request.username(), request.password(), request.role()).getUsername();
        return new LoginResponse(token);
    }
}
