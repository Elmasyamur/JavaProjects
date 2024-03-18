import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for( int i=1 ;i <=5 ; i++){
            executor.submit(new Worker(String.valueOf(i),i));
        }
        executor.shutdown();
        System.out.println("All work has been delivered");
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("All work has been finished");
    }
    }
