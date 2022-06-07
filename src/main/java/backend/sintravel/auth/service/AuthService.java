package backend.sintravel.auth.service;

import backend.sintravel.auth.dto.AuthTokenDto;
import backend.sintravel.auth.exception.CantSignInException;
import backend.sintravel.auth.jwt.JwtProvider;
import backend.sintravel.domain.user.exception.UserNotExistException;
import backend.sintravel.domain.user.model.entity.User;
import backend.sintravel.domain.user.model.enums.Authority;
import backend.sintravel.domain.user.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtProvider jwtProvider;
    private final UserRepository userRepository;

    public AuthTokenDto signIn(String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotExistException("존재하지 않는 회원입니다"));
        //passwordEn 추가예정
        if (!user.getPassword().equals(password)) {
            throw new CantSignInException("비밀 번호 일치 x");
        }
        String token = jwtProvider.createToken(username);

        return new AuthTokenDto(token);
    }

    //passwordEncoder 추가에정
    public void signUp(String nickname, String username, String password) {

        User user = new User(
                null,
                username,
                password,
                nickname,
                null,
                Authority.USER);

        userRepository.save(user);
    }
}
