package com.project.Teampl.serviceImpl;

import com.project.Teampl.exception.ResourceNotFoundException;
import com.project.Teampl.model.User;
import com.project.Teampl.repository.UserRepository;
import com.project.Teampl.repositoryImpl.UserRepositoryImpl;
import com.project.Teampl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    // 회원 중복검사
    private void isDuplicateUser(User user) {
        // 예외처리(Exception)
        List<User> findUsers = userRepository.findByUserid(user.getUserid());
        if(!findUsers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 아이디입니다.");
        }
    }
    // 회원 가입
    @Override
    @Transactional
    public Long signIn(User user) {
        isDuplicateUser(user);
        userRepository.signIn(user);
        return user.getIdx();
    }

    // 회원 1명 조회
    @Transactional(readOnly = true)
    public User findOne(Long idx) {
        return userRepository.findOne(idx);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll(){
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(e->users.add(e));
        return users;
    }

    @Override
    public User findById(int useridx) {
        User user = userRepository.findById(useridx).orElseThrow(()-> new ResourceNotFoundException("User", "useridx",useridx));
        return user;
    }

    @Override
    public void deleteById(int useridx) {
        userRepository.deleteById(useridx);
    }

    @Override
    public User save(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public void updateById(int useridx, User user) {
        User localUser = userRepository.findById(useridx).orElseThrow(()-> new ResourceNotFoundException("User", "useridx",useridx));
        localUser.setUsername(user.getUsername());
        localUser.setUserpw((user.getUserpw()));
        userRepository.save(user);
    }
}
