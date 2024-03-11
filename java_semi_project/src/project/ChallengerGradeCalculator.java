package project;

public class ChallengerGradeCalculator implements UserGradeCalculator{
    @Override
    public String calculateGrade(int score) {
        return "Challenger";
    }
}
