package semi01.project;
import java.util.*;
public class RoomReservation {

    protected String guestName;
    protected int duration;
    protected int numberOfGuests;
    protected String roomType;

    protected int totalPrice;
    protected boolean breakfastIncluded;

    public RoomReservation(String guestName, int duration, int numberOfGuests,String roomType) {
        this.guestName = guestName;
        this.duration = duration;
        this.roomType = roomType;
        this.numberOfGuests = numberOfGuests;
        this.breakfastIncluded = false; // 기본적으로 조식 제공하지 않음
    }

    public String getGuestName() {
        return guestName;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }



    public boolean isBreakfastIncluded() {
        return breakfastIncluded;
    }

    public void setBreakfastIncluded(boolean breakfastIncluded) {
        this.breakfastIncluded = breakfastIncluded;
    }

    public void calculateTotalPrice() {
        // 각 하위 클래스에서 구현할 가격 계산 메서드
        totalPrice = numberOfGuests*totalPrice;
    }


    public String toString() {
        return  "예약자명: " + guestName + '\'' +
                ", 인원수: " + duration +
                ", 방이름: " + roomType + '\'' +
                ", 예약일수: " + numberOfGuests + '\'' +
                ", 값: " + totalPrice +
                ", 조식제공: " + breakfastIncluded;
    }
}