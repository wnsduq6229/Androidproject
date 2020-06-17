package com.example.a10.androidpoject;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

public class memory_Description extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_description);

        Handler hand=new Handler();
        hand.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(memory_Description.this, memory_MainActivity.class);
                startActivity(i);
                finish();
            }

        },5000);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//화면의 제목 없애주는 문장
        getSupportActionBar().hide();//화면의 제목 숨겨주는 문장
    }
}