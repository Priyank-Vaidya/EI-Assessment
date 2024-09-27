package Educational_Incentives.Excercise1.Creational.Factory;

public class Main {
    public static void main(String[] args) {
        VehicleFactory vehicleFactory = new VehicleFactory();

        Vehicle car = vehicleFactory.createVehicle("CAR");
        car.ride();

        Vehicle bike = vehicleFactory.createVehicle("BIKE");
        bike.ride();

        Vehicle truck = vehicleFactory.createVehicle("TRUCK");
        truck.ride();
    }
}

