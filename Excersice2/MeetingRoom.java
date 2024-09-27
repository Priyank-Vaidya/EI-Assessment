package Educational_Incentives.Excersice2;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

class MeetingRoom {
    private int roomNumber;
    private int maxCapacity;
    private LocalTime bookedStartTime;
    private int bookedDuration;
    private boolean booked;
    private Timer timer;
    private List<OccupancyObserver> observers = new ArrayList<>();
    int currentOccupancy;

    public MeetingRoom(int roomNumber) {
        this.roomNumber = roomNumber;
        this.maxCapacity = 10; // Default capacity
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setMaxCapacity(int capacity) {
        this.maxCapacity = capacity;
        System.out.println("Room " + roomNumber + " maximum capacity set to " + capacity + ".");
    }

    public boolean isBooked() {
        return booked;
    }

    public boolean book(LocalTime startTime, int duration) {
        if (!booked) {
            this.booked = true;
            this.bookedStartTime = startTime;
            this.bookedDuration = duration;
            startAutoRelease();
            System.out.println("Room " + roomNumber + " booked from " + startTime + " for " + duration + " minutes.");
            return true;
        } else {
            System.out.println("Room " + roomNumber + " is already booked.");
            return false;
        }
    }

    public void cancelBooking() {
        this.booked = false;
        currentOccupancy = 0;
        notifyObservers();
    }

    public void addOccupants(int count) {
        currentOccupancy += count;
        if (currentOccupancy >= 2) {
            notifyObservers();
        } else {
            System.out.println("Room " + roomNumber + " occupancy insufficient to mark as occupied.");
        }
    }

    public void removeOccupants(int count) {
        currentOccupancy -= count;
        if (currentOccupancy < 0) currentOccupancy = 0;
        if (currentOccupancy < 2) {
            System.out.println("Room " + roomNumber + " is now unoccupied. AC and lights turned off.");
            turnOffUtilities();
        }
    }

    public void checkBookingExpiration() {
        if (booked && LocalTime.now().isAfter(bookedStartTime.plusMinutes(bookedDuration))) {
            System.out.println("Room " + roomNumber + " booking expired. Automatically releasing.");
            cancelBooking();
        }
    }

    public void turnOnUtilities() {
        System.out.println("Room " + roomNumber + " is now occupied by " + currentOccupancy + " persons. AC and lights turned on.");
    }

    public void turnOffUtilities() {
        System.out.println("Room " + roomNumber + " is now unoccupied. AC and lights turned off.");
    }

    public void addObserver(OccupancyObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (OccupancyObserver observer : observers) {
            observer.onOccupancyChange(this);
        }
    }

    public void startAutoRelease() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (currentOccupancy < 2) {
                    System.out.println("Room " + roomNumber + " automatically released due to inactivity.");
                    cancelBooking();
                    timer.cancel();
                }
            }
        }, 5 * 60 * 1000); // 5 minutes
    }
}
