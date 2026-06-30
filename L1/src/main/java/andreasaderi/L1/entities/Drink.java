package andreasaderi.L1.entities;

import lombok.Data;


@Data
public class Drink extends MenuItem {
    private String name;
    private double capacity;

    public Drink(String name, int calories, double price, double capacity) {
        super(price, calories);
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return name + "(" + capacity + "l), " +
                "calories=" + calories +
                ", price=" + price;
    }
}
