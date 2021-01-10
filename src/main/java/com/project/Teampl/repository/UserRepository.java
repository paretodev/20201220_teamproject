package com.project.Teampl.repository;

import com.project.Teampl.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    // 회원 가입
    void signIn(User user);

    // 회원 중복 검사를 위한 통한 회원 조회
    List<User> findByUserid(String userid);

    // 인덱스를 통한 회원 조회
    User findOne(Long idx);
}
