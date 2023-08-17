package com.shoparsenal.shoparsenal.service;

import com.shoparsenal.shoparsenal.DTOs.LoginDTO;
import com.shoparsenal.shoparsenal.DTOs.UserDTO;
import com.shoparsenal.shoparsenal.api.controller.exception.UserAlreadyExistException;
import com.shoparsenal.shoparsenal.model.LocalUser;
import com.shoparsenal.shoparsenal.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserService {
    private final UserRepo userRepo;
    private final EncryptionService encryptionService;
    private final JWTService jwtService;

    public LocalUser registerUser(UserDTO userDTO) throws UserAlreadyExistException {
        if(userRepo.findByEmailIgnoreCase(userDTO.getEmail()).isPresent() &&
                userRepo.findByUsernameIgnoreCase(userDTO.getUsername()).isPresent()) {
            throw new UserAlreadyExistException();
        }
        LocalUser user = new LocalUser();
        user.setEmail(userDTO.getEmail());
        user.setUsername(userDTO.getUsername());
        user.setPassword(encryptionService.encryptPassword(userDTO.getPassword()));
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        return userRepo.save(user);
    }

    public String loginUser(LoginDTO loginDTO) {
        Optional<LocalUser> opUser = userRepo.findByUsernameIgnoreCase(loginDTO.getUsername());
        if(opUser.isPresent()) {
            LocalUser user = opUser.get();
            if(encryptionService.verifyPassword(loginDTO.getPassword(), user.getPassword())) {
                return jwtService.generateJWT(user);
            }
        }
        return null;
    }
}
