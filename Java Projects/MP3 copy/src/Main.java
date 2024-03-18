import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Integer> content = new ArrayList<>();
    public static void ReadFile(){
        try {
            FileInputStream in= new FileInputStream("Dillon - Thirteen Thirtyfive.mp3");
            int read;
            while(( read = in.read()) !=-1){
                content.add(read);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File Not Fount exception occurred");
        } catch (IOException e) {
            System.out.println("The exception occured while reading file");
        }

    }
    public static void copyFile(String FileName){
        try {
            FileOutputStream out= new FileOutputStream(FileName);
            for( int value : content){
                out.write(value);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Fount exception occurred");
        } catch (IOException e) {
            System.out.println("The exception occurred while writing file");
        }

    }
    public static void main(String[] args) {
       ReadFile();
       long begin= System.currentTimeMillis();
       copyFile("Dillon - Thirteen Thirtyfive2.mp3");
      copyFile("Dillon - Thirteen Thirtyfive3.mp3");
      copyFile("Dillon - Thirteen Thirtyfive4.mp3");
      long end = System.currentTimeMillis();
        System.out.println("The file copy took " + (end-begin) / 1000 + " seconds");
    }
}