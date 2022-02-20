package netology.domain;
import java.util.Objects;
public class Smartphone extends Product {
    private String make;

    public Smartphone() {
        super();
    }

    public Smartphone(int id, String name, int price, String make) {
        super(id, name, price);
        this.make = make;
    }



    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }
}
