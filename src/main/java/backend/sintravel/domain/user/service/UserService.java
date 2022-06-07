package backend.sintravel.domain.user.service;


import backend.sintravel.domain.user.exception.UserNotExistException;
import backend.sintravel.domain.user.model.entity.User;
import backend.sintravel.domain.user.model.enums.UserType;
import backend.sintravel.domain.user.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void insertUserDisabledType(String type, Long userId) {
        //에러잡아야됨
        UserType userType = UserType.valueOf(type);

        User findUser = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotExistException("존재하지 않는 회원입니다"));

        findUser.insertUserType(userType);
    }


}
