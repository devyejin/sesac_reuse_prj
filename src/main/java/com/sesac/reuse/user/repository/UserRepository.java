package com.sesac.reuse.user.repository;


import com.sesac.reuse.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findByEmail(String email);  // email을 이용해서 회원 정보 찾음
}
