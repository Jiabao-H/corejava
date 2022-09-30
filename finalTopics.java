package Homework1;

public final class finalTopics {
    private final StringBuffer SB;

    private finalTopics() {
        SB = new StringBuffer("Hello World");
    }

    private void getStringBuffer() {
        System.out.println(SB);
    } 

    private void updateStringBuffer() {
        SB.append(" Updated!");
    }

    private final static void demo() {
        finalTopics obj = new finalTopics();
        obj.getStringBuffer();
        obj.updateStringBuffer();
        obj.getStringBuffer();
    }

    public static void main(String[] args) {
        demo();
    }
}
