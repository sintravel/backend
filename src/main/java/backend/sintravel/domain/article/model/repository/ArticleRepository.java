package backend.sintravel.domain.article.model.repository;

import backend.sintravel.domain.article.model.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query(value = "select a from Article a join fetch a.user where a.id = ?1")
    Optional<Article> findByIdWithUser(Long articleId);

}
