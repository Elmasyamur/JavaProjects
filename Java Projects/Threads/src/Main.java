public class Main {
    public static void main(String[] args) {
      ListWorker worker = new ListWorker();
      long beginnig = System.currentTimeMillis();
      worker.runfunctions();
      long end = System.currentTimeMillis();
        System.out.println("Processing time -> " + (end- beginnig)/1000 + " seconds");

    }
}