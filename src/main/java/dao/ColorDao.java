package dao;

import entity.color;

public interface ColorDao {
    void addColor(color Color);
    color showColor(String UserId);
    void changeColor(color Color);
}
