package backend.sintravel.domain.user.model.repository;

import backend.sintravel.domain.user.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
