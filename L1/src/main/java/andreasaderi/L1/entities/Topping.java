package andreasaderi.L1.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public class Topping {
    private String name;
    private int calories;
    private double price;


    public String printTopping() {
        return Character.toUpperCase(name.charAt(0)) + name.substring(1) +
                ", calories=" + calories +
                ", price=" + price;
    }
}
