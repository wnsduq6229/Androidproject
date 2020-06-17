package com.example.a10.androidpoject;
/// 코드 작성자 김준엽,박지현

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

public class Title1_Activity extends AppCompatActivity {
    ImageButton startBtn,exitBtn,idBtn;
    TextView Title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title1);//main.xml 참조

         startBtn=(ImageButton)findViewById(R.id.imageButton); //start 버튼 생성
         exitBtn=(ImageButton)findViewById(R.id.imageButton2); //exit 버튼 생성
        idBtn=(ImageButton)findViewById(R.id.imageButton3);//계정생성 버튼 생성
        //start버튼 누를시 다음 화면으로 넘어가는 액션
         startBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(
                         getApplicationContext(),Title2_2Activity.class);//현재 화면의 제어권자,다음 넘어갈 클래스 지정
                 startActivity(intent);//다음화면으로 넘어간다.
             }
         });

         exitBtn.setOnClickListener(new View.OnClickListener(){
             @Override
             public void onClick(View v){
                 moveTaskToBack(true);//어플 종료 함수
                 finish();//어플종료 함수
                 android.os.Process.killProcess(android.os.Process.myPid());//어플 종료 함수
             }
         });

        idBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(),main.class);//현재 화면의 제어권자,다음 넘어갈 클래스 지정
                startActivity(intent);//다음화면으로 넘어간다.
            }
        });

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//화면의 제목 없애주는 문장
        getSupportActionBar().hide();//화면의 제목 숨겨주는 문장
    }
}
