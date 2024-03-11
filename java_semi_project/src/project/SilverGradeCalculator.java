package project;

public class SilverGradeCalculator implements UserGradeCalculator{
    @Override
    public String calculateGrade(int score) {
        return "Silver";
    }
}
