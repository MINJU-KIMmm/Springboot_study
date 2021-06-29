package com.community_web.community_web;

import com.community_web.community_web.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositzory extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
