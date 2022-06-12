package backend.sintravel.domain.place.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
public class Place {

    @Id
    private String place_id;

    private String place_name;

    private String category_name;

    private String category_group_code;

    private String category_group_name;

    private String phone;

    private String address_name;

    private String road_address_name;

    private String x;

    private String y;

    private String place_url;

    private String distance;

    private String wheelchair;

    private String animal;

    private String keyword;

    private String evalnum;

    private String rate;

    public void createPlace(List<String> placeFields) {
        this.place_id = placeFields.get(0);
        this.place_name = placeFields.get(1);
        this.category_name = placeFields.get(2);
        this.category_group_code = placeFields.get(3);
        this.category_group_name= placeFields.get(4);
        this.phone = placeFields.get(5);
        this.address_name = placeFields.get(6);
        this.road_address_name = placeFields.get(7);
        this.x = placeFields.get(8);
        this.y = placeFields.get(9);
        this.place_url = placeFields.get(10);
        this.distance = placeFields.get(11);
        this.wheelchair = placeFields.get(12);
        this.animal = placeFields.get(13);
        this.keyword = placeFields.get(14);
        this.evalnum = placeFields.get(15);
        this.rate = placeFields.get(16);
    }
}
