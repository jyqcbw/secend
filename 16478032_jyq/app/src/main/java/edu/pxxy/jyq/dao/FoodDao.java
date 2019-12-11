package edu.pxxy.jyq.dao;

import android.database.sqlite.SQLiteDatabase;
import java.util.List;

import edu.pxxy.jyq.bean.Food;

public interface FoodDao {
    List<Food> findAllFood(SQLiteDatabase sqLiteDatabase);
    List<Food> findFoodByName(String foodName,SQLiteDatabase sqLiteDatabase);
    Long insertFood(Food food,SQLiteDatabase sqLiteDatabase);
    int deleteFood(String foodName,SQLiteDatabase sqLiteDatabase);
    int updateFoodPrice(String foodName,SQLiteDatabase sqLiteDatabase);
}
