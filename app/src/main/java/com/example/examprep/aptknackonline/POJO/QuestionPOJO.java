package com.example.examprep.aptknackonline.POJO;

public class QuestionPOJO {
    private int id, marks, negMarks;
    private String question;
    private String questionType;
    private String ans;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public void setNegMarks(int negMarks) {
        this.negMarks = negMarks;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }
}
