package me.fortibrine.junit.grade;

import java.util.ArrayList;
import java.util.List;

public class GradeCalculator {

    public List<String> getGrades(List<Integer> scores) {
        return new ArrayList<>(scores).stream()
                .map(this::computeGrade)
                .toList();
    }

    private String computeGrade(int score) {
        return score < 70 ? "Fail" : "Pass";
    }

}
