package andreasaderi.L1.entities;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@ToString
public class Pizza extends MenuItem {
    private String name;
    private List<Topping> ingredients;

    public Pizza(String name, List<Topping> toppings) {
        super(calculatePrice(toppings), calculateCalories(toppings));

        this.name = name;
        this.ingredients = new ArrayList<>(
                List.of(
                        new Topping("tomato", 0, 0),
                        new Topping("mozzarella", 0, 0)
                )
        );
        this.ingredients.addAll(toppings);
    }

    public static double calculatePrice(List<Topping> toppings) {
        return 4.99 + toppings.stream()
                .mapToDouble(MenuItem::getPrice)
                .sum();
    }

    public static int calculateCalories(List<Topping> toppings) {
        return 1104 + toppings.stream()
                .mapToInt(MenuItem::getCalories)
                .sum();
    }


    public String printPizza() {
        return "Pizza " + name +
                "(" + ingredients.stream().map(Topping::getName).collect(Collectors.joining(", ")) +
                ") calories:" + calories +
                ", price:" + price;
    }
}
