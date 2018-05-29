package com.heumehle.zeth.sciencequiz

import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.content.Intent
import android.os.Handler
import kotlinx.android.synthetic.main.activity_main_quiz_screen.*


class MainQuizScreen : AppCompatActivity() {

    private var totalPoints: Int = 0

    private var TextField: TextView = findViewById(R.id.textView2)
    private var PointsField: TextView = findViewById(R.id.allPoints)
    private var A_Button: Button = findViewById(R.id.answer_A)
    private var B_Button: Button = findViewById(R.id.answer_B)
    private var C_Button: Button = findViewById(R.id.Answer_C)
    private var D_Button: Button = findViewById(R.id.Answer_D)

    internal var dummyQuestion1 = Question("Korrekt", "Frage", "Falsch1", "Falsch2", "Falsch3")
    internal var dummyQuestion2 = Question("2", "Was is 1 + 1?", "3", "4", "5")
    internal var dummyQuestion3 = Question("Ganz toll", "Wie cool ist Bitconnect?", "1", "500%", "-1000%")
    internal var dummyQuestion4 = Question("Carlos Matos", "Wer ist der sexiest Man alive?", "Simon", "Lukas", "Philipp")
    internal var dummyQuestion5 = Question("Angela Merkel", "Ist internet für uns alle Neuland??", "Ja", "Jaha", "Wo ist mein Flugtaxi?")


    internal var dummyQuestionHolder = arrayOf(dummyQuestion1, dummyQuestion2, dummyQuestion3, dummyQuestion4, dummyQuestion5)
    internal var dummyQuestion = getDummyQuestion()

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

    /**
     * This method handles clickOn Button events
     */

    fun handleButtonEvents() {

        A_Button.setOnClickListener { v ->
            if (A_Button.text == dummyQuestion.m_correctAnswer) {
                A_Button.setBackgroundColor(Color.GREEN)
                totalPoints++
                PointsField.text = String.format("Total Points: %s", totalPoints.toString())
                val myIntent = Intent(v.context, CorrectQuestionScreen::class.java)
                startActivity(myIntent)

                Handler().postDelayed({
                    createQuestionScreen()
                    A_Button.setBackgroundColor(Color.parseColor("#f1ff33"))
                }, 3000)
            } else {
                A_Button.setBackgroundColor(Color.RED)
                Handler().postDelayed({
                    createQuestionScreen()
                    A_Button.setBackgroundColor(Color.parseColor("#f1ff33"))
                }, 3000)
            }
            /**
             * Only here for later refactoring
             */
            //Intent myIntent = new Intent(v.getContext(),MainActivity.class);
            //startActivity(myIntent);}
        }

        B_Button.setOnClickListener { v ->
            if (B_Button.text == dummyQuestion.m_correctAnswer) {
                B_Button.setBackgroundColor(Color.GREEN)
                totalPoints++
                PointsField.text = String.format("Total Points: %s", totalPoints.toString())
                val myIntent = Intent(v.context, CorrectQuestionScreen::class.java)
                startActivity(myIntent)

                Handler().postDelayed({
                    createQuestionScreen()
                    B_Button.setBackgroundColor(Color.parseColor("#f1ff33"))
                }, 3000)
            } else {
                B_Button.setBackgroundColor(Color.RED)
                Handler().postDelayed({
                    createQuestionScreen()
                    B_Button.setBackgroundColor(Color.parseColor("#f1ff33"))
                }, 3000)
            }
        }

        C_Button.setOnClickListener { v ->
            if (C_Button.text == dummyQuestion.m_correctAnswer) {
                C_Button.setBackgroundColor(Color.GREEN)
                totalPoints++
                PointsField.text = String.format("Total Points: %s", totalPoints.toString())
                val myIntent = Intent(v.context, CorrectQuestionScreen::class.java)
                startActivity(myIntent)

                Handler().postDelayed({
                    createQuestionScreen()
                    C_Button.setBackgroundColor(Color.parseColor("#f1ff33"))
                }, 3000)
            } else {
                C_Button.setBackgroundColor(Color.RED)
                Handler().postDelayed({
                    createQuestionScreen()
                    C_Button.setBackgroundColor(Color.parseColor("#f1ff33"))
                }, 3000)
            }
        }

        D_Button.setOnClickListener { v ->
            if (D_Button.text == dummyQuestion.m_correctAnswer) {
                D_Button.setBackgroundColor(Color.GREEN)
                totalPoints++
                PointsField.text = String.format("Total Points: %s", totalPoints.toString())
                val myIntent = Intent(v.context, CorrectQuestionScreen::class.java)
                startActivity(myIntent)

                Handler().postDelayed({
                    createQuestionScreen()
                    D_Button.setBackgroundColor(Color.parseColor("#f1ff33"))
                }, 3000)
            } else {
                D_Button.setBackgroundColor(Color.RED)
                Handler().postDelayed({
                    createQuestionScreen()
                    D_Button.setBackgroundColor(Color.parseColor("#f1ff33"))
                }, 3000)
            }
        }
    }

    /**
     * Everytime this method is called, it creates a new question screen
     */

    fun createQuestionScreen() {

        dummyQuestion = getDummyQuestion()
        TextField = findViewById(R.id.textView2)
        TextField.text = dummyQuestion.m_question
        PointsField = findViewById(R.id.allPoints)
        PointsField.text = String.format("Total Points: %s", totalPoints.toString())


        A_Button = findViewById(R.id.answer_A)
        B_Button = findViewById(R.id.answer_B)
        C_Button = findViewById(R.id.Answer_C)
        D_Button = findViewById(R.id.Answer_D)

        TextField.text = dummyQuestion.m_question
        PointsField.text = String.format("Total Points: %s", totalPoints.toString())

        val rand = (Math.random() * 4 + 1).toInt()

        when (rand) {

            1 -> {
                A_Button.text = dummyQuestion.m_correctAnswer
                B_Button.text = dummyQuestion.m_false1
                C_Button.text = dummyQuestion.m_false2
                D_Button.text = dummyQuestion.m_false3
            }

            2 -> {
                B_Button.text = dummyQuestion.m_correctAnswer
                A_Button.text = dummyQuestion.m_false3
                C_Button.text = dummyQuestion.m_false2
                D_Button.text = dummyQuestion.m_false1
            }

            3 -> {
                C_Button.text = dummyQuestion.m_correctAnswer
                A_Button.text = dummyQuestion.m_false1
                B_Button.text = dummyQuestion.m_false2
                D_Button.text = dummyQuestion.m_false3
            }

            4 -> {
                D_Button.text = dummyQuestion.m_correctAnswer
                A_Button.text = dummyQuestion.m_false2
                B_Button.text = dummyQuestion.m_false3
                C_Button.text = dummyQuestion.m_false1
            }
        }
    }

    fun getDummyQuestion(): Question {
        return dummyQuestionHolder[(Math.random() * 5 + 1).toInt()]
    }
}