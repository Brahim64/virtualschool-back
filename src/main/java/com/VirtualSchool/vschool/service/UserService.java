package com.VirtualSchool.vschool.service;

import com.VirtualSchool.vschool.model.Token;
import com.VirtualSchool.vschool.model.TokenType;
import com.VirtualSchool.vschool.model.User;
import com.VirtualSchool.vschool.model.request.LoginRequest;
import com.VirtualSchool.vschool.model.request.RegisterRequest;
import com.VirtualSchool.vschool.model.response.AuthenticationResponse;
import com.VirtualSchool.vschool.model.services.UserDetailsImpl;
import com.VirtualSchool.vschool.model.services.UserDetailsServiceImpl;
import com.VirtualSchool.vschool.repository.TokenRepository;
import com.VirtualSchool.vschool.repository.UserRepository;
import com.VirtualSchool.vschool.security.jwt.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl userDetailsService;
    private final JwtUtils jwtUtility;
    private final TokenRepository tokenRepository;

    public void register(RegisterRequest registerRequest) {
        User user = User.builder()
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .username(registerRequest.getUsername())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .phone(registerRequest.getPhone())
                .email(registerRequest.getEmail())
                .role(registerRequest.getRole())
                .build();
        userRepository.save(user);
    }

    public String authenticate(LoginRequest loginRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

        final UserDetails userDetails
                = userDetailsService.loadUserByUsername(loginRequest.getUsername());

        final String token =
                jwtUtility.generateToken(userDetails);

        return  token;
    }

}
