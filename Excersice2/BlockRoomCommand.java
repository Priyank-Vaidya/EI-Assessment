package Educational_Incentives.Excersice2;

import java.time.LocalTime;

class BlockRoomCommand implements Command {
    private MeetingRoom room;
    private LocalTime startTime;
    private int duration; // in minutes

    public BlockRoomCommand(MeetingRoom room, LocalTime startTime, int duration) {
        this.room = room;
        this.startTime = startTime;
        this.duration = duration;
    }

    @Override
    public void execute() {
        if (room.book(startTime, duration)) {
            System.out.println("Room " + room.getRoomNumber() + " successfully booked.");
        } else {
            System.out.println("Failed to book Room " + room.getRoomNumber() + "is already occupied");
        }
    }
}
