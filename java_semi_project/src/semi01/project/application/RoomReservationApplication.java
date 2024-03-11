package semi01.project.application;

import semi01.project.DoubleRoomReservation;
import semi01.project.RoomReservation;
import semi01.project.SweetRoomReservation;
import semi01.project.TwinRoomReservation;

import java.util.*;
public class RoomReservationApplication {
    private ArrayList<RoomReservation> reservations;

    public RoomReservationApplication() {
        reservations = new ArrayList<RoomReservation>();

    }

    public void reserveRoom() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("예약자 이름:");
        String guestName = scanner.nextLine();
        System.out.println("인원:");
        int duration = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("예약일수:");
        int numberOfGuests = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("방이름 (Single/Double/Twin/Sweet):");
        String roomType = scanner.nextLine();

        // 예약을 만들고 리스트에 추가
        RoomReservation reservation;
        switch (roomType.toLowerCase()) {
            case "single":
                reservation = new RoomReservation(guestName, duration, numberOfGuests, roomType);
                break;
            case "double":
                reservation = new DoubleRoomReservation(guestName, duration, numberOfGuests, roomType);
                break;
            case "twin":
                reservation = new TwinRoomReservation(guestName, duration, numberOfGuests, roomType);
                break;
            case "sweet":
                reservation = new SweetRoomReservation(guestName, duration, numberOfGuests, roomType);
                break;
            default:
                System.out.println("경고: 방이름이 정확하지 않습니다.");
                return;
        }

        reservations.add(reservation);
        System.out.println("예약이 완료되었습니다.");
    }

    public void displayAllRooms() {
        System.out.println("Room Types:");
        System.out.println("Single Room: 100,000원, 할인: 없음, 조식제공: 없음");
        System.out.println("Double Room: 200,000원, 할인: 5% (3박 이상시), 조식제공: 없음");
        System.out.println("Twin Room: 250,000원, 할인: 10% (3박 이상시), 조식제공: 없음");
        System.out.println("Sweet Room: 500,000원, 할인: 20% (3박 이상시), 조식제공: 있음");
    }

    public void displayAllReservations() {
        System.out.println("예약자 목록:");
        for (RoomReservation reservation : reservations) {
            System.out.println(reservation);
        }
    }

    public void displayReservationByGuest(String guestName) {
        System.out.println("예약자 이름 " + guestName);
        for (RoomReservation reservation : reservations) {
            if (reservation.getGuestName().equalsIgnoreCase(guestName)) {
                System.out.println(reservation);
            }
        }
    }

    public static void main(String[] args) {
        RoomReservationApplication app = new RoomReservationApplication();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n1. 예약하기");
            System.out.println("2. 가격표");
            System.out.println("3. 예약자 목록");
            System.out.println("4. 예약확인");
            System.out.println("5.종료");
            System.out.print("답변:");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    app.reserveRoom();
                    break;
                case 2:
                    app.displayAllRooms();
                    break;
                case 3:
                    app.displayAllReservations();
                    break;
                case 4:
                    System.out.println("예약자 이름:");
                    String guestName = scanner.nextLine();
                    app.displayReservationByGuest(guestName);
                    break;
                case 5:
                    running = false;
                    break;
            }
        }
    }
}