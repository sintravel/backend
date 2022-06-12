package backend.sintravel.application.survey.api;

import backend.sintravel.application.survey.dto.request.SurveyResultRequest;
import backend.sintravel.auth.security.UserAdaptor;
import backend.sintravel.domain.place.model.dto.PlaceResponse;
import backend.sintravel.domain.survey.service.SurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SurveyController {

    private final SurveyService surveyService;

    @PostMapping("/survey")
    @ResponseStatus(HttpStatus.OK)
    public PlaceResponse executeSurvey(@RequestBody SurveyResultRequest surveyResultRequest,
                                       @AuthenticationPrincipal UserAdaptor userAdaptor) {

        return surveyService.executeSurvey(surveyResultRequest.getAnswer_01(),
                surveyResultRequest.getAnswer_02(),
                surveyResultRequest.getAnswer_03(),
                userAdaptor.getUser());
    }
}
