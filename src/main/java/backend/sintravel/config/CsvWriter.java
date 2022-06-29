//package backend.sintravel.config;
//
//import backend.sintravel.domain.place.model.entity.Place;
//import backend.sintravel.domain.place.model.repository.PlaceRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Configuration
//@RequiredArgsConstructor
//public class CsvWriter implements ItemWriter<CsvLine> {
//    private final PlaceRepository placeRepository;
//
//    @Override
//    public void write(List<? extends CsvLine> list) throws Exception {
////        placeRepository.saveAll(new ArrayList<Place>(list));
//        ArrayList<CsvLine> csvLines = new ArrayList<>(list);
//
//    }
//}
