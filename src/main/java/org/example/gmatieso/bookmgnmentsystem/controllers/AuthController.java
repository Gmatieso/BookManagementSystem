package org.example.gmatieso.bookmgnmentsystem.controllers;


import org.example.gmatieso.bookmgnmentsystem.dtos.LoginRequest;
import org.example.gmatieso.bookmgnmentsystem.dtos.LoginResponse;
import org.example.gmatieso.bookmgnmentsystem.dtos.SignupRequest;
import org.example.gmatieso.bookmgnmentsystem.service.AuthService;
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
