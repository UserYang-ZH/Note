package dao;

import entity.UserDate;

public interface UserDateDao {
    void addUserDate(UserDate Date);
    UserDate showUserDate(String UserId);
    void changeUserDate(UserDate Date);
}
