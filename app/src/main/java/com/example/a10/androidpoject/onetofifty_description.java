package com.example.a10.androidpoject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;


public class onetofifty_description extends AppCompatActivity {
    Button gooneMain,gooneBack;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onetofifty_description);
        gooneMain=(Button)findViewById(R.id.oneMain);
        gooneBack=(Button)findViewById(R.id.oneBack);

        gooneMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(),onetofifty_MainActivity.class);//현재 화면의 제어권자,다음 넘어갈 클래스 지정
                startActivity(intent);//다음화면으로 넘어간다.
            }
        });

        gooneBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(),Title2_2Activity.class);//현재 화면의 제어권자,다음 넘어갈 클래스 지정
                startActivity(intent);//다음화면으로 넘어간다.
            }
        });

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//화면의 제목 없애주는 문장
        getSupportActionBar().hide();//화면의 제목 숨겨주는 문장
    }
}
