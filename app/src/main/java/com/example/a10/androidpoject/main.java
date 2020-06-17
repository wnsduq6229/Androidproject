package com.example.a10.androidpoject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;
/// 코드 작성자 김준엽
public class main extends AppCompatActivity {
    ImageButton btnOk,btnCancel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);//main.xml 참조

        btnOk=(ImageButton)findViewById(R.id.okButton);
        btnCancel=(ImageButton)findViewById(R.id.cancelButton);
        ///////////////////////////////////////////////////////////////

        ///////////////////////////////////////////////////////////////
        btnOk.setOnClickListener(new View.OnClickListener(){

            //아이디 생성에 관한 조건 체크할것. 아이디가 이미 있는 아이딘지 비밀번호가 올바른지 등 조건 체크하고 완료되면 실행할 수 있도록 할 것.
            @Override
            public void onClick(View v){
                Intent intent = new Intent(
                        getApplicationContext(),Title2_Activity.class);//현재 화면의 제어권자,다음 넘어갈 클래스 지정 main으로 되어 있는걸 2화면으로 만들면 바꿔야함
                startActivity(intent);//다음화면으로 넘어간다.
            }

        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(),main.class);//현재 화면의 제어권자,다음 넘어갈 클래스 지정 main으로 되어 있는걸 2화면으로 만들면 바꿔야함
                startActivity(intent);//다음화면으로 넘어간다.
            }
        });
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//화면의 제목 없애주는 문장
        getSupportActionBar().hide();//화면의 제목 숨겨주는 문장
    }
}
