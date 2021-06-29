package com.community_web.community_web;

import com.community_web.community_web.domain.Board;
import com.community_web.community_web.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findByUser(User user);
}
