package backend.sintravel.auth.request;

import lombok.Getter;

@Getter
public class SignInRequest {
    private String username;
    private String password;
}
