import java.io.Serial;
import java.io.Serializable;

public class student implements Serializable {
    private String isim;

    public student(String isim){
        this.isim=isim;
    }
    public String toString(){
        return "ogrenci ismi " + isim;
    }
}
