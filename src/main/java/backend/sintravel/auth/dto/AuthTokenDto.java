package backend.sintravel.auth.dto;

import lombok.Getter;

@Getter
public class AuthTokenDto {
    private String token;

    public AuthTokenDto(String token) {
        this.token = token;
    }
}
