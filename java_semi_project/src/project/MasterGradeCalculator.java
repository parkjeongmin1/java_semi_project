package project;

public class MasterGradeCalculator implements UserGradeCalculator{
    @Override
    public String calculateGrade(int score) {
        return "Master";
    }
}
