package edu.pxxy.jyq;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import edu.pxxy.jyq.bean.Food;
import edu.pxxy.jyq.dao.impl.FoodDaoImpl;
import edu.pxxy.jyq.adapter.FoodAdapter;

public class MainActivity extends AppCompatActivity {
    //项目地址：https://github.com/jyqcbw/secend.git
    MyDBOpenHelper openHelper;
    SQLiteDatabase sqLiteDatabase;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //创建数据库
        openHelper = new MyDBOpenHelper(this);
        sqLiteDatabase = openHelper.getReadableDatabase();
        //initData();
       /* List<Food> foodList  = new FoodDaoImpl().findAllFood(sqLiteDatabase);
        for ( Food food : foodList){
            Log.d("数据：" ,food.getFoodName());
        }*/
        List<Food> foodList  = new FoodDaoImpl().findAllFood(sqLiteDatabase);
        listView  = findViewById(R.id.ls_food);
        listView.setAdapter(new FoodAdapter(this,foodList));

    }
    private void initData() {
        sqLiteDatabase.beginTransaction();
        try{
            sqLiteDatabase.execSQL("insert into food(foodname,foodprice,count)values('小炒肉',20,0)");
            sqLiteDatabase.execSQL("insert into food(foodname,foodprice,count)values('青椒肉丝',24,0)");
            sqLiteDatabase.execSQL("insert into food(foodname,foodprice,count)values('西红柿炒鸡蛋',12,0)");
            sqLiteDatabase.execSQL("insert into food(foodname,foodprice,count)values('红烧鱼头',8,0)");
            sqLiteDatabase.execSQL("insert into food(foodname,foodprice,count)values('红烧猪蹄',25,0)");
            sqLiteDatabase.execSQL("insert into food(foodname,foodprice,count)values('红烧鱼块',18,0)");
            sqLiteDatabase.execSQL("insert into food(foodname,foodprice,count)values('紫菜蛋汤',10,0)");
            sqLiteDatabase.setTransactionSuccessful();
        }finally {
            sqLiteDatabase.endTransaction();
        }
    }
}
