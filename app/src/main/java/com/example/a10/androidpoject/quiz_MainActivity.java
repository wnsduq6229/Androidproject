package com.example.a10.androidpoject;


import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class quiz_MainActivity extends AppCompatActivity {

    ArrayList<ArrayList<String>> quizArray = new ArrayList<>(); //문제를 넣을 배열
    String quizData[][] = {
            // 퀴즈를 구성하는 내용 배열로 저장하기
            // {"문제이미지 이름", "맞는답", "선택지1", "선택지2", "선택지3"}
            {"image_bead", "BEAD", "BFAD", "BEAO", "BTAD"},
            {"image_boot", "BOOT", "BODT", "DOOT", "BOOF"},
            {"image_eat", "EAT", "FAT", "EAF", "FAF"},
            {"image_hat", "HAT", "HAF", "HAI", "FAT"},
            {"image_love", "LOVE", "LDVE", "LOVF", "LDVE"},
            {"image_park", "PARK", "RARK", "PAPK", "PABK"},
            {"image_sweet", "SWEET", "SWEFT", "SWEEF", "SYEET"},
            {"image_tree", "TREE", "TRFE", "TRFF", "TBEE"},
            {"image_sandwich", "SANDWICH", "SANOWLCH", "SANDWIOH", "SAMDWICH"},
            {"image_smart", "SMART", "SNART", "SMARF", "SMABT"}
    };
    private TextView countLabel;
    private ImageView questionImage;
    private Button answerBtn1;
    private Button answerBtn2;
    private Button answerBtn3;
    private Button answerBtn4;
    private String rightAnswer;
    private int rightAnswerCount = 0;
    private int quizCount = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_main);

        countLabel = findViewById(R.id.countLabel);
        questionImage = findViewById(R.id.questionImage);
        //보기 버튼 4개 구성
        answerBtn1 = findViewById(R.id.answerBtn1);
        answerBtn2 = findViewById(R.id.answerBtn2);
        answerBtn3 = findViewById(R.id.answerBtn3);
        answerBtn4 = findViewById(R.id.answerBtn4);

        // 퀴즈 자료가 저장된 데이터로 부터 정보를 받아와 퀴즈 생성
        for (int i = 0; i < quizData.length; i++) {
            // Prepare array.
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData[i][0]); // 문제 이미지 이름
            tmpArray.add(quizData[i][1]); // 맞는 답
            tmpArray.add(quizData[i][2]); // 선택지1
            tmpArray.add(quizData[i][3]); // 선택지2
            tmpArray.add(quizData[i][4]); // 선택지3

            // Add tmpArray to quizArray.
            quizArray.add(tmpArray);
        }

        showNextQuiz();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//화면의 제목 없애주는 문장
        getSupportActionBar().hide();//화면의 제목 숨겨주는 문장
    }

    public void showNextQuiz() {

        // 다음문제 번호 출력
        countLabel.setText("\n\n           "+quizCount+"번 문제");

        //0부터 4사이 숫자중 랜덤하게 숫자 형성
        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());

        // 배열에서 사용자에게 보여줄 문제 고르기
        ArrayList<String> quiz = quizArray.get(randomNum);

        // Set Image and Right Answer.
        // 배열의 형태 {"문제이미지 이름", "맞는답", "선택지1", "선택지2", "선택지3"}
        questionImage.setImageResource(
                getResources().getIdentifier(quiz.get(0), "drawable", getPackageName()));
        rightAnswer = quiz.get(1);

        // Remove "Image Name" from quiz and shuffle choices.
        quiz.remove(0);
        Collections.shuffle(quiz);

        // Set choices.
        answerBtn1.setText(quiz.get(0));
        answerBtn2.setText(quiz.get(1));
        answerBtn3.setText(quiz.get(2));
        answerBtn4.setText(quiz.get(3));

        // Remove this quiz from quizArray.
        quizArray.remove(randomNum);

    }

    public void checkAnswer(View view) {

        // 버튼 눌럿을때 동작 설정
        Button answerBtn = findViewById(view.getId());
        String btnText = answerBtn.getText().toString();

        String alertTitle;

        if (btnText.equals(rightAnswer)) {
            // 맞는 정답을 골랐을 경우
            alertTitle = "Correct!";
            rightAnswerCount++;

        } else {
            // 틀린 정답을 골랐을 경우
            alertTitle = "Wrong...";
        }

        // 결과창 만들기 -> 지금은 알림이지만 새로운 창이 띄워지게 바꿀거임
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setMessage("Answer : " + rightAnswer);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (quizArray.size() < 1) {
                    // quizArray is empty.
                    showResult();
                } else {
                    quizCount++;
                    showNextQuiz();
                }
            }

        });
        builder.setCancelable(false);

        builder.show();

    }


    //여기있는 내용들이 quiz_ResultActivity.java 서브 코드로 이동될 예정 (결과창:몇개맞았는지, 점수, 게임끝내기, 다시도전하기 등)
    public void showResult() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Result");
        builder.setMessage((rightAnswerCount)*10 + " / 100");
        builder.setPositiveButton("Try Again", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                recreate();
            }
        });
        builder.setNegativeButton("Quit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.show();
    }
}