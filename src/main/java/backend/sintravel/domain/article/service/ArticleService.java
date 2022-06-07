//package backend.sintravel.domain.article.service;
//
//import backend.sintravel.application.article.dto.ArticleResponse;
//import backend.sintravel.application.article.dto.CreateArticleResponse;
//import backend.sintravel.domain.article.exception.ArticleNotExistException;
//import backend.sintravel.domain.article.exception.DeleteArticleByNoAuthException;
//import backend.sintravel.domain.article.model.entity.Article;
//import backend.sintravel.domain.article.model.repository.ArticleRepository;
//import backend.sintravel.domain.board.model.entity.Board;
//import backend.sintravel.domain.board.exception.BoardNotExistException;
//import backend.sintravel.domain.board.model.repository.BoardRepository;
//import backend.sintravel.domain.user.model.entity.User;
//import backend.sintravel.domain.user.exception.UserNotExistException;
//import backend.sintravel.domain.user.model.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//@RequiredArgsConstructor
//public class ArticleService {
//
//    private final ArticleRepository articleRepository;
//    private final UserRepository userRepository;
//    private final BoardRepository boardRepository;
//
//
//    @Transactional
//    public CreateArticleResponse createArticle(
//            Long userId,
//            Long boardId,
//            String title,
//            String content
//    ) {
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new UserNotExistException("존재 하지 않는 회원입니다"));
//        Board board = boardRepository.findById(boardId)
//                .orElseThrow(() -> new BoardNotExistException("존재하지않는 게시판입니다"));
//
//        Article createArticle = new Article(null, title, content, 0, board, user);
//        articleRepository.save(createArticle);
//
//        CreateArticleResponse createArticleResponse = new CreateArticleResponse(createArticle);
//
//        return createArticleResponse;
//    }
//
//    @Transactional
//    public ArticleResponse getArticle(Long articleId) {
//
//        Article article = articleRepository.findByIdWithUser(articleId)
//                .orElseThrow(() -> new ArticleNotExistException("존재하지 않는 게시글입니다"));
//
//
//        article.increaseViewCount();
//
//        ArticleResponse articleResponse = new ArticleResponse(
//                article.getId(),
//                article.getTitle(),
//                article.getContent(),
//                article.getView_count(),
//                article.getUser().getNickname());
//
//        return articleResponse;
//    }
//
//    @Transactional
//    public void deleteArticle(Long articleId, Long userId) {
//        Article article = articleRepository.findByIdWithUser(articleId)
//                .orElseThrow(() -> new ArticleNotExistException("존재하지 않는 게시글 입니다"));
//
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new UserNotExistException("존재하지 않는 회원입니다"));
//
//        if (article.getUser() != user) {
//            throw new DeleteArticleByNoAuthException();
//        }
//
//        articleRepository.delete(article);
//    }
//
//}
