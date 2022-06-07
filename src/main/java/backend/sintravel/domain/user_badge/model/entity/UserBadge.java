//package backend.sintravel.domain.user_badge.model.entity;
//
//import backend.sintravel.domain.badge.model.entity.Badge;
//import backend.sintravel.domain.common.entity.BaseTimeEntity;
//import backend.sintravel.domain.user.model.entity.User;
//import lombok.Getter;
//
//import javax.persistence.*;
//
//@Entity
//@Getter
//public class UserBadge extends BaseTimeEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @JoinColumn(name = "user_id")
//    @ManyToOne(fetch = FetchType.LAZY)
//    private User user;
//
//    @JoinColumn(name = "badge_id")
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Badge badge;
//}
