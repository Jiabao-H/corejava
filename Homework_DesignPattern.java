package com.interview.coding.course;

public class Homework_DesignPattern {

    /**
     * Singleton
     */
    public static class AppleDesignerFactory{
        private static AppleDesignerFactory factory;
        private AppleDesignerFactory(){}

        public static synchronized AppleDesignerFactory getInstance(){
            if(factory == null){
                factory = new AppleDesignerFactory();
            }
            return factory;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException{
            throw new CloneNotSupportedException();
        }
    }

    /**
     * 2)	Create a factory pattern called “Currency” which takes in
     * the country name and return the currency object for that country.
     */
    public interface Currency {
        public Currency exchange();
    }

    public class USDollar implements Currency {
        public USDollar exchange(){
            return new USDollar();
        }
    }

    public class NewTaiwanDollar implements Currency {
        public NewTaiwanDollar exchange(){
            return new NewTaiwanDollar();
        }
    }

    public class CurrencyFactory{
        public Currency getLocalCurrency(String country){
            if("US".equalsIgnoreCase(country)){
                return new USDollar();
            }else if("TAIWAN".equalsIgnoreCase(country)){
                return new NewTaiwanDollar();
            }
            return null;
        }
    }
}
