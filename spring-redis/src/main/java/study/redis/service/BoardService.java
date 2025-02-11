package study.redis.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.redis.entity.Board;
import study.redis.repository.BoardRepository;

@RequiredArgsConstructor
@Service
public class BoardService {

  private final BoardRepository boardRepository;

  @Cacheable(
      cacheNames = "getBoards",
      key = "'boards:page' + #page + ':size' + #size", // key = boards:page:1:size:10
      cacheManager = "boardCacheManager"
  )
  @Transactional(readOnly = true)
  public List<Board> getBoards(int page, int size) {
    Pageable pageable = PageRequest.of(page - 1, size);
    Page<Board> pageOfBoards = boardRepository.findAllByOrderByCreatedAtDesc(pageable);
    return pageOfBoards.getContent();
  }
}
