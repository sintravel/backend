package backend.sintravel.domain.comment.model.repository;

import backend.sintravel.domain.comment.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
