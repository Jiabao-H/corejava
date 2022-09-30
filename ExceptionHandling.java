
public class ExceptionHandling {

    public class CardTypeException extends Exception{
        public CardTypeException(String errorMessage){
            System.out.println("CardTypeException: " + errorMessage);
        }
    }
    public class AddressException extends Exception{
        public AddressException(String errorMessage){
            System.out.println("AddressException: " + errorMessage);
        }
    }

    public class ExceptionHandler{
        public void handleException(String cardType, String address){
            try {
                if ("AMEX".equalsIgnoreCase(cardType)) {
                    throw new CardTypeException("American Express Not Accepted");
                } 
                else if (address != null || !address.toLowerCase().contains("us")) {
                    throw new AddressException("Address is not valid");
                } 
                else {
                    throw new Exception("Generic exception");
                }
            }
            //else and else if is different
            catch(Exception e){
                if(e instanceof CardTypeException){
                    System.out.println("CardTypeException: " + e.getMessage());
                }
                else if(e instanceof AddressException){
                    System.out.println("AddressException: " + e.getMessage());
                }
                else{
                    System.out.println("Generic Exception: " + e.getMessage());
                }
            }
        }
    }
}
