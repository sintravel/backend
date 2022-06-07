//package backend.sintravel.domain.board.service;
//
//import backend.sintravel.domain.board.model.dto.BoardInfo;
//import backend.sintravel.domain.board.model.dto.BoardInfoResponse;
//import backend.sintravel.domain.board.model.entity.Board;
//import backend.sintravel.domain.board.model.repository.BoardRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//public class BoardService {
//
//    private final BoardRepository boardRepository;
//
//    public BoardInfoResponse getBoards() {
//        List<Board> boards = boardRepository.findAll();
//
//        List<BoardInfo> boardInfos = boards.stream()
//                .map(board -> new BoardInfo(board))
//                .collect(Collectors.toList());
//
//        return new BoardInfoResponse(boardInfos);
//    }
//}
