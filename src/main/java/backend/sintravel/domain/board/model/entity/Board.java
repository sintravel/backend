package backend.sintravel.domain.board.model.entity;

import backend.sintravel.domain.common.entity.BaseTimeEntity;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

}