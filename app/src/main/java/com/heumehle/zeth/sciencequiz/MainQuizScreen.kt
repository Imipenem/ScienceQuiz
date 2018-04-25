package com.heumehle.zeth.sciencequiz

import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main_quiz_screen.*


class MainQuizScreen : AppCompatActivity() {

    private var totalPoints: Int = 0

    internal var TextField: TextView
    internal var PointsField: TextView
    internal var A_Button: Button
    internal var B_Button: Button
    internal var C_Button: Button
    internal var D_Button: Button

    internal var dummyQuestion = Question("Korrekt", "Frage", "Falsch1", "Falsch2", "Falsch3")

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

    fun createQuestionScreen() {

        TextField = findViewById<TextView>(R.id.textView2)
        TextField.setText(dummyQuestion.getM_question())
        PointsField = findViewById<TextView>(R.id.allPoints)
        PointsField.setText(String.format("Total Points: %s", totalPoints.toString()))


        A_Button = findViewById<Button>(R.id.answer_A)
        B_Button = findViewById<Button>(R.id.answer_B)
        C_Button = findViewById<Button>(R.id.Answer_C)
        D_Button = findViewById<Button>(R.id.Answer_D)


        val rand = (Math.random() * 4 + 1).toInt()

        when (rand) {

            1 -> {
                A_Button.setText(dummyQuestion.getM_correctAnswer())
                B_Button.setText(dummyQuestion.getM_false1())
                C_Button.setText(dummyQuestion.getM_false2())
                D_Button.setText(dummyQuestion.getM_false3())
            }

            2 -> {
                B_Button.setText(dummyQuestion.getM_correctAnswer())
                A_Button.setText(dummyQuestion.getM_false3())
                C_Button.setText(dummyQuestion.getM_false2())
                D_Button.setText(dummyQuestion.getM_false1())
            }

            3 -> {
                C_Button.setText(dummyQuestion.getM_correctAnswer())
                A_Button.setText(dummyQuestion.getM_false1())
                B_Button.setText(dummyQuestion.getM_false2())
                D_Button.setText(dummyQuestion.getM_false3())
            }

            4 -> {
                D_Button.setText(dummyQuestion.getM_correctAnswer())
                A_Button.setText(dummyQuestion.getM_false2())
                B_Button.setText(dummyQuestion.getM_false3())
                C_Button.setText(dummyQuestion.getM_false1())
            }
        }

        A_Button.setOnClickListener(View.OnClickListener {
            if (A_Button.getText() == dummyQuestion.getM_correctAnswer()) {
                A_Button.setBackgroundColor(Color.GREEN)
                totalPoints++
                PointsField.setText(String.format("Total Points: %s", totalPoints.toString()))
            } else
                A_Button.setBackgroundColor(Color.RED)
        })

        B_Button.setOnClickListener(View.OnClickListener {
            if (B_Button.getText() == dummyQuestion.getM_correctAnswer()) {
                B_Button.setBackgroundColor(Color.GREEN)
                totalPoints++
                PointsField.setText(String.format("Total Points: %s", totalPoints.toString()))
            } else
                B_Button.setBackgroundColor(Color.RED)
        })

        C_Button.setOnClickListener(View.OnClickListener {
            if (C_Button.getText() == dummyQuestion.getM_correctAnswer()) {
                C_Button.setBackgroundColor(Color.GREEN)
                totalPoints++
                PointsField.setText(String.format("Total Points: %s", totalPoints.toString()))
            } else
                C_Button.setBackgroundColor(Color.RED)
        })

        D_Button.setOnClickListener(View.OnClickListener {
            if (D_Button.getText() == dummyQuestion.getM_correctAnswer()) {
                D_Button.setBackgroundColor(Color.GREEN)
                totalPoints++
                PointsField.setText(String.format("Total Points: %s", totalPoints.toString()))
            } else
                D_Button.setBackgroundColor(Color.RED)
        })
    }
}