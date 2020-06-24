/// 코드 작성자 김성수, 홍예지
package com.example.a10.androidpoject;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler; //핸들러 사용에 필요

import java.util.ArrayList;
import java.util.HashMap;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;




public class MainActivity  extends Activity {

    public static Context context;
   int score_memory = ((memory_MainActivity)memory_MainActivity.context).score+70  ;
   int score_math = ((Math_MainActivity)Math_MainActivity.context).score1*10;
   int score_speed = ((onetofifty_MainActivity)onetofifty_MainActivity.context).final_score;
   int score_color = ((quiz_MainActivity)quiz_MainActivity.context).quiz_score;
    int min = 999;
    int check = 2;

    private final String dbName = "webnautes";
    private final String tableName = "person";

    private String names[];
    {
        names = new String[]{"기억력게임", "수리게임", "순발력게임", "색맹게임"};
    }

     private final String phones[];
    {
        phones = new String[]{String.valueOf(score_memory), String.valueOf(score_math), String.valueOf(score_speed), String.valueOf(score_color)};
    }



    ArrayList<HashMap<String, String>> personList;
    ListView list;
    private static final String TAG_NAME = "name";
    private static final String TAG_PHONE ="phone";

    SQLiteDatabase sampleDB = null;
    ListAdapter adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        Handler hand = new Handler(); //Handler 생성

        list = (ListView) findViewById(R.id.listView);
        personList = new ArrayList<HashMap<String,String>>();

       if(min > score_memory){
            min = score_memory; //90
            check = 1;
        }
        if(min > score_math){
            min = score_math; //72
            check = 2;
        }
        if(min > score_speed){
            min = score_speed; // 80
            check = 3;
        }
        if(min > score_color){
            min = score_color; //
            check = 4;
        }


        try {


            sampleDB = this.openOrCreateDatabase(dbName, MODE_PRIVATE, null);

            //테이블이 존재하지 않으면 새로 생성합니다.
            sampleDB.execSQL("CREATE TABLE IF NOT EXISTS " + tableName
                    + " (name VARCHAR(20), phone VARCHAR(20) );");

            //테이블이 존재하는 경우 기존 데이터를 지우기 위해서 사용합니다.
            sampleDB.execSQL("DELETE FROM " + tableName  );

            //새로운 데이터를 테이블에 집어넣습니다..
            for (int i=0; i<names.length; i++ ) {
                sampleDB.execSQL("INSERT INTO " + tableName
                        + " (name, phone)  Values ('" + names[i] + "', '" + phones[i]+"');");
            }


            sampleDB.close();

        } catch (SQLiteException se) {
            Toast.makeText(getApplicationContext(),  se.getMessage(), Toast.LENGTH_LONG).show();
            Log.e("", se.getMessage());


        }


        showList();
        if(check == 1) {
            hand.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(MainActivity.this, tip_memory_Activity.class);
                    startActivity(i);
                    finish();
                }
            }, 3000);
        }
        else if(check == 2) {
            hand.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(MainActivity.this, tip_math_Activity.class);
                    startActivity(i);
                    finish();
                }
            }, 3000);
        }
        else if(check == 3) {
            hand.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(MainActivity.this, tip_speed_Activity.class);
                    startActivity(i);
                    finish();
                }
            }, 3000);
        }
        else if(check == 4) {
            hand.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(MainActivity.this, tip_color_Activity.class);
                    startActivity(i);
                    finish();
                }
            }, 3000);
        }

    }




    protected void showList(){

        try {

            SQLiteDatabase ReadDB = this.openOrCreateDatabase(dbName, MODE_PRIVATE, null);


            //SELECT문을 사용하여 테이블에 있는 데이터를 가져옵니다..
            Cursor c = ReadDB.rawQuery("SELECT * FROM " + tableName, null);

            if (c != null) {


                if (c.moveToFirst()) {
                    do {

                        //테이블에서 두개의 컬럼값을 가져와서
                        String Name = c.getString(c.getColumnIndex("name"));
                        String Phone = c.getString(c.getColumnIndex("phone"));

                        //HashMap에 넣습니다.
                        HashMap<String,String> persons = new HashMap<String,String>();

                        persons.put(TAG_NAME,Name);
                        persons.put(TAG_PHONE,Phone);

                        //ArrayList에 추가합니다..
                        personList.add(persons);

                    } while (c.moveToNext());
                }
            }

            ReadDB.close();


            //새로운 apapter를 생성하여 데이터를 넣은 후..
            adapter = new SimpleAdapter(
                    this, personList, R.layout.activity_list_item,
                    new String[]{TAG_NAME,TAG_PHONE},
                    new int[]{ R.id.name, R.id.phone}
            );


            //화면에 보여주기 위해 Listview에 연결합니다.
            list.setAdapter(adapter);


        } catch (SQLiteException se) {
            Toast.makeText(getApplicationContext(),  se.getMessage(), Toast.LENGTH_LONG).show();
            Log.e("",  se.getMessage());
        }

    }


}
