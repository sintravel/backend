package backend.sintravel.application.article.dto;

import backend.sintravel.domain.article.model.entity.Article;
import lombok.Data;

@Data
public class CreateArticleResponse {

    private Long ArticleId;
    private String title;
    private String content;

    public CreateArticleResponse(Article article) {
        this.ArticleId = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
