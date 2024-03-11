package project;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SingletonUserManager userManager = SingletonUserManager.getInstance();

        while (true) {
            System.out.println("\n목록:");
            System.out.println("1. 사용자 등록하기");
            System.out.println("2. 모든 사용자의 정보");
            System.out.println("3. 승패 입력");
            System.out.println("4. 종료");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("사용자 이름: ");
                    String name = scanner.nextLine();
                    System.out.println("점수: ");
                    int score = scanner.nextInt();
                    userManager.registerUser(name, score);
                    break;
                case 2:
                    userManager.displayAllUsers();
                    break;
                case 3:
                    System.out.println("사용자 이름: ");
                    String userName = scanner.nextLine();
                    System.out.println("승패 (win/lose): ");
                    String result = scanner.nextLine();
                    userManager.updateUserScore(userName, result);
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("값을 제대로 입력해 주세요.");
            }
        }
    }
}
