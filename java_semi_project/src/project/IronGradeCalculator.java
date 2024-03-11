package project;

public class IronGradeCalculator implements UserGradeCalculator{
    @Override
    public String calculateGrade(int score) {
        return "Iron";
    }
}
