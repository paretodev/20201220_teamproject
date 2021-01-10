package com.project.Teampl.service;


import com.project.Teampl.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User save(User user);

    Long signIn(User user);

    User findById(int useridx);

    void deleteById(int useridx);

    void updateById(int useridx, User user);

}
