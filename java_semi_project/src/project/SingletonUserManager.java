package project;
import java.util.*;
public class SingletonUserManager {
    private static SingletonUserManager instance;
    private Map<String, Integer> userScores;
    private Map<Integer, List<String>> scoreToUserMap;
    private Map<Integer, UserGradeCalculator> gradeCalculatorMap;

    private SingletonUserManager() {
        userScores = new HashMap<>();
        scoreToUserMap = new TreeMap<>(Collections.reverseOrder());
        gradeCalculatorMap = new HashMap<>();
        initializeGradeCalculatorMap();
    }

    public static SingletonUserManager getInstance() {
        if (instance == null) {
            instance = new SingletonUserManager();
        }
        return instance;
    }

    private void initializeGradeCalculatorMap() {
        gradeCalculatorMap.put(0, new IronGradeCalculator());
        gradeCalculatorMap.put(10, new BronzeGradeCalculator());
        gradeCalculatorMap.put(20, new SilverGradeCalculator());
        gradeCalculatorMap.put(30, new GoldGradeCalculator());
        gradeCalculatorMap.put(40, new PlatinumGradeCalculator());
        gradeCalculatorMap.put(50, new EmeraldGradeCalculator());
        gradeCalculatorMap.put(60, new DiamondGradeCalculator());
        gradeCalculatorMap.put(70, new MasterGradeCalculator());
        gradeCalculatorMap.put(80, new GrandmasterGradeCalculator());
        gradeCalculatorMap.put(90, new ChallengerGradeCalculator());


        for (int i = 1; i < 10; i++) {
            gradeCalculatorMap.put(i, new IronGradeCalculator());
        }
        for (int i = 11; i < 20; i++) {
            gradeCalculatorMap.put(i, new BronzeGradeCalculator());
        }
        for (int i = 21; i < 30; i++){
            gradeCalculatorMap.put(i, new SilverGradeCalculator());
        }
        for (int i = 31; i < 40; i++){
            gradeCalculatorMap.put(i, new GoldGradeCalculator());
        }
        for (int i = 41; i < 50; i++){
            gradeCalculatorMap.put(i, new PlatinumGradeCalculator());
        }
        for (int i = 51; i < 60; i++){
            gradeCalculatorMap.put(i, new EmeraldGradeCalculator());
        }
        for (int i = 61; i < 70; i++){
            gradeCalculatorMap.put(i, new DiamondGradeCalculator());
        }
        for (int i = 71; i < 80; i++){
            gradeCalculatorMap.put(i, new MasterGradeCalculator());
        }
        for (int i = 81; i < 90; i++){
            gradeCalculatorMap.put(i, new GrandmasterGradeCalculator());
        }
        for (int i = 91; i < 200; i++){
            gradeCalculatorMap.put(i, new ChallengerGradeCalculator());
        }
    }


    public void registerUser(String name, int score) {
        userScores.put(name, score);
        scoreToUserMap.computeIfAbsent(score / 10, k -> new ArrayList<>()).add(name);
    }

    public void displayAllUsers() {
        System.out.println("사용자의 이름: ");
        for (Map.Entry<String, Integer> entry : userScores.entrySet()) {
            int score = entry.getValue();
            String grade = gradeCalculatorMap.get(score).calculateGrade(score);
            System.out.println(entry.getKey() + ": " + score + " (" + grade + ")");
        }
    }

    public boolean updateUserScore(String name, String result) {
        int currentScore = userScores.getOrDefault(name, 0);
        int change = result.equals("승리") ? 2 : -1;
        int newScore = currentScore + change;

        if (newScore < 0) {
            newScore = 0;
        }

        userScores.put(name, newScore);
        scoreToUserMap.get(currentScore / 10).remove(name);
        scoreToUserMap.computeIfAbsent(newScore / 10, k -> new ArrayList<>()).add(name);
        return true;
    }
}
