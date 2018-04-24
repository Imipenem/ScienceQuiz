package com.heumehle.zeth.sciencequiz

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main_quiz_screen.*

class MainQuizScreen : AppCompatActivity() {

    TextView TextField;

    Button A_Button;
    Button B_Button;
    Button C_Button;
    Button D_Button;

    Question dummyQuestion = new Question("Korrekt", "Frage", "Falsch1", "Falsch2" , "Falsch3");

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_quiz_screen)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        createQuestionScreen();
    }

    public void createQuestionScreen()
    {

        TextField = findViewById(R.id.textView2);
        TextField.setText(dummyQuestion.getM_question());
        A_Button = findViewById(R.id.answer_A);
        B_Button = findViewById(R.id.answer_B);
        C_Button = findViewById(R.id.Answer_C);
        D_Button = findViewById(R.id.Answer_D);


        int rand =(int)((Math.random() * 4) + 1);

        switch(rand) {

            case 1:
            A_Button.setText(dummyQuestion.getM_correctAnswer());
            B_Button.setText(dummyQuestion.getM_false1());
            C_Button.setText(dummyQuestion.getM_false2());
            D_Button.setText(dummyQuestion.getM_false3());
            break;

            case 2:
            B_Button.setText(dummyQuestion.getM_correctAnswer());
            A_Button.setText(dummyQuestion.getM_false3());
            C_Button.setText(dummyQuestion.getM_false2());
            D_Button.setText(dummyQuestion.getM_false1());
            break;

            case 3:
            C_Button.setText(dummyQuestion.getM_correctAnswer());
            A_Button.setText(dummyQuestion.getM_false1());
            B_Button.setText(dummyQuestion.getM_false2());
            D_Button.setText(dummyQuestion.getM_false3());
            break;

            case 4:
            D_Button.setText(dummyQuestion.getM_correctAnswer());
            A_Button.setText(dummyQuestion.getM_false2());
            B_Button.setText(dummyQuestion.getM_false3());
            C_Button.setText(dummyQuestion.getM_false1());
            break;

        }

        A_Button.setOnClickListener(new View . OnClickListener () {
            public void onClick(View v) {
                if (A_Button.getText().equals(dummyQuestion.getM_correctAnswer())) {
                    A_Button.setBackgroundColor(Color.GREEN);
                } else A_Button.setBackgroundColor(Color.RED);
            }
        });

        B_Button.setOnClickListener(new View . OnClickListener () {
            public void onClick(View v) {
                if (B_Button.getText().equals(dummyQuestion.getM_correctAnswer())) {
                    B_Button.setBackgroundColor(Color.GREEN);
                } else B_Button.setBackgroundColor(Color.RED);
            }
        });

        C_Button.setOnClickListener(new View . OnClickListener () {
            public void onClick(View v) {
                if (C_Button.getText().equals(dummyQuestion.getM_correctAnswer())) {
                    C_Button.setBackgroundColor(Color.GREEN);
                } else C_Button.setBackgroundColor(Color.RED);
            }
        });

        D_Button.setOnClickListener(new View . OnClickListener () {
            public void onClick(View v) {
                if (D_Button.getText().equals(dummyQuestion.getM_correctAnswer())) {
                    D_Button.setBackgroundColor(Color.GREEN);
                } else D_Button.setBackgroundColor(Color.RED);
            }
        });
    }
}



}
