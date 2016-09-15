/*Scenario : Order for delivery

       Description : A consumer is going to order a delivery through phone calls.

        Object : Consumer
        State : name, phoneNumber, address
        Behavior : makePhoneCallsToSomeone(), placeOrderForDelivery(), receiveStuffPackage(), payMoneyToCourier()

        Object : DeliveryCompany
        State : company_name, phoneNumber, collection of StuffToBeDelivered, collection of Couriers
        Behavior : answerPhoneCalls(), prepareStuff(), arrangeCourierToDeliver(), receiveMoneyFromCourier()

        Object : CellPhone
        State : owner_name, phone_number
        Behavior : connectTwoPeople()

        Object : Courier
        State : name, employee_id, availableOrNot, workingTimeStart, workingTimeEnd
        Behavior : pickUpStuffPackage(), deliveryOnTheWay(), sentStuffPackageToConsumer(), receiveMoneyFromConsumer(),
                   transferMoneyToDeliveryCompany()

        Object : StuffOrdered
        State : name, delivery_time, quantity, price

        Object : TotalMoney
        State : amount
*/

class Consumer {
    String name;
    String phoneNumber;
    String address;

    void makePhoneCallsToSomeone(CellPhone company) {
    }

    void placeOrderForDelivery(StuffOrdered stuff) {
    }

    void receiveStuffPackage(StuffOrdered stuff) {
    }

    TotalMoney payMoneyToCourier(Courier employee) {
    }
}

class DeliveryCompany {
    String company_name;
    String phoneNumber;
    StuffOrdered[] stuffStorage;
    Courier[] deliveryTeam;

    void answerPhoneCalls(CellPhone consumer) {
    }

    void prepareStuff(StuffOrdered stuffPackage) {
    }

    Courier arrangeCourierToDeliver() {
    }

    void receiveMoneyFromCourier(TotalMoney money, Courier employee) {
    }
}

class CellPhone {
    String owner_name;
    String phone_number;

    void connectTwoPeople(String phone_number_1, String phone_number_2) {
    }
}

class Courier {
    String name;
    String employee_id;
    boolean availableOrNot;
    String workingTimeStart;
    String workingTimeEnd;

    void pickUpStuffPackage(StuffOrdered stuff) {
    }

    void deliveryOnTheWay() {
    }

    StuffOrdered sentStuffPackageToConsumer(Consumer a) {
    }

    TotalMoney receiveMoneyFromConsumer(TotalMoney money, Consumer a) {
    }

    void transferMoneyToDeliveryCompany(DeliveryCompany b, TotalMoney money) {
    }
}

class StuffOrdered {
    String name;
    String delivery_time;
    String quantity;
    Float price;
}

class TotalMoney {
    Float amount;
}

public class OrderForDelivery {
    public static void main(String[] args) {
        Consumer rose = new Consumer();
        rose.name = "rose";
        rose.phoneNumber = "123456";

        Courier jack = new Courier();
        jack.availableOrNot = true;
        Courier john = new Courier();
        john.availableOrNot = false;
        Courier[] couriers = {jack, john};

        DeliveryCompany PrimeNow = new DeliveryCompany();
        PrimeNow.company_name = "Prime_Now";
        PrimeNow.phoneNumber = "456789";
        PrimeNow.deliveryTeam = couriers;

        CellPhone rose_phone = new CellPhone();
        rose_phone.phone_number = rose.phoneNumber;
        CellPhone PrimeNow_phone = new CellPhone();
        PrimeNow_phone.phone_number = PrimeNow.phoneNumber;

        StuffOrdered food = new StuffOrdered();
        food.name = "chicken_wings";
        food.quantity = "ten_pieces";
        food.delivery_time = "15-09-2016-7pm";

        rose.makePhoneCallsToSomeone(PrimeNow_phone);
        rose_phone.connectTwoPeople(rose.phoneNumber, PrimeNow.phoneNumber);
        PrimeNow.answerPhoneCalls(rose_phone);
        //make a phone call

        rose.placeOrderForDelivery(food);
        PrimeNow.prepareStuff(food);
        PrimeNow.arrangeCourierToDeliver();
        if (jack.availableOrNot) {
            jack.pickUpStuffPackage(food);
            jack.deliveryOnTheWay();
            StuffOrdered packageDelivered = jack.sentStuffPackageToConsumer(rose);
            rose.receiveStuffPackage(packageDelivered);
            TotalMoney money = rose.payMoneyToCourier(jack);
            jack.receiveMoneyFromConsumer(money, rose);
            jack.transferMoneyToDeliveryCompany(PrimeNow, money);
            PrimeNow.receiveMoneyFromCourier(money, jack);
        }
        //Courier jack sent delivery to Consumer rose
    }
}