package backend.sintravel.auth.response;

import backend.sintravel.auth.dto.AuthTokenDto;
import lombok.Getter;

@Getter
public class SignInResponse {
    private String token;

    public SignInResponse(AuthTokenDto authTokenDto) {
        this.token = authTokenDto.getToken();
    }
}
