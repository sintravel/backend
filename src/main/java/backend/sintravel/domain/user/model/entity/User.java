package backend.sintravel.domain.user.model.entity;

import backend.sintravel.domain.common.entity.BaseTimeEntity;
import backend.sintravel.domain.user.model.enums.UserType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column
    private String email;

    private String password;

    private String nickname;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private UserType type;

}