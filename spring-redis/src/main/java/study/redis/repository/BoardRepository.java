package study.redis.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import study.redis.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

  Page<Board> findAllByOrderByCreatedAtDesc(Pageable pageable);
}
