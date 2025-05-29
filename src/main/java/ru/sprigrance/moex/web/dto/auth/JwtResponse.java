package ru.sprigrance.moex.web.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Response after login")
public class JwtResponse {

    private Long id;
    private String username;

    private String accessToken;
    private String refreshToken;
}
