package kr.mjc.lhs.basics.jdbc.user.dao;

import kr.mjc.lhs.basics.jdbc.User;

import java.util.List;

public interface UserDao {
    List<User> listUsers(int count, int page);
    User getUser(int userId);

    User login(String email, String password);

    void addUser(User user);

    int updatePassword(int userId, String currentPassword, String newPassword);

    int deleteUser(int userId, String password);
}
