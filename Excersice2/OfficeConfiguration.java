package Educational_Incentives.Excersice2;

import java.util.ArrayList;
import java.util.List;

public class OfficeConfiguration {
    private static OfficeConfiguration instance;
    private List<MeetingRoom> rooms;

    private OfficeConfiguration() {
        rooms = new ArrayList<>();
    }

    public static synchronized OfficeConfiguration getInstance() {
        if (instance == null) {
            instance = new OfficeConfiguration();
        }
        return instance;
    }

    public void configureRooms(int count) {
        rooms.clear();
        for (int i = 1; i <= count; i++) {
            rooms.add(new MeetingRoom(i));
        }
        System.out.println("Office configured with " + count + " meeting rooms: " + rooms);
    }

    public MeetingRoom getRoom(int roomNumber) {
        return rooms.stream()
                .filter(room -> room.getRoomNumber() == roomNumber)
                .findFirst()
                .orElse(null);
    }
}
