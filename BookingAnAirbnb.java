/*Scenario : Booking an Airbnb

        Description : A tourist wants to book a house on Airbnb app.

        Object : Customer
        State :  email_address, password, name
        Behavior :  openApp(), logInToAccount(), setTheFilter(), findTheHouseInterestedIn(), placeOrderForHouse(),
                    payMoneyToApp()

        Object : Landlord
        State :  email_address, password, owned_house_id, name
        Behavior :  uploadHouseInformation(), acceptOrder(), receiveMoney()

        Object : App
        State :  Collection of houses
        Behavior : registerNeuUser(), searchForHouses(), displayAvailableHouses(), acceptMoneyFromConsumer(),
                   transferMoneyToLandlord(), transferMoneyToCustomer(), sendConfirmEmailToCustomer()

        Object : House
        State :  name, city, address, room_type, description, price, available_startDate, available_endDate,
                 maximumVisitors
        Behavior : getHouseLocation(), getHouseAvailableDate(), getHouseType(), getHousePrice(),
                   getHouseMaximumVisitors()

        Object : Filter
        State :  city, room_type, startDate, endDate, lowPrice, highPrice,numberOfVisitor
        Behavior : provideChoices()

        Object : Money
        State :  amount
*/
class Customer {
    String name;
    String email_address;
    String password;

    void openApp(App a) {
    }

    void logInToAccount(String email_address, String password) {
    }

    Filter setTheFilter(String city, String room_type, String startDate, String endDate, float lowPrice, float highPrice, int numberOfVisitor) {
    }

    House findTheHouseInterestedIn(House[] houses) {
    }

    void placeOrderForHouse(House favouriteHouse) {
    }

    Money payMoneyToApp(App a) {
    }
}

class Landloard {
    String name;
    String email_address;
    String password;
    String owned_house_id;

    void uploadHouseInformation(House a) {
    }

    boolean acceptOrder() {
    }

    void receiveMoney(Money money) {
    }
}

class App {
    House[] houses;

    void registerNeuUser(String email_address, String password) {
    }

    void searchForHouses(Filter condition) {
    }

    House[] displayAvailableHouses() {
    }

    void acceptMoneyFromConsumer(Customer a, Money money) {
    }

    void transferMoneyToLandlord(Landloard b, Money money) {
    }

    void transferMoneyToCustomer(Customer a) {
    }

    void sendConfirmEmailToCustomer(Customer a) {
    }
}

class House {
    String name;
    String city;
    String address;
    String description;
    String room_type;
    String available_startDate;
    String availabe_endDate;
    float price;
    int maximumVisitors;

    String getHouseLocation() {
    }

    String getHouseAvailableDate() {
    }

    String getHouseType() {
    }

    Integer getHousePrice() {
    }

    Integer getHouseMaximumVisitors() {
    }
}

class Filter {
    String city;
    String room_type;
    String startDate;
    String endDate;
    float lowPrice;
    float highPrice;
    int numberOfVisitor;

    void provideChoices() {
    }
}

class Money {
    float amount;
}

public class BookingAnAirbnb {
    public static void main(String[] args) {
        Customer rose = new Customer();
        rose.email_address = "lu.qi@husky.neu.edu";
        rose.password = "123456";

        House a_house = new House();
        a_house.name = "a";
        House b_house = new House();
        b_house.name = "b";
        House[] houses = {a_house, b_house};

        Landloard jack = new Landloard();
        jack.uploadHouseInformation(a_house);

        App airbnb = new App();
        airbnb.houses = houses;

        rose.openApp(airbnb);
        airbnb.registerNeuUser("lu.qi@husky.neu.edu", "123456");
        rose.logInToAccount(rose.email_address, rose.password);
        Filter condition = rose.setTheFilter("LA", "Shared_Room", "12-23-2016", "12-26-2016", 80.0f, 150.0f, 2);
        airbnb.searchForHouses(condition);
        // open app and search for houses under condition

        House[] houseAvailable = airbnb.displayAvailableHouses();
        House chosenHouse = rose.findTheHouseInterestedIn(houseAvailable);
        rose.placeOrderForHouse(chosenHouse);
        Money money = rose.payMoneyToApp(airbnb);
        airbnb.acceptMoneyFromConsumer(rose, money);
        if (jack.acceptOrder()) {
            airbnb.transferMoneyToLandlord(jack, money);
            jack.receiveMoney(money);
            airbnb.sendConfirmEmailToCustomer(rose);
        } else {
            airbnb.transferMoneyToCustomer(rose);
        }
        //choose jack's house and after jack accept the order, pay money
    }
}

