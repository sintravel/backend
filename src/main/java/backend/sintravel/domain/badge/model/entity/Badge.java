package backend.sintravel.domain.badge.model.entity;

import backend.sintravel.domain.common.entity.BaseTimeEntity;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
public class Badge extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "badge_id")
    private Long id;

    private String name;
}
