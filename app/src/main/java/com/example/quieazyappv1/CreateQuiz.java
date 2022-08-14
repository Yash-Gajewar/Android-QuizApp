package com.example.quieazyappv1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class CreateQuiz extends AppCompatActivity {
//    String questions_arr[];
    String questions_arr[];
    String answers_arr [];
    String options_arr[];
    List<String> questions_lst = new ArrayList<String>();
    List<String> answers_lst = new ArrayList<String>();
    List<String> options_lst = new ArrayList<String>();

    EditText question, option1, option2, option3, option4, correct_answer;
    int length = 0;
    int option_length = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createquiz);
        question = (EditText) findViewById(R.id.question);
        option1 = (EditText) findViewById(R.id.option1);
        option2 = (EditText) findViewById(R.id.option2);
        option3 = (EditText) findViewById(R.id.option3);
        option4 = (EditText) findViewById(R.id.option4);
        correct_answer = (EditText) findViewById(R.id.correct_answer);
    }

    public void enterQuestion(View view){

         questions_lst.add(question.getText().toString());
         answers_lst.add(correct_answer.getText().toString());
         options_lst.add(option1.getText().toString());
         options_lst.add(option2.getText().toString());
         options_lst.add(option3.getText().toString());
         options_lst.add(option4.getText().toString());

         questions_arr = new String[ questions_lst.size() ];
         answers_arr  = new String[ answers_lst.size() ];
         options_arr = new String[ options_lst.size() ];

         questions_lst.toArray(questions_arr);
         answers_lst.toArray(answers_arr);
         options_lst.toArray(options_arr);

         question.setText("");
         correct_answer.setText("");
         option1.setText("");
         option2.setText("");
         option3.setText("");
         option4.setText("");
         Toast.makeText(this, "Question Entered successfully", Toast.LENGTH_LONG).show();

    }

    public void uploadQuiz(View view){
        Toast.makeText(this, "Quiz uploaded successfully", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("questions",questions_arr);
        intent.putExtra("answers",answers_arr);
        intent.putExtra("options",options_arr);
        startActivity(intent);
    }

}