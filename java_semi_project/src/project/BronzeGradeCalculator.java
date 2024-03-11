package project;

public class BronzeGradeCalculator implements UserGradeCalculator{
    @Override
    public String calculateGrade(int score) {
        return "Bronze";
    }
}
