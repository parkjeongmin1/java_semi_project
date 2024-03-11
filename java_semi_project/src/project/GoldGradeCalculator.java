package project;

public class GoldGradeCalculator implements UserGradeCalculator{
    @Override
    public String calculateGrade(int score) {
        return "Gold";
    }
}
