package com.example.a10.androidpoject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
/// 코드 작성자 홍예지
public class memory_SubActivity extends AppCompatActivity {

    Button goback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_sub);

        //MainActivity.java로부터 전달받은 score변수를 통해 점수를 띄운다
        TextView txt=(TextView)findViewById(R.id.textView);
        goback = (Button)findViewById(R.id.goBack);
        Intent intent=getIntent();
        int score=70+intent.getExtras().getInt("score");
        txt.setText(String.valueOf(score)+"점입니다");

        goback.setOnClickListener(new View.OnClickListener() {
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