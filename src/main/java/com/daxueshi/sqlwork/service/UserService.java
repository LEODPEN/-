package com.daxueshi.sqlwork.service;

import com.daxueshi.sqlwork.domain.User;

public interface UserService {
    Object login(String email,String password);
    void register(User user,String checkcode);
    User findByEmail(String email);
    void updateUser(User user);
    void sendCheckcode(String email);
    void resetPassword(String email,String checkCode,String password);
    void deleteByEmail(String email, String checkCode);

    void follow(String followingEmail, String followedEmail);

    void cancelFollow(String followingEmail, String followedEmail);

    void visit(String followingEmail, String followedEmail);
}
