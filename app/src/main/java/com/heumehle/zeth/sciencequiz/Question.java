package com.heumehle.zeth.sciencequiz;

/**
 * This class can be used to specify questions
 */

public class Question {


    private String m_question;
    private String m_correctAnswer;
    private String m_false1;
    private String m_false2;
    private String m_false3;




    public Question(String m_correctAnswer, String m_question, String  m_false1, String m_false2, String m_false3) {
        this.m_correctAnswer = m_correctAnswer;
        this.m_question = m_question;
        this.m_false1 = m_false1;
        this.m_false2 = m_false2;
        this.m_false3 = m_false3;
    }

    public String getM_question() {
        return m_question;
    }

    public String getM_correctAnswer() {
        return m_correctAnswer;
    }

    public String getM_false1() {
        return m_false1;
    }

    public String getM_false2() {
        return m_false2;
    }

    public String getM_false3() {
        return m_false3;
    }
}