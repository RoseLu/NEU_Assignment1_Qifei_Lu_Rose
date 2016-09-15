/*Scenario : Travelling to LA

        Description : A tourist is trying to find the cheapest flight to LA.

        Object : Tourist
        State :  name, email_address, password
        Behavior :  visitWebsite(), registerAnAccount(), setTheFilter(), findTheCheapestFlight(), PlaceOrderForTicket(),
                    payMoneyToWebsite()

        Object : Flight
        State :  flight_number, date, price, flight_company, class_level, destination, departure, remaining seats,
                 haveDiscount
        Behavior : getPrice(), getDate(), getClassLevel(), getDestination(), getDeparture(), getRemainingSeats()

        Object : Ticket
        State : ticketNumber, flight_number

        Object : Price
        State : amount

        Object : TravelWebsite
        State : Collection of tickets
        Behavior :  searchAccordingToFilter(), orderAvailableFlightInAscendingPrice(), acceptMoneyFromTourist(),
                    sendTicketNumberToTourist()

        Object : FlightFilter
        State : date, class_level, departure, destination
        Behavior : provideChoices()

*/
class Tourist {
    String name;
    String email_address;
    String password;

    void visitWebsite(TravelWebsite a) {
    }

    void registerAnAccount(String email_address, String password) {
    }

    FlightFilter setTheFilter(String date, String class_level, String departure, String destination) {
    }

    Flight findTheCheapestFlight(Price[] prices) {
    }

    Ticket PlaceOrderForTicket(Flight b) {
    }

    Price payMoneyToWebsite(TravelWebsite a) {
    }
}

class Flight {
    String flight_number;
    String date;
    Float price;
    String flight_company;
    String class_level;
    String destination;
    String departure;
    int remaining_seats;
    boolean haveDiscount;

    Float getPrice() {
    }

    String getDate() {
    }

    String getClassLevel() {
    }

    String getDestination() {
    }

    String getDeparture() {
    }

    int getRemainingSeats() {
    }
}

class Ticket {
    String ticketNumber;
    String flight_number;
}

class Price {
    Float amount;
}

class TravelWebsite {
    Price[] prices;

    void searchAccordingToFilter(FlightFilter condition) {
    }

    Price[] orderAvailableFlightInAscendingPrice() {
    }

    void acceptMoneyFromTourist(Tourist a, Price price) {
    }

    void sendTicketNumberToTourist(String ticketNumber, Tourist a) {
    }
}

class FlightFilter {
    String date;
    String class_level;
    String departure;
    String destination;

    void provideChoices() {
    }
}

public class TravellingToLA {
    public static void main(String[] args) {
        Tourist rose = new Tourist();
        rose.name = "rose";
        rose.email_address = "lu.qi@husky.neu.edu";
        rose.password = "123456";

        Flight DL588 = new Flight();
        DL588.price = 100.0f;
        DL588.flight_number = "DL588";
        Flight CA355 = new Flight();
        CA355.price = 200.0f;
        Flight[] flights = {DL588, CA355};

        Ticket numberOneTicket = new Ticket();
        numberOneTicket.ticketNumber = "01247965";

        TravelWebsite studentUniverse = new TravelWebsite();

        rose.visitWebsite(studentUniverse);
        rose.registerAnAccount(rose.email_address, rose.password);
        FlightFilter condition = rose.setTheFilter("12-20-2016", "Economy", "Seattle", "LA");
        studentUniverse.searchAccordingToFilter(condition);
        // visit StudentUniverse Website and search for flight under condition

        Price[] prices = studentUniverse.orderAvailableFlightInAscendingPrice();
        Flight cheapestFlight = rose.findTheCheapestFlight(prices);
        // chose the No.1 flight, which is the cheapest flight

        Ticket chosenTicket = rose.PlaceOrderForTicket(cheapestFlight);
        // chosenTicket is one of the ticket for cheapestFlight
        Price priceForPayment = rose.payMoneyToWebsite(studentUniverse);
        studentUniverse.acceptMoneyFromTourist(rose, priceForPayment);
        studentUniverse.sendTicketNumberToTourist(chosenTicket.ticketNumber, rose);
        // place order and make a payment and receive ticket number
    }
}
