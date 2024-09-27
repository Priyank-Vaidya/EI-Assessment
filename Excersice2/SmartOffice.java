package Educational_Incentives.Excersice2;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;

public class SmartOffice {
    private static final Scanner scanner = new Scanner(System.in);
    private static OfficeConfiguration officeConfiguration;

    public static void main(String[] args) {
        officeConfiguration = OfficeConfiguration.getInstance();
        String command;

        while (true) {
            System.out.println("Enter command: ");
            command = scanner.nextLine().trim();
            handleCommand(command);
        }
    }

    private static void handleCommand(String command) {
        String[] parts = command.split(" ");
        if (parts.length == 0) return;

        switch (parts[0].toLowerCase()) {
            case "config":
                configureRooms(parts);
                break;
            case "block":
                bookRoom(parts);
                break;
            case "cancel":
                cancelRoom(parts);
                break;
            case "add":
                addOccupants(parts);
                break;
            case "remove":
                removeOccupants(parts);
                break;
            default:
                System.out.println("Unknown command.");
        }
    }

    private static void configureRooms(String[] parts) {
        if (parts.length >= 2) {
            try {
                if (Objects.equals(parts[2], "count")){
                    int roomCount = Integer.parseInt(parts[3]);
                    officeConfiguration.configureRooms(roomCount);
                }
                else if(Objects.equals(parts[2], "max") && Objects.equals(parts[3], "capacity")){
                    try {
                        int roomNo = Integer.parseInt(parts[4]);
                        if(roomNo < 0){
                            System.out.println("Invalid room number");
                            throw new IllegalArgumentException("Invalid room number");
                        }
                        int maxCapacity = Integer.parseInt(parts[5]);

                        officeConfiguration.getRoom(roomNo).setMaxCapacity(maxCapacity);
                    }
                    catch (NumberFormatException e){
                        System.out.println("Invalid room number: Kindly check your room number");
                    }
                    //This will set the maximum capacity of tha particular room number
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a valid positive number.");
            }
        }
    }

    private static void bookRoom(String[] parts) {
        if (parts.length == 5) {
            try {
                int roomNumber = Integer.parseInt(parts[2]);
                LocalTime startTime = LocalTime.parse(parts[3], DateTimeFormatter.ofPattern("HH:mm"));
                int duration = Integer.parseInt(parts[4]);
                MeetingRoom room = officeConfiguration.getRoom(roomNumber);
                if (room != null) {
                    new BlockRoomCommand(room, startTime, duration).execute();
                } else {
                    System.out.println("Invalid room number. Please enter a valid room number.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter valid time (HH:mm) and duration.");
            }
        } else {
            System.out.println("Usage: block <room_number> <start_time> <duration_in_minutes>");
        }
    }


    private static void cancelRoom(String[] parts) {
        if (parts.length == 3) {
            try {
                int roomNumber = Integer.parseInt(parts[2]);
                MeetingRoom room = officeConfiguration.getRoom(roomNumber);
                if (room != null) {
                    new CancelBookingCommand(room).execute();
                } else {
                    System.out.println("Invalid room number. Please enter a valid room number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid room number.");
            }
        }
    }

    private static void addOccupants(String[] parts) {
        if (parts.length == 4) {
            try {
                int roomNumber = Integer.parseInt(parts[2]);
                int count = Integer.parseInt(parts[3]);
                MeetingRoom room = officeConfiguration.getRoom(roomNumber);
                if (room != null) {
                    room.addOccupants(count);
                    if (room.currentOccupancy >= 2) {
                        room.turnOnUtilities();
                    }
                } else {
                    System.out.println("Room " + roomNumber + " does not exist.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter valid numbers.");
            }
        }
    }

    private static void removeOccupants(String[] parts) {
        if (parts.length == 4) {
            try {
                int roomNumber = Integer.parseInt(parts[2]);
                int count = Integer.parseInt(parts[3]);
                MeetingRoom room = officeConfiguration.getRoom(roomNumber);
                if (room != null) {
                    room.removeOccupants(count);
                } else {
                    System.out.println("Room " + roomNumber + " does not exist.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter valid numbers.");
            }
        }
    }
}
