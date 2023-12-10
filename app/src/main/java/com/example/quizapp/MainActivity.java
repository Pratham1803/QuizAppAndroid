package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.*;

public class MainActivity extends AppCompatActivity {
    static TextView lblQues;
    static TextView lblRes;
    static List<String> strQues = Arrays.asList( "Java is Developed in 1900?", "Java is Developed by Sun Microsystem?",
            "Java developed in Python", "Java Supports Mulitple Inheritance", "Java Supports interface?" );
    static boolean arrAns[] = { false, true, false, false, true };
    static int numQues = strQues.size();

    static int score = 0;

    static ArrayList<Integer> arrSelectedindex = new ArrayList<>();
    public void btnTrue_Clicked(View view){
        String que =  lblQues.getText().toString();
        int index = strQues.indexOf(que);
        if(arrAns[index] == true){
            score++;
        }
        if(arrSelectedindex.size() != numQues) {
            getRandome();
        }
        else
            restart();

        lblRes.setText("Score : " + score);
        //Toast.makeText(this, , Toast.LENGTH_SHORT).show();
    }
    public void btnFalse_Clicked(View view){
        String que =  lblQues.getText().toString();
        int index = strQues.indexOf(que);
        if(arrAns[index] == false){
            score++;
        }
        if(arrSelectedindex.size() != numQues) {
            getRandome();
        }
        else
            restart();
        lblRes.setText("Score : " + score);
        //Toast.makeText(this, "Your Score is "+score, Toast.LENGTH_SHORT).show();
    }
    private void restart(){
        score = 0;
        arrSelectedindex.clear();
        getRandome();
    }
    static private void getRandome() {
        int index;
        Random r = new Random();
        do {
            index = r.nextInt(numQues);
        } while (arrSelectedindex.contains(index));

        arrSelectedindex.add(index);
        lblQues.setText(strQues.get(index));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblQues = findViewById(R.id.lblQue);
        lblRes = findViewById(R.id.lblResult);
        getRandome();
    }
}