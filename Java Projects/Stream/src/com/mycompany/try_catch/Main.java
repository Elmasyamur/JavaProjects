
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {

    public static void main(String[] args) {
        FileOutputStream fos= null;
        //  File file = new File("text.txt");
        try {
            fos = new FileOutputStream("text.txt",true);
             byte[] array= { 121,97,103,109 ,117 ,114 ,101 ,108 ,109 ,97 ,115};
             fos.write(array);
             String space = " ";
             fos.write(space.getBytes());
             String s = "Yağmur Elmas";
             byte[] s_array=s.getBytes();
             fos.write(s_array);
        }
        catch (FileNotFoundException e){
            System.out.println("File Not Found Exception occurred");
        }
        // we must close the file 
        catch (IOException e) {
            System.out.println("An exception occurred while writing on text");
        } finally{
            try {
                fos.close();
            } catch (IOException ex) {
                System.out.println("An exception occurred while closing on text");
            }
        }
    }
}

