public class Worker implements Runnable{
 private String name;
 private int task_id;
 public Worker(String name, int id){
     this.name=name;
     task_id= id;
 }
    @Override
    public void run() {
        System.out.println("Worker " + name + " started work " + task_id);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("The iterrupted exception occurred ");
        }
        System.out.println("Worker " + name + " finished work " + task_id);
    }
}
