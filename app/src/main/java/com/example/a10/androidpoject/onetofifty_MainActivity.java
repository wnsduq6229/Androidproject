package com.example.a10.androidpoject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Random;

//코드 작성자 김성수


public class onetofifty_MainActivity extends Activity {


    private static final int MILLISINFUTURE = 11*1000;
    private static final int COUNT_DOWN_INTERVAL = 1000;

    private int count = 10; //남은 시간초 설정
    private TextView countTxt ;
    private CountDownTimer countDownTimer;


    TextView score;
    View[] include = new View[2];
    TextView now_number;
    RelativeLayout[] button = new RelativeLayout[25];
    TextView[] button_text = new TextView[25];
    RelativeLayout ok_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onetofifty_main);
        all_view();
        include[0].setVisibility(View.VISIBLE); //게임 시작과 종료화면 visible set
        include[1].setVisibility(View.GONE);
        countTxt = (TextView)findViewById(R.id.count_txt);
        countDownTimer();
        countDownTimer.start();

        game();
        all_button_click();
    }
    public void countDownTimer(){ //카운트

        countDownTimer = new CountDownTimer(MILLISINFUTURE, COUNT_DOWN_INTERVAL) {
            public void onTick(long millisUntilFinished) {
                countTxt.setText(String.valueOf(count));
                count --;
            }
            public void onFinish() {
                //countTxt.setText(String.valueOf("Finish ."));

                include[1].setVisibility(View.VISIBLE);
                include[0].setVisibility(View.GONE);
                score.setText(Integer.toString(match_number_int)); //카운트 종료시 점수 표시하는 부분  //남은 시간초 + 도달한 숫자로 구성할 방식 // 현재 도달한 숫자만 표시
                //--game();-->
            }
        };
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        try{
            countDownTimer.cancel();
        } catch (Exception e) {}
        countDownTimer=null;
    }

    int number_group1, number_group2;
    private void game() {
        now_number.setText(Integer.toString(match_number_int));


        for(number_group1 = 1; number_group1 <= 2; number_group1++) {
            for(number_group2 = 1; number_group2 <= 25; number_group2++) {
                random();
            }
        }
        for(int print_button_num = 0; print_button_num <= 24; print_button_num++) {
            button_text[print_button_num].setText(Integer.toString(button_number_01[print_button_num]));
        }
    }
    int match_number_int = 1; //다음에 클릭해야 할 숫자 -> 게임종료후 점수와 연관된 부분
    int random_button_number_int;
    int[] button_number_01 = new int[25];
    int[] button_number_02 = new int[25];
    private void random() {               //랜덤으로 숫자 출력
        Random random = new Random();
        random_button_number_int = random.nextInt(25);
        if(number_group1 == 1 && button_number_01[(random_button_number_int)] == 0) {
            button_number_01[(random_button_number_int)] = number_group2;
        }else if(number_group1 == 1 && number_group2 <= 25){
            random();
        }
        if(number_group1 == 2 && button_number_02[(random_button_number_int)] == 0) {
            button_number_02[(random_button_number_int)] = (number_group2+25);
        }else if(number_group1 == 2 && number_group2 <= 25){
            random();
        }
    }
    private void all_view() {
        include[0] = findViewById(R.id.include_game_view);
        include[1] = findViewById(R.id.include_success_view);
        now_number = (TextView)findViewById(R.id.now_number);
        score = (TextView)findViewById(R.id.score);
        button[0] = (RelativeLayout)findViewById(R.id.button_1);
        button[1] = (RelativeLayout)findViewById(R.id.button_2);
        button[2] = (RelativeLayout)findViewById(R.id.button_3);
        button[3] = (RelativeLayout)findViewById(R.id.button_4);
        button[4] = (RelativeLayout)findViewById(R.id.button_5);
        button[5] = (RelativeLayout)findViewById(R.id.button_6);
        button[6] = (RelativeLayout)findViewById(R.id.button_7);
        button[7] = (RelativeLayout)findViewById(R.id.button_8);
        button[8] = (RelativeLayout)findViewById(R.id.button_9);
        button[9] = (RelativeLayout)findViewById(R.id.button_10);
        button[10] = (RelativeLayout)findViewById(R.id.button_11);
        button[11] = (RelativeLayout)findViewById(R.id.button_12);
        button[12] = (RelativeLayout)findViewById(R.id.button_13);
        button[13] = (RelativeLayout)findViewById(R.id.button_14);
        button[14] = (RelativeLayout)findViewById(R.id.button_15);
        button[15] = (RelativeLayout)findViewById(R.id.button_16);
        button[16] = (RelativeLayout)findViewById(R.id.button_17);
        button[17] = (RelativeLayout)findViewById(R.id.button_18);
        button[18] = (RelativeLayout)findViewById(R.id.button_19);
        button[19] = (RelativeLayout)findViewById(R.id.button_20);
        button[20] = (RelativeLayout)findViewById(R.id.button_21);
        button[21] = (RelativeLayout)findViewById(R.id.button_22);
        button[22] = (RelativeLayout)findViewById(R.id.button_23);
        button[23] = (RelativeLayout)findViewById(R.id.button_24);
        button[24] = (RelativeLayout)findViewById(R.id.button_25);
        button_text[0] = (TextView)findViewById(R.id.button_text_1);
        button_text[1] = (TextView)findViewById(R.id.button_text_2);
        button_text[2] = (TextView)findViewById(R.id.button_text_3);
        button_text[3] = (TextView)findViewById(R.id.button_text_4);
        button_text[4] = (TextView)findViewById(R.id.button_text_5);
        button_text[5] = (TextView)findViewById(R.id.button_text_6);
        button_text[6] = (TextView)findViewById(R.id.button_text_7);
        button_text[7] = (TextView)findViewById(R.id.button_text_8);
        button_text[8] = (TextView)findViewById(R.id.button_text_9);
        button_text[9] = (TextView)findViewById(R.id.button_text_10);
        button_text[10] = (TextView)findViewById(R.id.button_text_11);
        button_text[11] = (TextView)findViewById(R.id.button_text_12);
        button_text[12] = (TextView)findViewById(R.id.button_text_13);
        button_text[13] = (TextView)findViewById(R.id.button_text_14);
        button_text[14] = (TextView)findViewById(R.id.button_text_15);
        button_text[15] = (TextView)findViewById(R.id.button_text_16);
        button_text[16] = (TextView)findViewById(R.id.button_text_17);
        button_text[17] = (TextView)findViewById(R.id.button_text_18);
        button_text[18] = (TextView)findViewById(R.id.button_text_19);
        button_text[19] = (TextView)findViewById(R.id.button_text_20);
        button_text[20] = (TextView)findViewById(R.id.button_text_21);
        button_text[21] = (TextView)findViewById(R.id.button_text_22);
        button_text[22] = (TextView)findViewById(R.id.button_text_23);
        button_text[23] = (TextView)findViewById(R.id.button_text_24);
        button_text[24] = (TextView)findViewById(R.id.button_text_25);
        ok_button = (RelativeLayout)findViewById(R.id.ok_button);
    }
    int button_num;
    private void all_button_click() {
        for (int i = 0; i < 25; i++) {
            final int j = i;
            button[j].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(match_number_int == 50) {
                        include[1].setVisibility(View.VISIBLE);
                        include[0].setVisibility(View.GONE);
                    }
                    int number = j;
                    if(match_number_int == button_number_01[number]) {
                        match_number_int += 1;
                        button_text[number].setText(Integer.toString(button_number_02[number]));
                    }
                    if(match_number_int == button_number_02[number]) {
                        match_number_int += 1;
                        button_text[number].setVisibility(View.GONE);
                    }
                    now_number.setText(Integer.toString(match_number_int));
                }
            });
        }
        ok_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                match_number_int = 1;
                for(int reset_button_number = 0; reset_button_number <= 24; reset_button_number++) {
                    button_number_01[reset_button_number] = 0;
                    button_number_02[reset_button_number] = 0;
                    button_text[reset_button_number].setVisibility(View.VISIBLE);
                }
                include[0].setVisibility(View.VISIBLE);
                include[1].setVisibility(View.GONE);
                //game();
                Intent intent = new Intent(
                        getApplicationContext(),Title2_2Activity.class);//현재 화면의 제어권자,다음 넘어갈 클래스 지정
                startActivity(intent);//다음화면으로 넘어간다.
            }
        });
    }
}