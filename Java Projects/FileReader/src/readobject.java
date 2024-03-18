import java.io.*;

public class readobject {
    public static  void main(String[] args){
        try(ObjectInputStream in= new ObjectInputStream(new FileInputStream("ogrenci.bin"))){
            student stu1 =(student)in.readObject();
            student stu2 =(student) in.readObject();
            System.out.println("***************************************");
            System.out.println(stu1);
            System.out.println("***************************************");
            System.out.println(stu2);
        } catch (FileNotFoundException e) {
            System.out.println("lksfmldöş");
        } catch (IOException e) {
            System.out.println("mfldöşçis");
        } catch (ClassNotFoundException e) {
            System.out.println("class not found");
        }
    }
}
