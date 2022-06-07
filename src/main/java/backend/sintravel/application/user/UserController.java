package backend.sintravel.application.user;

import backend.sintravel.application.common.dto.ResponseMessage;
import backend.sintravel.application.user.dto.UserTypeRequest;
import backend.sintravel.auth.security.UserAdaptor;
import backend.sintravel.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PatchMapping("/disabled")
    @ResponseStatus(HttpStatus.OK)
    public ResponseMessage insertUserDisabledType(@RequestBody UserTypeRequest userTypeRequest,
                                                  @AuthenticationPrincipal UserAdaptor userAdaptor) {
        System.out.println("userTypeRequest.getType() = " + userTypeRequest.getType());
        userService.insertUserDisabledType(userTypeRequest.getType(), userAdaptor.getUser().getId());
        return new ResponseMessage("success");
    }
}

