package andreasaderi.L1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class Menu {
    private List<Pizza> pizzaList;
    private List<Topping> toppingList;
    private List<Drink> drinkList;

    public String printMenu() {
        return "MENU\n\nPizze:\n\n" +
                pizzaList.stream()
                        .map(Pizza::printPizza)
                        .collect(Collectors.joining("\n")) +
                "\n\nTopping:\n\n" +
                toppingList.stream()
                        .map(Topping::printTopping)
                        .collect(Collectors.joining("\n"))
                + "\n\nDrinks:\n\n" +
                drinkList.stream()
                        .map(Drink::toString)
                        .collect(Collectors.joining("\n"))
                ;
    }
}
