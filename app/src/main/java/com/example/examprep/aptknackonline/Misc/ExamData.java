package com.example.examprep.aptknackonline.Misc;

import com.example.examprep.aptknackonline.POJO.SyllabusPOJO;

public class ExamData {
    private SyllabusPOJO syllabus;
    private int completed;
    private int marksObtained;

    public SyllabusPOJO getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(SyllabusPOJO syllabus) {
        this.syllabus = syllabus;
    }

    public int getCompleted() {
        return completed;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }

    public int getMarksObtained() {
        return marksObtained;
    }

    public void setMarksObtained(int marksObtained) {
        this.marksObtained = marksObtained;
    }

}
