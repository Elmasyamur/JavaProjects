package FileInputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("inputtext.txt");
            System.out.println( "First char is "+(char)fis.read()); // We have to convert it to character because computer is reading it as byte.
            System.out.println("Second char is " + (char)fis.read());
            System.out.println("Third char is " + (char)fis.read());
            // if we want to read a char which we want to read
            fis.skip(5);
            System.out.println("The char is " + (char)fis.read());
            // if we want to read all words on text we should use loop
            int value;
            String s= "";
            while((value= fis.read()) != -1){
                s+= (char) value;
            }
            System.out.println(s);
        } catch(FileNotFoundException e){
            System.out.println("File Not Found Exception occurred");

        } catch (IOException e) {
            System.out.println("The exception occurred while reading file");
        } finally{
            try{
                if(fis!=null) { // because if the programme cannot find the file it should not close it
                    fis.close();
                }
            }catch(IOException ex){
                System.out.println("The exception occured while closing file");
            }
        }
    }
}

