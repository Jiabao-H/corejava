package Homework1;

/**
 * 1)	Define an interface “DatabaseConnection” and 
 * then define class “OracleConnection”, “MySqlConnection”, “SqlServerConnection”.
 * They should all implements the “getConnection” method from the interface.
 * The method should initialize data source and return a database connection. 
 * 
 * 2)	Define an abstract class “CreditCard” which contains fields (holderName, cardNumber, accountBalance, cardType),
 * and not-implemented method “isCardAcceptable” with argument cardType, and implemented method “payBill(double bill)”.
 * Define two classes “VisaCard” and “MasterCard” both should inherit this “CreditCard” class 
 * and you should define constructor for both classes and implement the “isCardAcceptable” method.
 * difference between abstract method and interface
 * 
 * 3)	Implement static and dynamic polymorphism.
 */

public class OOP {
    public interface DatabaseConnection {
        String getConnection(String data_source);
    }

    public class OracleConnection implements DatabaseConnection {
        String data_source1 = "Oracle";
        public String getConnection(String data_source1) {
            return data_source1;
        }
        public void printState() {
            System.out.println(getConnection(data_source1));
        }
    }

    public class MySqlConnection implements DatabaseConnection {
        String data_source2 = "MySQL";
        public String getConnection(String data_source2) {
            return data_source2;
        }
        public void printState() {
            System.out.println(getConnection(data_source2));
        }
    }

    public class sqlServerConnection implements DatabaseConnection {
        String data_source3 = "SQL Server";
        public String getConnection(String data_source3) {
            return data_source3;
        }
        public void printState() {
            System.out.println(getConnection(data_source3));
        }
    }

    public enum cardType {
        CREDIT_CARD,
        VISA,
        MASTER,
    }

    public abstract class CreditCard {
        String holderName;
        int cardNumber;
        static double accountBalance;
        cardType card_type = cardType.CREDIT_CARD;

        public CreditCard() {};

        abstract boolean isCardAccepted(cardType card_type);

        public void payBill(double bill) {
            if (accountBalance >= bill) {
                accountBalance -= bill;
                System.out.println("You have paid $" + bill + ".");
            }
            else
                System.out.println("Warning: insufficient balance to pay your bill!");
        }
        //polymorphism overload
        public void payBills(int bill) {
            accountBalance =- (double)bill;
        }
        public static void refund(double bill) {
            accountBalance = accountBalance + bill;
        }
    }

    public class VisaCard extends CreditCard {
        public VisaCard(String holderName, int cardNumber, double accountBalance) {
            super();
            super.holderName = holderName;
            super.cardNumber = cardNumber;
            super.card_type = cardType.VISA;
            // super.accountBalance = accountBalance;
        }
        // dynamic polymorphism
        @Override
        boolean isCardAccepted(cardType card_type) {
            return card_type.equals(cardType.VISA);
        }

        // public static void main(String[] args) {
        //     CreditCard cheese = new VisaCard("1", 001, 200.00);
        //     cheese.payBill(100.00);
        // }
    }

    public class MasterCard extends CreditCard {
        public MasterCard(String holderName, int cardNumber, double accountBalance, cardType card_type) {
            super();
            super.holderName = holderName;
            super.cardNumber = cardNumber;
            super.card_type = cardType.MASTER;
            // super.accountBalance = accountBalance;
        }

        @Override
        boolean isCardAccepted(cardType card_type) {
            return card_type.equals(cardType.MASTER);
        }

        // public static void main(String[] args) {
        //     CreditCard master = new MasterCard("2", 002, 500.00);
        //     master.isCardAccepted(cardType.MASTER);
        // }
    }
}
