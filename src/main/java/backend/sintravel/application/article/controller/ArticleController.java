//package backend.sintravel.application.article.controller;
//
//import backend.sintravel.application.article.dto.ArticleResponse;
//import backend.sintravel.application.article.dto.CreateArticleResponse;
//import backend.sintravel.application.article.dto.SaveArticleRequest;
//import backend.sintravel.auth.security.UserAdaptor;
//import backend.sintravel.domain.article.service.ArticleService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/boards")
//public class ArticleController {
//
//    private final ArticleService articleService;
//
//    @PostMapping("/{boardId}/articles")
//    @ResponseStatus(HttpStatus.OK)
//    public CreateArticleResponse createArticle(@AuthenticationPrincipal UserAdaptor userAdaptor,
//                                               @PathVariable Long boardId,
//                                               @RequestBody SaveArticleRequest saveArticleRequest) {
//        return articleService.createArticle(
//                userAdaptor.getUser().getId(),
//                boardId,
//                saveArticleRequest.getContent(),
//                saveArticleRequest.getTitle());
//    }
//
//    @GetMapping("/{boardId}/articles/{articleId}")
//    @ResponseStatus(HttpStatus.OK)
//    public ArticleResponse getArticle(@PathVariable Long boardId,
//                                      @PathVariable Long articleId) {
//        return articleService.getArticle(articleId);
//    }
//
//    @DeleteMapping("/{boardId}/articles/{articleId}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteArticle(@PathVariable Long boardId,
//                              @PathVariable Long articleId,
//                              @AuthenticationPrincipal UserAdaptor userAdaptor) {
//        articleService.deleteArticle(articleId, userAdaptor.getUser().getId());
//    }
//}
