package edu.pxxy.jyq;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import edu.pxxy.jyq.bean.Food;
import edu.pxxy.jyq.dao.FoodDao;
import edu.pxxy.jyq.dao.impl.FoodDaoImpl;

public class FoodAddActivity extends AppCompatActivity {

    private EditText food_name, food_price, food_count;
    private Button btn_insert;
    MyDBOpenHelper openHelper;
    SQLiteDatabase sqLiteDatabase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_add);
        openHelper = new MyDBOpenHelper(this);
        sqLiteDatabase = openHelper.getReadableDatabase();
        initView();
    }

    private void initView() {
        food_name = findViewById(R.id.food_name);
        food_price = findViewById(R.id.food_price);
        food_count = findViewById(R.id.food_count);
        btn_insert = findViewById(R.id.btn_insert);
        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String foodName = food_name.getText().toString().trim();
                String foodPrice = food_price.getText().toString().trim();
                String count = food_count.getText().toString().trim();
                FoodDaoImpl foodImpl3 = new FoodDaoImpl();
                Food food = new Food();
                food.setFoodName(foodName);
                food.setFoodPrice(Double.parseDouble(foodPrice));
                food.setCount(Integer.parseInt(count));
                foodImpl3.insertFood(food,sqLiteDatabase);
                sendBroadcast(new Intent("main_receiver"));
                Toast.makeText(FoodAddActivity.this,"添加成功",Toast.LENGTH_SHORT).show();
                food_name.setText("");
                food_price.setText("");
                food_count.setText("");
            }
        });
    }

}
