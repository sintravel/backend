//package backend.sintravel.application.badge.controller;
//
//import backend.sintravel.auth.security.UserAdaptor;
//import backend.sintravel.domain.user_badge.model.dto.BadgeResponse;
//import backend.sintravel.domain.user_badge.service.UserBadgeService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequiredArgsConstructor
//public class BadgeController {
//
//    private UserBadgeService userBadgeService;
//
//    @GetMapping("/users/badge")
//    @ResponseStatus(HttpStatus.OK)
//    public BadgeResponse getMyBadges(@AuthenticationPrincipal UserAdaptor userAdaptor) {
//        return userBadgeService.getMyBadges(userAdaptor.getUser().getId());
//    }
//}
