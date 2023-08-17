package com.shoparsenal.shoparsenal.api.controller.security;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.shoparsenal.shoparsenal.model.LocalUser;
import com.shoparsenal.shoparsenal.repo.UserRepo;
import com.shoparsenal.shoparsenal.service.JWTService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class JWTRequestFilter extends OncePerRequestFilter {
    private final JWTService jwtService;
    private final UserRepo userRepo;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String tokenHandler = request.getHeader("Authorization");
        if(tokenHandler != null && tokenHandler.startsWith("Bearer ")) {
            String token = tokenHandler.substring(7);
            try{
                String username = jwtService.getUsername(token);
                Optional<LocalUser> user = userRepo.findByUsernameIgnoreCase(username);
                if(user.isPresent()) {
                    LocalUser user1 = user.get();
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            } catch(JWTDecodeException e) {}
        }
        filterChain.doFilter(request, response);
    }
}
