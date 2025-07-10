package com.juy.recycle_api.web;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.juy.recycle_api.domain.AccountCredentials;
import com.juy.recycle_api.service.JwtService;

@RestController
public class LoginController {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public LoginController(JwtService jwtService, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/login")
    public ResponseEntity<?> getToken(@RequestBody AccountCredentials credentials) {

        System.out.println("ajfjeifjsijfijs : " + credentials.user());
        UsernamePasswordAuthenticationToken creds = new UsernamePasswordAuthenticationToken(credentials.user(),
                credentials.password());
        Authentication auth = authenticationManager.authenticate(creds);
        // Generate token
        String jwts = jwtService.getToken(auth.getName());
        System.out.println("ajfj22222222 : " + auth.getAuthorities());

        // Build response with the generated token
        return ResponseEntity.ok()
                             .header(HttpHeaders.AUTHORIZATION, "Bearer" + jwts)
                             .header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "Authorization")
                             .build();
    }
}
