package org.example.gmatieso.bookmgnmentsystem;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.DispatcherType;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.gmatieso.bookmgnmentsystem.dtos.ApiResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutHandler;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private static final String[] AUTH_WHITELIST = {
            "/public/**",
            "/auth/**" // Allow login endpoints
    };

    private final LogoutHandler logoutHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(req -> req
                        .dispatcherTypeMatchers(DispatcherType.FORWARD, DispatcherType.ERROR).permitAll()
                        .requestMatchers(AUTH_WHITELIST).permitAll()
                        .requestMatchers("/books/**", "/authors/**", "/categories/**", "book-details/**").authenticated() // Require auth
                        .anyRequest().authenticated())

                .formLogin(form -> form
                        .loginPage("/auth/login")
                        .loginProcessingUrl("/auth/login")
                        .defaultSuccessUrl("/books")
                        .permitAll())

                .logout(logoutConfigurer-> logoutConfigurer
                        .logoutUrl("/auth/logout")
                        .addLogoutHandler(logoutHandler)
                        .logoutSuccessHandler((request, response, authentication) -> {
                            SecurityContextHolder.clearContext();
                              ApiResponse<String> apiResponse = new ApiResponse<>(200,"Logout successfully");
                            response.setStatus(HttpServletResponse.SC_OK);
                            response.setContentType("application/json");
                            response.getWriter().write(new ObjectMapper().writeValueAsString(apiResponse));
                            response.getWriter().flush();
                        })
                )
                .build();
    }

}
