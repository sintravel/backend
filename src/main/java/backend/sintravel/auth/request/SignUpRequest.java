package backend.sintravel.auth.request;

import lombok.Getter;

@Getter
public class SignUpRequest {
    private String nickname;
    private String username;
    private String password;
}
