//package backend.sintravel.domain.article.model.entity;
//
//
//import backend.sintravel.domain.board.model.entity.Board;
//import backend.sintravel.domain.common.entity.BaseTimeEntity;
//import backend.sintravel.domain.user.model.entity.User;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//@Entity
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(name = "article")
//public class Article extends BaseTimeEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "article_id")
//    private Long id;
//
//    @Column(nullable = false)
//    private String title;
//
//    @Column(nullable = false)
//    private String content;
//
//    @Column(name = "view_count")
//    private int view_count;
//
//    @JoinColumn(name = "board_id")
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Board board;
//
//    @JoinColumn(name = "user_id")
//    @ManyToOne(fetch = FetchType.LAZY)
//    private User user;
//
//    public void increaseViewCount() {
//        this.view_count++;
//    }
//}
