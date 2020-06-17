package com.example.a10.androidpoject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class quiz_ResultActivity extends AppCompatActivity {
    Button goback2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView showresult = findViewById(R.id.textView);
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
        int rightAnswerCount=intent.getExtras().getInt("rightAnswerCount");
        showresult.setText(String.valueOf(rightAnswerCount)+"점입니다");
        goback2 = (Button)findViewById(R.id.goBack2);

        goback2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(),Title2_2Activity.class);//현재 화면의 제어권자,다음 넘어갈 클래스 지정
                startActivity(intent);//다음화면으로 넘어간다.
            }
        });
    }
}