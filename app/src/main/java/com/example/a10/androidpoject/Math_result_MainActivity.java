package com.example.a10.androidpoject;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;
import com.example.a10.androidpoject.Math_MainActivity;

/// 코드 작성자 김준엽
public class Math_result_MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_result);

        TextView resulttext=(TextView)findViewById(R.id.textView8);
        Intent intent=getIntent();
        int score1=(intent.getExtras().getInt("score1"))*10;
        resulttext.setText(String.valueOf(score1)+"점입니다");


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//화면의 제목 없애주는 문장
        getSupportActionBar().hide();//화면의 제목 숨겨주는 문장
    }
}
