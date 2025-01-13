package com.herison.cep.adapter.controller;

import com.herison.cep.adapter.authentication.AuthenticationDTO;
import com.herison.cep.adapter.authentication.LoginResponseDTO;
import com.herison.cep.adapter.authentication.RegisterDTO;
import com.herison.cep.adapter.authentication.User;
import com.herison.cep.adapter.outbound.repository.authentication.GetUser;
import com.herison.cep.adapter.outbound.repository.authentication.SaveUser;
import com.herison.cep.infrastructure.config.security.TokenService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthenticationController implements AuthenticationControllerContract {

    private AuthenticationManager authenticationManager;
    private GetUser getUser;
    private TokenService tokenService;
    private SaveUser saveUser;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        log.info("Login request: " + data.login());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){

        if(this.getUser.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.login(), encryptedPassword, data.role());

        this.saveUser.save(newUser);

        log.info("Register request: " + data.login());

        return ResponseEntity.ok().build();
    }
}
