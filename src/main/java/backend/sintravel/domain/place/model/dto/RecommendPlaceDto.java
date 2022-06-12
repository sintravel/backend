package backend.sintravel.domain.place.model.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RecommendPlaceDto {
    private String place_id;

    private String category_group_code;
}
