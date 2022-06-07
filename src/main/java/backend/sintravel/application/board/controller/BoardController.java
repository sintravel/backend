//package backend.sintravel.application.board.controller;
//
//import backend.sintravel.domain.board.model.dto.BoardInfoResponse;
//import backend.sintravel.domain.board.service.BoardService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/boards")
//@RequiredArgsConstructor
//public class BoardController {
//
//    private final BoardService boardService;
//
//    @GetMapping()
//    @ResponseStatus(HttpStatus.OK)
//    public BoardInfoResponse getBoards() {
//        return boardService.getBoards();
//    }
//
//}
