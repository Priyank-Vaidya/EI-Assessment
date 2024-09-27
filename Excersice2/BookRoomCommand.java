package Educational_Incentives.Excersice2;

import java.time.LocalTime;

public class BookRoomCommand implements Command {
    private MeetingRoom room;
    private LocalTime startTime;
    private int duration; // Duration in minutes

    public BookRoomCommand(MeetingRoom room, LocalTime startTime, int duration) {
        this.room = room;
        this.startTime = startTime;
        this.duration = duration;
    }

    @Override
    public void execute() {
        if (room.book(startTime, duration)) {
            System.out.println("Room " + room.getRoomNumber() + " successfully booked from " + startTime + " for " + duration + " minutes.");
        } else {
            System.out.println("Failed to book Room " + room.getRoomNumber() + " because it is already booked.");
        }
    }
}
