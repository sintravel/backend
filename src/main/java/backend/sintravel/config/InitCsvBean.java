package backend.sintravel.config;

import backend.sintravel.domain.place.model.entity.Place;
import backend.sintravel.domain.place.model.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class InitCsvBean {

    private final PlaceRepository placeRepository;

    @PostConstruct
    public void init() {

        List<List<String>> results = new ArrayList<>();
        ClassPathResource classPathResource = new ClassPathResource("/csv/place2.csv");

        try {
            File csvFile = classPathResource.getFile();
            FileReader fr = new FileReader(csvFile);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
//                ArrayList<String> parsedList = new ArrayList<>();
                String[] parsed = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
//                for (String a : parsed) {
//                    parsedList.add(a);
//                }
//                result.add(parsedList);
                results.add(Arrays.asList(parsed));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Place place = new Place();

        for(List<String> resultOne : results) {
            ArrayList<String> placeFields = new ArrayList<>(resultOne);
            place.createPlace(placeFields);
            placeRepository.save(place);
        }

    }


}
