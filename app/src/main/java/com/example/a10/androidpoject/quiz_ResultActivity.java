package com.example.a10.androidpoject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;


public class quiz_ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView showresult = findViewById(R.id.textView);
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
        int rightAnswerCount=intent.getExtras().getInt("rightAnswerCount");
        showresult.setText(String.valueOf(rightAnswerCount)+"점입니다");

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//화면의 제목 없애주는 문장
        getSupportActionBar().hide();//화면의 제목 숨겨주는 문장
    }
}