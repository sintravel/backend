//package backend.sintravel.domain.user_badge.model.repository;
//
//import backend.sintravel.domain.badge.model.entity.Badge;
//import backend.sintravel.domain.user.model.entity.User;
//import backend.sintravel.domain.user_badge.model.entity.UserBadge;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import java.util.List;
//
//public interface UserBadgeRepository extends JpaRepository<UserBadge, Long> {
//
//    @Query(value = "select b.badge from UserBadge b join fetch b.badge where b.user.id = ?1")
//    List<Badge> findAllBadgeByUserId(Long userId);
//}
