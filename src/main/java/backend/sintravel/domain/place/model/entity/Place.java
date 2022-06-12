package backend.sintravel.domain.place.model.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
public class Place {

    @Id
    private String id;

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

    private String keword;

    private String evalnum;

    private String rate;
}
