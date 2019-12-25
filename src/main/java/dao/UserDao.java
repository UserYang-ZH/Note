package dao;

import entity.user;

public interface UserDao {
    void addUser(user User);
    user[] findUser(String UserName);
    user[] allUser();
    void changeUser(user User);
}
