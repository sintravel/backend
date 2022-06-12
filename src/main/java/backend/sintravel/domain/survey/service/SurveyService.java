package backend.sintravel.domain.survey.service;

import backend.sintravel.domain.place.exception.NotFoundPlaceException;
import backend.sintravel.domain.place.model.dto.PlaceDto;
import backend.sintravel.domain.place.model.dto.PlaceResponse;
import backend.sintravel.domain.place.model.dto.RecommendPlaceDto;
import backend.sintravel.domain.place.model.entity.Place;
import backend.sintravel.domain.place.model.repository.PlaceRepository;
import backend.sintravel.domain.survey.model.entity.Result;
import backend.sintravel.domain.survey.model.repository.ResultRepository;
import backend.sintravel.domain.user.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SurveyService {

    private final ResultRepository resultRepository;
    private final PlaceRepository placeRepository;

    @Transactional
    public PlaceResponse executeSurvey(int answer_01,
                                       int answer_02,
                                       int answer_03,
                                       User user) {

        Result result = new Result(null,answer_01, answer_02, answer_03, user);

        resultRepository.save(result);

        try {
            processAlgorithm("27139183", "CT1");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //QueryDsl로 refactoring 예정
        ArrayList<RecommendPlaceDto> recommendPlaceDtos = new ArrayList<>();
        parseResultCsv(recommendPlaceDtos);

        Place place1 = placeRepository.findByPlace_id(recommendPlaceDtos.get(1).getPlace_id())
                .orElseThrow(() -> new NotFoundPlaceException("장소를 차지 못했습니다"));
        Place place2 = placeRepository.findByPlace_id(recommendPlaceDtos.get(2).getPlace_id())
                .orElseThrow(() -> new NotFoundPlaceException("장소를 차지 못했습니다"));
        Place place3 = placeRepository.findByPlace_id(recommendPlaceDtos.get(3).getPlace_id())
                .orElseThrow(() -> new NotFoundPlaceException("장소를 차지 못했습니다"));
        Place place4 = placeRepository.findByPlace_id(recommendPlaceDtos.get(4).getPlace_id())
                .orElseThrow(() -> new NotFoundPlaceException("장소를 차지 못했습니다"));
        Place place5 = placeRepository.findByPlace_id(recommendPlaceDtos.get(5).getPlace_id())
                .orElseThrow(() -> new NotFoundPlaceException("장소를 차지 못했습니다"));

        ArrayList<PlaceDto> placeDtos = new ArrayList<>();
        placeDtos.add(new PlaceDto(place1));
        placeDtos.add(new PlaceDto(place2));
        placeDtos.add(new PlaceDto(place3));
        placeDtos.add(new PlaceDto(place4));
        placeDtos.add(new PlaceDto(place5));

        return new PlaceResponse(placeDtos);
    }

    private void processAlgorithm(String place_id, String category_group_code) throws IOException, InterruptedException{
        ArrayList<String> valueList = new ArrayList<>();

        String path = System.getProperty("user.dir");

        valueList.add("cmd.exe");
        valueList.add("/c");
        valueList.add("python");
        valueList.add("recommend.py");
        valueList.add(place_id);
        valueList.add(category_group_code);
        valueList.add("0");

        ProcessBuilder processBuilder = new ProcessBuilder(valueList).directory(new File(path + "/python_workplace"));

        Process start = processBuilder.start();

        start.waitFor();
    }

    private void parseResultCsv(List<RecommendPlaceDto> recommendPlaceDtos) {

        List<List<String>> results = new ArrayList<>();

        try {
            File csvFile = new File("C:\\Users\\user\\Downloads\\sintravel\\sintravel\\python_workplace\\rcmd27139183.csv");
            FileReader fr = new FileReader(csvFile);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                String[] parsed = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                results.add(Arrays.asList(parsed));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(List<String> resultOne : results) {
            ArrayList<String> placeFields = new ArrayList<>(resultOne);
            recommendPlaceDtos.add(new RecommendPlaceDto(placeFields.get(0), placeFields.get(1)));
        }

    }




}
