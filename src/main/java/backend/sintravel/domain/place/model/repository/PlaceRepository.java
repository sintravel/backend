package backend.sintravel.domain.place.model.repository;

import backend.sintravel.domain.place.model.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PlaceRepository extends JpaRepository<Place, Long> {

    @Query("select p from Place p where p.place_id = ?1")
    Optional<Place> findByPlace_id(String place_id);
}
