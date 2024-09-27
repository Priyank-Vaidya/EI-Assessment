package Educational_Incentives.Excercise1.Creational.Factory;

// Vehicle Factory class
public class VehicleFactory {
    public Vehicle createVehicle(String vehicleType) {
        if (vehicleType == null) {
            return null;
        }
        if (vehicleType.equalsIgnoreCase("CAR")) {
            return new Car();
        } else if (vehicleType.equalsIgnoreCase("BIKE")) {
            return new Bike();
        } else if (vehicleType.equalsIgnoreCase("TRUCK")) {
            return new Truck();
        }
        return null;
    }
}
