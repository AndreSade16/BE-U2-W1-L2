package andreasaderi.L1.entities;

import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
public class Topping extends MenuItem {
    private String name;

    public Topping(String name, int calories, double price) {
        super(price, calories);
        this.name = name;
    }


    public String printTopping() {
        return Character.toUpperCase(name.charAt(0)) + name.substring(1) +
                ", calories=" + calories +
                ", price=" + price;
    }
}
