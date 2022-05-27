package backend.sintravel.domain.user.model.entity;

import backend.sintravel.domain.common.entity.BaseTimeEntity;
import backend.sintravel.domain.user.UserRole;
import backend.sintravel.domain.user.model.enums.UserType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(length = 80, unique = true)
    private String username;

    private String password;

    @Column(length = 80, unique = true)
    private String nickname;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private UserType type;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private List<UserRole> roles;
}