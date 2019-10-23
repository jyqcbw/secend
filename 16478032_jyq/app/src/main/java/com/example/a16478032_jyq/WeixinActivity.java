package com.example.a16478032_jyq;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a16478004_wxy.R;

public class WeixinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weixin);

        Bundle bundle=this.getIntent().getExtras();
        String name=bundle.getString("name");
        String password=bundle.getString("password");
        TextView tv=findViewById(R.id.weixin);
        tv.setText("欢迎 "+name+" 登录");

    }

}
