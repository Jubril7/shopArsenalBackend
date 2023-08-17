package com.shoparsenal.shoparsenal.api.controller.auth;

import com.shoparsenal.shoparsenal.DTOs.LoginDTO;
import com.shoparsenal.shoparsenal.DTOs.UserDTO;
import com.shoparsenal.shoparsenal.api.controller.exception.UserAlreadyExistException;
import com.shoparsenal.shoparsenal.model.LocalUser;
import com.shoparsenal.shoparsenal.model.LoginResponse;
import com.shoparsenal.shoparsenal.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController("/")
public class AuthenticationController {

    private final UserService userService;

    @PostMapping("register")
    public ResponseEntity registerUser(@Valid @RequestBody UserDTO userDTO) {
        try {
            userService.registerUser(userDTO);
            return ResponseEntity.ok().build();
        } catch(UserAlreadyExistException uae) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PostMapping("login")
    public ResponseEntity login(@Valid @RequestBody LoginDTO loginDTO) {
        String jwt = userService.loginUser(loginDTO);
        if(jwt == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setJwt(jwt);
            return ResponseEntity.ok(loginResponse);
        }
    }

    @GetMapping("profile")
    public LocalUser getLoggedInUserProfile(@AuthenticationPrincipal LocalUser user) {
        return user;
    }

}
