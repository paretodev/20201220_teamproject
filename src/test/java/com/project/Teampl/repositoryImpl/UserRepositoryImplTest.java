package com.project.Teampl.repositoryImpl;

import com.project.Teampl.model.User;
import com.project.Teampl.repository.UserRepository;
import com.project.Teampl.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserRepositoryImplTest {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @Test
    public void signIn() throws Exception {
        //given
        User user = new User();
        user.setUserid("jiwon");
        user.setUsername("이지원");
        user.setUserpw("1qw2");

        //when
        Long savedId = userService.signIn(user);

        //then
        assertEquals(user, userRepository.findOne(savedId));
    }

    @Test
    public void isDuplicateUser() throws Exception {
        //given
        User user1 = new User();
        user1.setUserid("jiwon");

        User user2 = new User();
        user2.setUserid("jiwon");

        //when
        userService.signIn(user1);
        IllegalStateException exception = assertThrows(
          IllegalStateException.class, () -> userService.signIn(user2)
        );

        //then
        assertEquals("이미 존재하는 아이디입니다.", exception.getMessage());
    }


}