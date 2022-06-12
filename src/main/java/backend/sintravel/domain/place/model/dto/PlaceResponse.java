package backend.sintravel.domain.place.model.dto;

import backend.sintravel.domain.place.model.entity.Place;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class PlaceResponse {
    private ArrayList<PlaceDto> places;

    public PlaceResponse(ArrayList<PlaceDto> placeDtos) {
        this.places = placeDtos;
    }
}
