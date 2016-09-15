import java.util.List;

/*Scenario : Drive home

        Description : A student is driving home from school.

        Object : StudentDriver
        State : name, driverLicense, plate_number, car_id
        Behavior : startCar(), driveCar(), parkCar(), setNavigator(), understandDirectionsByNavigator(),
                   executiveDirections()

        Object : Car
        State : car_id, type, brand, plate_number, owner_name, runningOrNot, price
        Behavior : starting(), running(), back(), accelerate(), brake(), makeTurns()

        Object : Navigator
        State : name, currentLocation, mode, destination, collection of routes
        Behavior : showRoute(), getCurrentLocation(), calculateTime(), speakDirections()

        Object : Route
        State : departureLocation, destinationLocation, collections of directions

        Object : Location
        State : Address
*/
class StudentDriver {
    String name;
    String driverLicense;
    String plate_number;
    String car_id;

    void setNavigator(Location a, Location b) {
    }

    void startCar(Car c) {
    }

    void understandDirectionsByNavigator(Route schoolToHome) {
    }

    void driveCar(Car c) {
    }

    void executiveDirections(String direction) {
    }

    void parkCar(Car c) {
    }
}

class Car {
    String car_id;
    String type;
    String brand;
    String plate_number;
    String wner_name;
    boolean runningOrNot;
    Float price;

    void starting() {
    }

    void running(String direction) {
    }

    void back(Location parkinglot) {
    }

    void accelerate() {
    }

    void brake() {
    }

    void makeTurns() {
    }
}

class Navigator {
    String name;
    Location currentLocation;
    String mode;
    Location destination;
    Route[] routes;

    Route showRoute(Location a, Location b) {
    }

    Location getCurrentLocation() {
    }

    String calculateTime(Route c) {
    }

    String speakDirections(String direction) {
    }
}

class Route {
    Location departureLocation;
    Location destinationLocation;
    List<String> directions;
}

class Location {
    String address;
}

public class DrivingHome {
    public static void main(String[] args) {
        StudentDriver rose = new StudentDriver();
        rose.name = "rose";
        rose.driverLicense = "WA123456";

        Navigator gps = new Navigator();

        Car nissan = new Car();
        nissan.brand = "nissan";

        Location school = new Location();
        school.address = "401TerryAve";
        Location home = new Location();
        home.address = "910_8thAve";
        Location parkingLot = new Location();

        rose.setNavigator(school, home);
        Location currentLocation = gps.getCurrentLocation();
        Route routeOne = gps.showRoute(currentLocation, home);
        gps.calculateTime(routeOne);
        rose.startCar(nissan);
        // student start the car and set the navigator

        rose.driveCar(nissan);
        rose.understandDirectionsByNavigator(routeOne);
        for (String direction : routeOne.directions) {
            gps.speakDirections(direction);
            rose.executiveDirections(direction);
            nissan.running(direction);
        }
        // As listening to the directions spoken by the navigator, student is driving the car until all directions have been executived

        if (gps.currentLocation == home) {
            rose.parkCar(nissan);
            nissan.back(parkingLot);
        }
        //if currentLocation is home, which means student has already arrived at home, student may park the car
    }
}
