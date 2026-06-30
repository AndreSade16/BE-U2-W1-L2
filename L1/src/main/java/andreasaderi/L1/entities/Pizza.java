package andreasaderi.L1.entities;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class Pizza {
    private String name;
    private List<Topping> ingredients;
    private int calories;
    private double price;

    public Pizza(String name, List<Topping> toppings) {
        this.name = name;
        this.ingredients = new ArrayList<>(List.of(new Topping("tomato", 0, 0), new Topping("mozzarella", 0, 0)));
        this.ingredients.addAll(toppings);
        this.price = 4.99 + this.ingredients.stream().mapToDouble(Topping::getPrice).sum();
        this.calories = 1104 + this.ingredients.stream().mapToInt(Topping::getCalories).sum();
    }


    public String printPizza() {
        return "Pizza " + name +
                "(" + ingredients.stream().map(Topping::getName).collect(Collectors.joining(", ")) +
                ") calories:" + calories +
                ", price:" + price;
    }
}
