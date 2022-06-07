//package backend.sintravel.domain.user_badge.service;
//
//import backend.sintravel.domain.badge.model.entity.Badge;
//import backend.sintravel.domain.user_badge.model.dto.BadgeDto;
//import backend.sintravel.domain.user_badge.model.dto.BadgeResponse;
//import backend.sintravel.domain.user_badge.model.repository.UserBadgeRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//public class UserBadgeService {
//
//    private final UserBadgeRepository userBadgeRepository;
//
//    public BadgeResponse getMyBadges(Long userId) {
//        List<Badge> myBadges = userBadgeRepository.findAllBadgeByUserId(userId);
//
//        List<BadgeDto> badgeDtos = myBadges.stream()
//                .map(myBadge -> new BadgeDto(myBadge))
//                .collect(Collectors.toList());
//
//        BadgeResponse badgeResponse = new BadgeResponse(badgeDtos);
//
//        return badgeResponse;
//    }
//}
