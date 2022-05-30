package backend.sintravel.domain.user.model.entity;

import backend.sintravel.domain.common.entity.BaseTimeEntity;
import backend.sintravel.domain.user.UserRole;
import backend.sintravel.domain.user.model.enums.Authority;
import backend.sintravel.domain.user.model.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
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
    @Builder.Default
    @Column
    private Authority authority;
}