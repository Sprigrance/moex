package ru.sprigrance.moex.service.impl;

import ru.sprigrance.moex.domain.user.User;
import ru.sprigrance.moex.service.AuthService;
import ru.sprigrance.moex.service.UserService;
import ru.sprigrance.moex.web.dto.auth.JwtRequest;
import ru.sprigrance.moex.web.dto.auth.JwtResponse;
import ru.sprigrance.moex.web.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public JwtResponse login(JwtRequest request) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
        authenticationManager.authenticate(authToken);

        User user = userService.getByUsername(request.getUsername());
        String accessToken = jwtTokenProvider.createAccessToken(
                user.getId(),
                user.getUsername(),
                user.getRoles());
        String refreshToken = jwtTokenProvider.createRefreshToken(
                user.getId(),
                user.getUsername());

        JwtResponse response = new JwtResponse();
        response.setId(user.getId());
        response.setUsername(user.getUsername());
        response.setAccessToken(accessToken);
        response.setRefreshToken(refreshToken);
        return response;
    }

    @Override
    public JwtResponse refresh(String refreshToken) {
        return jwtTokenProvider.refreshUserTokens(refreshToken);
    }

}
