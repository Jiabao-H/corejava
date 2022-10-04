package Homework1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java8 {

    // abstract class - CreditCard (holderName cardNumber accountBalance cardType)
    // no implemented method - isCardAcceptable implemented method - paybill
    // VisaCard MasterCard inherit CreditCard class
    // constructor both class and isCard method

    public interface CreditCard{
    // private the filed

        public abstract boolean isCardAcceptable(String cardType);

        default void payBill(double bill){
            System.out.println("Bill is paid with amount: " + bill);
        }

        static void refund(double amount){
            System.out.println("refund is applied to account");
        }
    }

    //implemets  CreditCard interface

    public class VisaCard implements CreditCard{

        public VisaCard() {
            super();
        }

        // override this subclass
        @Override
        public boolean isCardAcceptable(String cardType) {
            if("visa".equalsIgnoreCase(cardType)){
                return true;
            }else{
                return false;
            }
        }
    }



    // functional interface 
    
    @FunctionalInterface
    public interface MyFunctionalInterface{
        public int apply(int num);
    }

    @FunctionalInterface
    public interface MyFunctionalInterface2{
        public boolean filter(int num);
    }

    public class MyStream{
        public List<Integer> myMap(List<Integer> list, MyFunctionalInterface myFunctionalInterface){
            List<Integer> result = new ArrayList<>();
            for(int num : list){
                result.add(myFunctionalInterface.apply(num));
            }
            return result;
        }

        public List<Integer> myFilter(List<Integer> list, MyFunctionalInterface2 myFunctionalInterface){
            List<Integer> result = new ArrayList<>();
            for(int num: list){
                if(myFunctionalInterface.filter(num)){
                    result.add(num);
                }
            }
            return result;
        }
    }

    //lambda
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        MyStream myStream = new Homework_Java8().new MyStream();

        List<Integer> result = myStream.myFilter(list, o -> o > 3);
        System.out.println(result);
    }


    // "walabcwalexywalxzsfwalmx” - replace "wal" with "sams"
    public static String replace(String str){
        return Arrays.asList(str.split("wal")).stream().collect(Collectors.joining("sams"));
    }

  
    // "Eclipse eclipse Eclipse eclipse amc clip ECLIPSE" count the times this word which occurred and store into a map
    public void count(String str){
        Arrays.asList(str.toLowerCase().split("\\s+"))
                .stream().
                collect(Collectors.groupingBy(o->o, Collectors.summingInt(o->1)));
    }

}
