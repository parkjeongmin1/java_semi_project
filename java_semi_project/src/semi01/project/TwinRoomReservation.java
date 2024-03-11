package semi01.project;

public class TwinRoomReservation extends RoomReservation{

    private static final int PRICE_PER_NIGHT = 250000;
    private static final double DISCOUNT_RATE = 0.1;

    public TwinRoomReservation(String guestName, int duration, int numberOfGuests,String roomType) {
        super(guestName, duration, numberOfGuests,roomType);
        calculateTotalPrice();
    }

    @Override
    public void calculateTotalPrice() {
        totalPrice = PRICE_PER_NIGHT * numberOfGuests;
        if (numberOfGuests >= 3) {
            // 3박 이상 예약 시 할인 적용
            totalPrice -= totalPrice * DISCOUNT_RATE;
        }
    }
}
