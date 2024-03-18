import java.io.*;

public class writeobject {
    public static void main(String[] args){
    try(ObjectOutputStream out= new ObjectOutputStream(new FileOutputStream("ogrenci.bin"))) {
     student stu1= new student( "yagmur");
     student stu2= new student("semih");
     out.writeObject(stu2);
     out.writeObject(stu1);

    } catch (FileNotFoundException e) {
        System.out.println("ndsmö");
    } catch (IOException e) {
        System.out.println("kmdlöş");
    } ;
    }
}
