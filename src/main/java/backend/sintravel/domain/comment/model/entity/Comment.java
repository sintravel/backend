//package backend.sintravel.domain.comment.model.entity;
//
//import backend.sintravel.domain.article.model.entity.Article;
//import backend.sintravel.domain.user.model.entity.User;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//
//@Entity
//@Setter
//public class Comment {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "comment_id")
//    private Long id;
//
//    @Column(nullable = false)
//    private String content;
//
//    @JoinColumn(name = "parent_id")
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Comment parent;
//
//    @OneToMany(mappedBy = "parent")
//    private ArrayList<Comment> child;
//
//    @JoinColumn(name = "user_id")
//    @ManyToOne(fetch = FetchType.LAZY)
//    private User user;
//
//    @JoinColumn(name = "article_id")
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Article article;
//}
