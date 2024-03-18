import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class ListWorker {
    Random rnd = new Random();
    ArrayList<Integer> list1 = new ArrayList<>();
    ArrayList<Integer> list2 = new ArrayList<>();
    Object lock1 = new Object();
    Object lock2 = new Object();

    public void list1addvalue() {
        synchronized (lock1) {
            for (int i = 1; i < 1000; i++) {
                list1.add(i);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    System.out.println("Sleep function is interrupted");
                }
            }
        }
    }
    public void list2addvalue() {
        synchronized (lock2) {
            for (int i = 1; i < 1000; i++) {
                list2.add(i);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    System.out.println("Sleep function is interrupted");
                }
            }
        }
    }
    public void addValue(){
        list1addvalue();
        list2addvalue();
    }
    public void runfunctions(){

        Thread thread1= new Thread(new Runnable() {
            @Override
            public void run() {
                addValue();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
              addValue();
            }
        });

        thread2.start();
        thread1.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("The interruped exception occurred");
        }

        System.out.println("size list1 :" + list1.size() + " size list2 : " + list2.size() );

    }
}