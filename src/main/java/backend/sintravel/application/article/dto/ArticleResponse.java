package backend.sintravel.application.article.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArticleResponse {

    private Long articleId;
    private String title;
    private String content;
    private int view_count;
    private String writer;
}
