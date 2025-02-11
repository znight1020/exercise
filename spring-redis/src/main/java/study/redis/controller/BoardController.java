package study.redis.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.redis.entity.Board;
import study.redis.service.BoardService;

@RequiredArgsConstructor
@RequestMapping("/boards")
@RestController
public class BoardController {

  private final BoardService boardService;

  @GetMapping
  public List<Board> getBoards(
      @RequestParam(defaultValue = "1") int page,
      @RequestParam(defaultValue = "10") int size
  ) {
    return boardService.getBoards(page, size);
  }
}
