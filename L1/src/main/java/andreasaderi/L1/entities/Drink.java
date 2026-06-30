package andreasaderi.L1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Drink {
    private String name;
    private int calories;
    private double price;
    private double capacity;

    @Override
    public String toString() {
        return name + "(" + capacity + "l), " +
                "calories=" + calories +
                ", price=" + price;
    }
}
