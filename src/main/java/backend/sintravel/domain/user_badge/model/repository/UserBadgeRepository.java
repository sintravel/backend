package backend.sintravel.domain.user_badge.model.repository;

import backend.sintravel.domain.user_badge.model.entity.UserBadge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBadgeRepository extends JpaRepository<UserBadge, Long> {
}
