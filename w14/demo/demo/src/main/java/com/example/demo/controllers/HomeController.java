package com.example.demo.controllers;

import com.example.demo.contract.AuthenticationRequest;
import com.example.demo.contract.AuthenticationResponse;
import com.example.demo.service.DemoUserDetailsService;
import com.example.demo.service.JwtUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class HomeController {

    private DemoUserDetailsService userDetailsService;

    private JwtUtils jwtTokenUtil;
    private AuthenticationManager authenticationManager;

    public HomeController(DemoUserDetailsService userDetailsService, JwtUtils jwtTokenUtil, AuthenticationManager authenticationManager) {
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest request) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }


        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(request.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @GetMapping("/")
    public ResponseEntity index(){
        return ResponseEntity.ok("<h1>Welcome</h1>");
    }


    @GetMapping("user")
    public ResponseEntity user(){
        return ResponseEntity.ok("<h1>Welcome User</h1>");
    }

    @GetMapping("admin")
    public ResponseEntity admin(){
        return ResponseEntity.ok("<h1>Welcome Admin</h1>");
    }

}
