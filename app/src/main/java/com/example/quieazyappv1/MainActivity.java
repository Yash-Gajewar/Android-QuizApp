package com.example.quieazyappv1;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nametext;
    Button teacherBtn, studentBtn;
    String []questions_arr;
    String []answers_arr;
    String [] options_arr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         teacherBtn=(Button)findViewById(R.id.teacher);
         studentBtn=(Button)findViewById(R.id.student);
         nametext=(EditText)findViewById(R.id.editName);
         Intent intent = getIntent();
         questions_arr = intent.getStringArrayExtra("questions");
         answers_arr = intent.getStringArrayExtra("answers");
         options_arr = intent.getStringArrayExtra("options");

    }

    public void createQuiz(View view){
        Intent intent = new Intent(MainActivity.this, CreateQuiz.class);
        startActivity(intent);
    }

    public void solveQuiz(View view){
        String name=nametext.getText().toString();
        Intent intent = new Intent(MainActivity.this, QuestionsActivity.class);
        intent.putExtra("myname",name);
        intent.putExtra("questions",questions_arr);
        intent.putExtra("answers",answers_arr);
        intent.putExtra("options",options_arr);
        startActivity(intent);


    }


}