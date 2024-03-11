package project;

public class GrandmasterGradeCalculator implements UserGradeCalculator{
    @Override
    public String calculateGrade(int score) {
        return "Grandmaster";
    }
}
