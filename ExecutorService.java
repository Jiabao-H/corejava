package Homework1;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class ExecutorService {

    public class A{
        public String getMethod(){
            return "A.getMethod";
        }
    }

    public class B{
        public String getMethod(){
            return "B.getMethod";
        }
    }

   //need to be excutorService
    public void runSameTime(){
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        try{
            Future futureA = executorService.submit(()-> new A().getMethod()); // futureA 
            Future futureB = executorService.submit(()-> new B().getMethod());// futureB

            //boolean notAllDone = true;
            while(notAllDone){
                if(futureA.isDone() && futureB.isDone()) {
                    notAllDone = false;
                }
            }

            System.out.println((String)futureB.get() + ", " + (String)futureA.get());

        }catch (InterruptedException | ExecutionException e2){
            System.out.println();
        }

    }
}
