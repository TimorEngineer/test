package com.timor.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadTest {
    public static void main(String[] args) {
        ThreadTest threadTest=new ThreadTest();
        threadTest.start();

        RunalbeTest runalbeTest=new RunalbeTest();
        Thread thread=new Thread(runalbeTest);
        thread.start();

        CallableTest callableTest=new CallableTest();
        FutureTask<Integer> ft = new FutureTask<Integer>(callableTest);
        Thread thread2=new Thread(ft);
        thread2.start();
        try {
            System.out.println("返回值:"+ft.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private void start() {
    }
}

//class ThreadTest extends Thread{
//    @Override
//    public void run() {
//        System.out.println("这是一个Thread的线程!");
//    }
//}

class RunalbeTest implements Runnable{
    @Override
    public void run() {
        System.out.println("这是一个Runnable的线程!");
    }
}

class CallableTest implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("这是一个Callable的线程!");
        return 2;
    }
}
