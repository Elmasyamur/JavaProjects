import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ProducerConsumer {
Random rnd= new Random();
Object lock= new Object();
Queue<Integer> queue = new LinkedList<Integer>();
private int limit= 10; // max 10 integer

    public void produce() {
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("The interrupted exception occurred");
            }
            synchronized (lock){
                if(queue.size()==limit){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        System.out.println("The interrupted exception occurred");
                    }
                }
                Integer value = rnd.nextInt(100);
                queue.offer(value);
                System.out.println("Producer is producing -> " + value);
                lock.notify();
            }
        }
    }
    public void consume(){
    while(true){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("The interrupted exception occurred");
        }
        synchronized (lock){
            if(queue.size()==0){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println("The interrupted exception occurred");
                }
            }
            Integer value= queue.poll();
            System.out.println("Consumer is consuming -> " + value);
            System.out.println("Queue size : " + queue.size() );
            lock.notify();
        }
    }

    }
}
