package backend.sintravel.domain.user.model.entity;

import backend.sintravel.domain.common.entity.BaseTimeEntity;
import backend.sintravel.domain.survey.model.entity.Result;
import backend.sintravel.domain.user.model.enums.Authority;
import backend.sintravel.domain.user.model.enums.UserType;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 80, unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(length = 80, unique = true)
    private String nickname;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private UserType type;

    @Enumerated(EnumType.STRING)
    @Column
    private Authority authority;

    public void insertUserType(UserType userType) {

        this.type = userType;
    }
}