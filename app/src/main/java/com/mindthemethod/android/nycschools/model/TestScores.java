package com.mindthemethod.android.nycschools.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TestScores {

    @SerializedName("dbn")
    @Expose
    private String dbn;

    @SerializedName("num_of_sat_test_takers")
    @Expose
    private int numOfTestTakers;

    @SerializedName("sat_critical_reading_avg_score")
    @Expose
    private int readingAvgScore;

    @SerializedName("sat_math_avg_score")
    @Expose
    private int mathAvgScore;

    @SerializedName("sat_writing_avg_score")
    @Expose
    private int writingAvgScore;

    @SerializedName("school_name")
    @Expose
    private String schoolName;

    public TestScores(String dbn, int numOfTestTakers, int readingAvgScore, int mathAvgScore, int writingAvgScore, String schoolName) {
        this.dbn = dbn;
        this.numOfTestTakers = numOfTestTakers;
        this.readingAvgScore = readingAvgScore;
        this.mathAvgScore = mathAvgScore;
        this.writingAvgScore = writingAvgScore;
        this.schoolName = schoolName;
    }


    public String getDbn() {
        return dbn;
    }

    public int getNumOfTestTakers() {
        return numOfTestTakers;
    }

    public int getReadingAvgScore() {
        return readingAvgScore;
    }

    public int getMathAvgScore() {
        return mathAvgScore;
    }

    public int getWritingAvgScore() {
        return writingAvgScore;
    }

    public String getSchoolName() {
        return schoolName;
    }
}
