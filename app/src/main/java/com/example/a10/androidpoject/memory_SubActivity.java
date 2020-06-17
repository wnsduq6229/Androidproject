package com.example.a10.androidpoject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.TextView;

public class memory_SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_sub);

        //MainActivity.java로부터 전달받은 score변수를 통해 점수를 띄운다
        TextView txt=(TextView)findViewById(R.id.textView);
        Intent intent=getIntent();
        int score=intent.getExtras().getInt("score");
        txt.setText(String.valueOf(score)+"점입니다");

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//화면의 제목 없애주는 문장
        getSupportActionBar().hide();//화면의 제목 숨겨주는 문장
    }
}