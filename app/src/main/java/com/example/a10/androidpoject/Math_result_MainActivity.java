package com.example.a10.androidpoject;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import com.example.a10.androidpoject.Math_MainActivity;

/// 코드 작성자 김준엽
public class Math_result_MainActivity extends AppCompatActivity {
    Button goback1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_result);

        goback1=(Button)findViewById(R.id.goBack1);
        TextView resulttext=(TextView)findViewById(R.id.textView8);
        Intent intent=getIntent();
        int score1=(intent.getExtras().getInt("score1"))*10;
        resulttext.setText(String.valueOf(score1)+"점입니다");

        goback1.setOnClickListener(new View.OnClickListener() {
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
