package backend.sintravel.domain.user.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Authority {
    USER("ROLE_USER"), ADIMIN("ROLE_ADMIN");

    private String role;
}
