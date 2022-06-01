package backend.sintravel.domain.board.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoardInfoResponse {
    private List<BoardInfo> boardInfoList;

}
