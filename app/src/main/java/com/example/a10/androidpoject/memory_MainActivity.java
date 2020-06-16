package com.example.a10.androidpoject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class memory_MainActivity extends AppCompatActivity {

    int i=0;//문제 번호 변수. (o/x)클릭 시마다 1씩 증가한다
    int score=0;//점수 저장 변수. (0~28) 한문제 정답시마다 1씩 증가한다
    ImageView imageview=null;//패턴 이미지 변수
    //30개의 패턴 이미지를 저장하는 이미지소스 배열
    int imageResources[]={R.drawable.pattern1,R.drawable.pattern2,R.drawable.pattern3,R.drawable.pattern4,R.drawable.pattern5,R.drawable.pattern6,R.drawable.pattern7,R.drawable.pattern8,R.drawable.pattern9,R.drawable.pattern10,
            R.drawable.pattern11,R.drawable.pattern12,R.drawable.pattern13,R.drawable.pattern14,R.drawable.pattern15,R.drawable.pattern16,R.drawable.pattern17,R.drawable.pattern18,R.drawable.pattern19,R.drawable.pattern20,
            R.drawable.pattern21,R.drawable.pattern22,R.drawable.pattern23,R.drawable.pattern24,R.drawable.pattern25,R.drawable.pattern26,R.drawable.pattern27,R.drawable.pattern28,R.drawable.pattern29,R.drawable.pattern30};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_main);


        final Button button_n=(Button)findViewById(R.id.button_n);//첫번째, 두번째에 다음 문제로 넘어가는 버튼. 이후에 사라진다
        final Button button_o=(Button)findViewById(R.id.button_o);//o버튼
        final Button button_x=(Button)findViewById(R.id.button_x);//x버튼
        imageview=(ImageView)findViewById(R.id.image_ptn);//패턴 이미지

//        첫번째, 두번째 패턴 보이는 버튼 이벤트
        button_n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                imageview.setImageResource(imageResources[i]);
                if(i==2){
                    button_n.setVisibility(View.GONE);
                    button_o.setVisibility(View.VISIBLE);
                    button_x.setVisibility(View.VISIBLE);
                }
            }
        });
        //o버튼 클릭시 정답/오답 처리, 다음 패턴 이미지로 변경
        button_o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                if(i==3||i==7||i==9||i==10||i==12||i==15||i==16||i==17||i==19||i==22||i==24||i==28){
                    score++;
                    imageview.setImageResource(imageResources[i]);
                }
                //i==30는 마지막 문제이므로 점수를 표시하는 SubActivity를 띄운다. 이때 점수 변수인 score 함께 전송
                else if(i==30){
                    score++;
                    Intent intent = new Intent(getApplicationContext(), memory_SubActivity.class);
                    intent.putExtra("score",score);
                    startActivity(intent);
                }
                else{
                    imageview.setImageResource(imageResources[i]);
                }
            }
        });
        //x버튼 클릭시 정답/오답 처리, 다음 패턴 이미지로 변경
        button_x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                if(i==4||i==5||i==6||i==8||i==11||i==13||i==14||i==18||i==20||i==21||i==23||i==25||i==26||i==27||i==29){
                    score++;
                }
                imageview.setImageResource(imageResources[i]);
            }
        });
    }
}