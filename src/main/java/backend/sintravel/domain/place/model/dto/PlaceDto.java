package backend.sintravel.domain.place.model.dto;

import backend.sintravel.domain.place.model.entity.Place;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PlaceDto {
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

    public PlaceDto(Place place) {
        this.place_id = place.getPlace_id();
        this.place_name = place.getPlace_name();
        this.category_name = place.getCategory_name();
        this.category_group_code = place.getCategory_group_code();
        this.category_group_name= place.getCategory_group_name();
        this.phone = place.getPhone();
        this.address_name = place.getAddress_name();
        this.road_address_name = place.getRoad_address_name();
        this.x = place.getX();
        this.y = place.getY();
        this.place_url = place.getPlace_url();
        this.distance = place.getDistance();
        this.wheelchair = place.getWheelchair();
        this.animal = place.getAnimal();
        this.keyword = place.getKeyword();
        this.evalnum = place.getEvalnum();
        this.rate = place.getRate();
    }
}
