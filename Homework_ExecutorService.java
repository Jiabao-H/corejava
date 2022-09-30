package com.interview.coding.course;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 1)	Define a inner class A has method “getMethod()”
 * which return string “A.getMethod” and another inner class B has method
 * “getMethod()” which return string “B.getMethod”.
 * write another method “runSameTime()”
 * which should let A and B getMethod to run at the same time,
 * but the “runSameTime()”
 * method should return a string “B.getMethod A.getMethod”
 */
public class Homework_ExecutorService {

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

    public void runSameTime(){
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        try{
            Future futureA = executorService.submit(()-> new A().getMethod());
            Future futureB = executorService.submit(()-> new B().getMethod());

            boolean notAllDone = true;
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
