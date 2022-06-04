package backend.sintravel.application.article.dto;

import lombok.Data;

@Data
public class SaveArticleRequest {
    String title;
    String content;
}
