package backend.sintravel.auth.api;

import backend.sintravel.auth.dto.AuthTokenDto;
import backend.sintravel.auth.request.SignInRequest;
import backend.sintravel.auth.request.SignUpRequest;
import backend.sintravel.auth.response.SignInResponse;
import backend.sintravel.auth.response.SignUpResponse;
import backend.sintravel.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/sign-in")
    @ResponseStatus(HttpStatus.OK)
    public SignInResponse signIn(@RequestBody SignInRequest signInRequest) {
        AuthTokenDto authTokenDto = authService.signIn(signInRequest.getUsername(), signInRequest.getPassword());
        return new SignInResponse(authTokenDto);
    }

    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.OK)
    public SignUpResponse singUp(@RequestBody SignUpRequest signUpRequest) {
        authService.signUp(signUpRequest.getNickname(), signUpRequest.getUsername(), signUpRequest.getPassword());
        return new SignUpResponse("success");
    }
}
