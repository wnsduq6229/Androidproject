/// 코드 작성자 김성수, 홍예지
package com.example.a10.androidpoject;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

public class tip_speed_Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_speed);

        Handler hand = new Handler(); //Handler 생성

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//화면의 제목 없애주는 문장
        getSupportActionBar().hide();//화면의 제목 숨겨주는 문장

        hand.postDelayed(new Runnable() {
            @Override
            public void run(){
                Intent i=new Intent(tip_speed_Activity.this, Title2_2Activity.class);
                startActivity(i);
                finish();
            }
        }, 5000);


    }
}
