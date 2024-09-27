package Educational_Incentives.Excersice2;

class CancelBookingCommand implements Command {
    private MeetingRoom room;

    public CancelBookingCommand(MeetingRoom room) {
        this.room = room;
    }

    @Override
    public void execute() {
        if (room.isBooked()) {
            room.cancelBooking();
            System.out.println("Booking for Room " + room.getRoomNumber() + " cancelled successfully.");
        } else {
            System.out.println("Room " + room.getRoomNumber() + " is not booked. Cannot cancel booking.");
        }
    }
}

