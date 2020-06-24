package com.example.a10.androidpoject;
/// 코드 작성자 김준엽,박지현
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

public class Title2_2Activity extends AppCompatActivity {
    ImageButton btnMathgame,btnOngame,btnMemorygame,btnQuizgame;
    ImageButton btnRankgame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title2_2);

        btnMathgame=(ImageButton)findViewById(R.id.goMath);
        btnMemorygame=(ImageButton)findViewById(R.id.goMemory);
        btnOngame=(ImageButton)findViewById(R.id.goOn);
        btnQuizgame=(ImageButton)findViewById(R.id.goQuiz);
        btnRankgame=(ImageButton)findViewById(R.id.rank);

        btnMathgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(),Math_description_MainActivity.class);//현재 화면의 제어권자,다음 넘어갈 클래스 지정
                startActivity(intent);//다음화면으로 넘어간다.
            }
        });

        btnOngame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(),onetofifty_description.class);//현재 화면의 제어권자,다음 넘어갈 클래스 지정. 바꿔야댐
                startActivity(intent);//다음화면으로 넘어간다.
            }
        });
        btnMemorygame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(),memory_Description.class);//바꿔야댐
                startActivity(intent);//다음화면으로 넘어간다.
            }
        });
        btnQuizgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(),quiz_description.class);//현재 화면의 제어권자,다음 넘어갈 클래스 지정. 바꿔야댐
                startActivity(intent);//다음화면으로 넘어간다.
            }
        });
        btnRankgame.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(
                        getApplicationContext(), MainActivity.class);
                startActivity(intent1);
            }
        });
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//화면의 제목 없애주는 문장
        getSupportActionBar().hide();//화면의 제목 숨겨주는 문장
    }
}