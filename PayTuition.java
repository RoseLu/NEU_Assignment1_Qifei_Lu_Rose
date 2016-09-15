/*Scenario : Pay tuition

        Description : A student wants to pay his tuition through myNEU account

        Object : Student
        State : name, NEU_id, email_address, password
        Behavior : visitWebsite(), logInToNEUAccount(),placeOrderForPayment(), payMoneyToWebsite()

        Object : Website
        State : Collection of taskBar
        Behavior : displayAvailableTaskBar(),  enterInToSpecificTask(), showBills(), acceptMoneyFromStudent(),
                   sentReceiptToStudent(),

        Object : E_bill
        State : name, NEU_id, invoiceNumber, price, dueDate, description
        Behavior : getDueDate(), getPrice(), getName()

        Object : Tuition
        state : amount, currencyCode

        Object : BankCard
        State : cardName, cardId, securityCode，expireDate
        Behavior : makePayment()
*/

class Student {
    String name;
    String NEU_id;
    String email_address;
    String password;

    void visitWebsite(Website web) {
    }

    void logInToNEUAccount(String name, String password) {
    }

    void placeOrderForPayment(E_bill bil) {
    }

    Tuition payMoneyToWebsite(Website web, BankCard card, Float totalAmount) {
    }
}

class Website {
    String[] taskBar;

    String[] displayAvailableTaskBar() {
    }

    void enterInToSpecificTask(String taskName) {
    }

    E_bill showBills(Student a) {
    }

    void acceptMoneyFromStudent(Student a, Tuition money) {
    }

    void sentReceiptToStudent(String email_address) {
    }
}

class E_bill {
    String name;
    String NEU_id;
    String invoiceNumber;
    float price;
    String dueDate;
    String description;

    String getDueDate() {
    }

    String getName() {
    }

    Float getPrice() {
    }
}

class Tuition {
    float amount;
    String currencyCode;
}

class BankCard {
    String cardName;
    String cardId;
    String securityCode;
    String expireDate;

    void makePayment(Website web) {
    }
}

public class PayTuition {
    public static void main(String[] args) {
        Website myNeu = new Website();
        String[] tasks = {"myNEU Central", "Self-Service", "Community", "CO-OP", "Career Development", "InfoChannels"};
        myNeu.taskBar = tasks;

        Student rose = new Student();
        rose.name = "rose";
        rose.password = "123456";
        rose.email_address = "lu.qi@husky.neu.edu";

        BankCard citi = new BankCard();

        rose.visitWebsite(myNeu);
        rose.logInToNEUAccount(rose.name, rose.password);
        String[] allTasks = myNeu.displayAvailableTaskBar();
        myNeu.enterInToSpecificTask("Self-Service");
        E_bill tuitionBill = myNeu.showBills(rose);
        // visit MyNEU website and find E-bill

        rose.placeOrderForPayment(tuitionBill);
        Tuition money = rose.payMoneyToWebsite(myNeu, citi, tuitionBill.getPrice());
        citi.makePayment(myNeu);
        myNeu.acceptMoneyFromStudent(rose, money);
        myNeu.sentReceiptToStudent(rose.email_address);
        // use bank card to pay tuition and receive receipt
    }
}
