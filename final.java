package Homework1;

public final class finalTopics {
    private final StringBuffer sb;

    private finalTopics() {
        sb = new StringBuffer("Hello World !!!");
    }

    private void getStringBuffer() {
        System.out.println(sb);
    } 

    private void updateStringBuffer() {
        sb.append(" Update!");
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
