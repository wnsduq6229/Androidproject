package com.example.a10.androidpoject;
/// 코드 작성자 김준엽
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Math_MainActivity extends AppCompatActivity {
    ImageButton btnPlus,btnMinus,btnMultiply,btnDivion;
    TextView problem;//문제를 나타내는 변수
    TextView scoreboard;//정답을 나타내는 변수
    Handler mHandler = new Handler();
    ImageView imageV;
    Random rnd = new Random(System.currentTimeMillis());
    int p1 = rnd.nextInt(15)+1;//1부터 50 까지 랜덤 변수 생성
    int p2 = rnd.nextInt(15)+1;//1부터 50 까지 랜덤 변수 생성
    int p3 = rnd.nextInt(15)+1;//1부터 50 까지 랜덤 변수 생성 문제 2단계를 위한 변수
    int result=0;//결과 값을 저장하기위한 변수
    int cnt=0;
    int cntProblem=0;//문제 난이도 설정을 위한 카운트 변수
    int choose1= rnd.nextInt(4)+1;// 4가지 케이스의 결과값중 하나를 선택하기 위한 변수
    public int score=0;
    public static Context context;//다른 액티비티에 변수 전달하기 위한 변수.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_main);
        btnPlus = (ImageButton) findViewById(R.id.Btn1);//+버튼 생성
        btnMinus =(ImageButton) findViewById(R.id.Btn2);//-버튼 생성
        btnMultiply=(ImageButton) findViewById(R.id.Btn3);//*버튼 생성
        btnDivion=(ImageButton) findViewById(R.id.Btn4);// /버튼 생성
        problem=(TextView)findViewById(R.id.textView);// 문제 나타내는 textview 생성
        imageV=(ImageView)findViewById(R.id.imageView);//이미지 변수 생성
        scoreboard=(TextView)findViewById(R.id.textView2);
/////////////////////////////////////////////////////////////////////
        context=this;
        problemText(p1, p2,p3, choose1);//문제 출력함수
        scoreboard.setText(" "+score);
/*
        if(cntProblem==10)
        {
            problem.setText("종료!!!");
            Intent intent = new Intent(
              getApplicationContext(),resultPage.class);//다음 넘어갈 클래스 지정
            startActivity(intent);//다음화면으로 넘어감

        }
        */
        ///////////////////////////////////////////////////////////////////

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Checkbtn(p1,p2,p3,result,1);

                Handler hand=new Handler();//문제를 반복해서 호출하기 위한 핸들러변수
                hand.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        rnd.setSeed(System.currentTimeMillis());//시드값 재설정
                        p1=rnd.nextInt(15)+1;//1부터 50 까지 랜덤 변수 재설정
                        p2=rnd.nextInt(15)+1;//1부터 50 까지 랜덤 변수 재설정
                        p3 = rnd.nextInt(15)+1;//1부터 50 까지 랜덤 변수 생성 문제 2단계를 위한 변수
                        choose1=rnd.nextInt(4)+1;//선택경우 재설정

                        problemText(p1, p2,p3, choose1);//문제 재출력
                    }
                },2000);//2초있다가 다시 실행


                if(cntProblem>=10)
                {
                    Intent intent = new Intent(
                            getApplicationContext(),Math_result_MainActivity.class);//현재 화면의 제어권자,결과창으로 이동
                    startActivity(intent);//다음화면으로 넘어간다.
                }
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Checkbtn(p1,p2,p3,result,2);
                Handler hand=new Handler();//문제를 반복해서 호출하기 위한 핸들러변수
                hand.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        rnd.setSeed(System.currentTimeMillis());//시드값 재설정
                        p1=rnd.nextInt(15)+1;//1부터 50 까지 랜덤 변수 재설정
                        p2=rnd.nextInt(15)+1;//1부터 50 까지 랜덤 변수 재설정
                        p3 = rnd.nextInt(15)+1;//1부터 50 까지 랜덤 변수 생성 문제 2단계를 위한 변수
                        choose1=rnd.nextInt(4)+1;//선택경우 재설정
                        problemText(p1, p2,p3,choose1);//문제 재출력
                    }
                },2000);//2초있다가 다시 실행

                if(cntProblem>=10)
                {
                    Intent intent = new Intent(
                            getApplicationContext(),Math_result_MainActivity.class);//현재 화면의 제어권자,결과창으로 이동
                    startActivity(intent);//다음화면으로 넘어간다.
                }
            }
        });
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Checkbtn(p1,p2,p3,result,3);
                Handler hand=new Handler();
                hand.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        rnd.setSeed(System.currentTimeMillis());//시드값 재설정
                        p1=rnd.nextInt(15)+1;//1부터 50 까지 랜덤 변수 재설정
                        p2=rnd.nextInt(15)+1;//1부터 50 까지 랜덤 변수 재설정
                        p3 = rnd.nextInt(15)+1;//1부터 50 까지 랜덤 변수 생성 문제 2단계를 위한 변수
                        choose1=rnd.nextInt(4)+1;//선택경우 재설정
                        problemText(p1, p2,p3, choose1);//문제 재출력
                    }
                },2000);//2초있다가 다시 실행
                if(cntProblem>=10)
                {
                    Intent intent = new Intent(
                            getApplicationContext(),Math_result_MainActivity.class);//현재 화면의 제어권자,결과창으로 이동
                    startActivity(intent);//다음화면으로 넘어간다.
                }
            }
        });
        btnDivion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Checkbtn(p1,p2,p3,result,4);
                Handler hand=new Handler();
                hand.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        rnd.setSeed(System.currentTimeMillis());//시드값 재설정
                        p1=rnd.nextInt(15)+1;//1부터 50 까지 랜덤 변수 재설정
                        p2=rnd.nextInt(15)+1;//1부터 50 까지 랜덤 변수 재설정
                        p3 = rnd.nextInt(15)+1;//1부터 50 까지 랜덤 변수 생성 문제 2단계를 위한 변수
                        choose1=rnd.nextInt(4)+1;//선택경우 재설정
                        problemText(p1, p2,p3, choose1);//문제 재출력
                    }
                },2000);//2초있다가 다시 실행

                if(cntProblem>=10)
                {
                    Intent intent = new Intent(
                            getApplicationContext(),Math_result_MainActivity.class);//현재 화면의 제어권자,결과창으로 이동
                    startActivity(intent);//다음화면으로 넘어간다.
                }
            }
        });
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//화면의 제목 없애주는 문장
        getSupportActionBar().hide();//화면의 제목 숨겨주는 문장
    }

    public void rabbitImg(int i)
    {
        switch(i){
            case 0://기쁜 토끼
                imageV.setImageResource(R.drawable.happyrabbit);
                break;
            case 1://슬픈 토끼
                imageV.setImageResource(R.drawable.sadrabbit);
                break;
            case 2://화난 토끼
                imageV.setImageResource(R.drawable.angryrabbit);
                break;
            case 3://일반 토끼
                imageV.setImageResource(R.drawable.rabbit);
                break;

        }
    }

    public void problemText(int p1, int p2,int p3, int choose1){
        switch (choose1) {
            case 1:
                if(cntProblem<5) {
                    result = p1 + p2;
                    //선택되었으니 문제를 출력해줘야함
                    problem.setText(p1 + " □ " + p2 + " = " + result);
                }
                else
                {
                    result = p1 + p2 + p3;
                    problem.setText(p1 + " □ " + p2 + " + "+ p3 + " = " + result);
                }
                break;
            case 2:
                if(cntProblem<5) {
                    result = p1 - p2;
                    problem.setText(p1 + " □ " + p2 + " = " + result);
                }
                else{
                    result = p1 + p2 - p3;
                    problem.setText(p1 + " + " + p2 + " □ " + p3 + " = " + result);
                }
                break;
            case 3:
                if(cntProblem<5) {
                    result = p1 * p2;
                    //선택되었으니 문제를 출력해줘야함
                    problem.setText(p1 + " □ " + p2 + " = " + result);
                }
                else
                {
                    result = p1 + p2 * p3;
                    problem.setText(p1 +" + " + p2 + " □ " + p3 + " = " + result);
                }
                break;
            case 4:
                if(cntProblem<5) {
                    result = p1 / p2;
                    //결과값을 double로 바꿔서 계산해서 검사
              /*
                if((p1%p2)!=0)//나누어 떨어지지 않을때 다시계산하게 해야됨. 어떻게?
                {
                    Handler hand=new Handler();
                    hand.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                           problemText(p1,p2,choose1);
                                }
                    },2000);//2초있다가 다시 실행
                }
                //선택되었으니 문제를 출력해줘야함
                */
                    problem.setText(p1 + " □ " + p2 + " = " + result);
                }
                else
                {
                    result = p1 + p2 / p3;
                    problem.setText(p1 + "+" + p2 + " □ " + p3 + " = " + result);
                }
                break;
        }

    }

    public void Checkbtn(int x, int y, int z, int r, int choose){
        switch(choose){//버튼의 연산자 맞는지 체크해야함.
            case 1:
                if(cntProblem<5) {
                    if ((x + y) == r) {
                        problem.setText(" 정답!!");
                        score++;//점수증가
                        cntProblem++;//다음 난이도/문제종료로 넘어가는걸 체크하기 위한 카운트변수
                        scoreboard.setText(" " + score);
                        rabbitImg(0);//기쁜 토끼 이미지
                    } else {
                        problem.setText(" 오답!");
                        rabbitImg(1);//슬픈토끼 이미지
                        cntProblem++;//다음 난이도/문제종료로 넘어가는걸 체크하기 위한 카운트변수
                    }
                }
                else{
                    if((x+y+z)==r){
                        problem.setText(" 정답!!");
                        score++;//점수증가
                        cntProblem++;//다음 난이도로 넘어가는걸 체크하기 위한 카운트변수
                        scoreboard.setText(" " + score);
                        rabbitImg(0);//기쁜 토끼 이미지
                    }
                    else{
                        problem.setText(" 오답!");
                        rabbitImg(1);//슬픈토끼 이미지
                        cntProblem++;//다음 난이도/문제종료로 넘어가는걸 체크하기 위한 카운트변수
                    }
                }
                break;
            case 2:
                if(cntProblem<5) {
                    if ((x - y) == r) {
                        problem.setText(" 정답!");
                        score++;//점수증가
                        cntProblem++;//다음 난이도로 넘어가는걸 체크하기 위한 카운트변수
                        scoreboard.setText(" " + score);
                        rabbitImg(0);//기쁜 토끼 이미지
                    } else {
                        problem.setText(" 오답!");
                        rabbitImg(3);//화난 토끼 이미지
                        cntProblem++;//다음 난이도/문제종료로 넘어가는걸 체크하기 위한 카운트변수
                    }
                }
                else
                {
                    if((x+y-z)==r)
                    {
                        problem.setText(" 정답!");
                        score++;//점수증가
                        cntProblem++;//다음 난이도로 넘어가는걸 체크하기 위한 카운트변수
                        scoreboard.setText(" " + score);
                        rabbitImg(0);//기쁜 토끼 이미지
                    }
                    else
                    {
                        problem.setText(" 오답!");
                        rabbitImg(3);//화난 토끼 이미지
                        cntProblem++;//다음 난이도/문제종료로 넘어가는걸 체크하기 위한 카운트변수
                    }
                }
                break;
            case 3:
                if(cntProblem<5) {
                    if ((x * y) == r) {
                        problem.setText("정답!");
                        score++;//점수증가
                        cntProblem++;//다음 난이도로 넘어가는걸 체크하기 위한 카운트변수
                        scoreboard.setText(" " + score);
                        rabbitImg(0);//기쁜 토끼 이미지
                    } else {
                        problem.setText(" 오답!");
                        rabbitImg(3);//화난 토끼 이미지
                        cntProblem++;//다음 난이도/문제종료로 넘어가는걸 체크하기 위한 카운트변수
                    }
                }
                else{
                    if((x+y*z)==r)
                    {
                        problem.setText("정답!");
                        score++;//점수증가
                        cntProblem++;//다음 난이도로 넘어가는걸 체크하기 위한 카운트변수
                        scoreboard.setText(" " + score);
                        rabbitImg(0);//기쁜 토끼 이미지
                    }
                    else
                    {
                        problem.setText(" 오답!");
                        rabbitImg(3);//화난 토끼 이미지
                        cntProblem++;//다음 난이도/문제종료로 넘어가는걸 체크하기 위한 카운트변수
                    }
                }
                break;
            case 4:
                if(cntProblem<5) {
                    if ((x / y) == r) {
                        problem.setText(" 정답!");
                        score++;//점수증가
                        cntProblem++;//다음 난이도로 넘어가는걸 체크하기 위한 카운트변수
                        scoreboard.setText(" " + score);
                        rabbitImg(0);//기쁜 토끼 이미지
                    } else {
                        problem.setText(" 오답!");
                        rabbitImg(2);//슬픈 토끼 이미지
                        cntProblem++;//다음 난이도/문제종료로 넘어가는걸 체크하기 위한 카운트변수
                    }
                }
                else
                {
                    if((x+y/z)==r)
                    {
                        problem.setText(" 정답!");
                        score++;//점수증가
                        cntProblem++;//다음 난이도로 넘어가는걸 체크하기 위한 카운트변수
                        scoreboard.setText(" " + score);
                        rabbitImg(0);//기쁜 토끼 이미지
                    }
                    else{
                        problem.setText(" 오답!");
                        rabbitImg(2);//슬픈 토끼 이미지
                        cntProblem++;//다음 난이도/문제종료로 넘어가는걸 체크하기 위한 카운트변수
                    }
                }
                break;
        }
    }
}