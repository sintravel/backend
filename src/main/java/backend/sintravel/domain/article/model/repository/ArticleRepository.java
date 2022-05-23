package backend.sintravel.domain.article.model.repository;

import backend.sintravel.domain.article.model.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
