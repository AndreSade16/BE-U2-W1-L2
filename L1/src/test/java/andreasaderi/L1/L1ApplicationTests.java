package andreasaderi.L1;

import andreasaderi.L1.entities.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
class L1ApplicationTests {

    @Autowired
    private Menu menu;

    @Autowired
    @Qualifier("getHawaiian")
    private Pizza hawaiian;

    @Value("${coperto.price}")
    private double coperto;


    @Test
    void calculatePriceTest() {
        double result = Pizza.calculatePrice(List.of(
                new Topping("prosciutto", 128, 0.89),
                new Topping("wurstel", 228, 0.99),
                new Topping("fries", 315, 0.59)
        ));
        assertEquals(4.99 + 0.89 + 0.99 + 0.59, result);
    }

    @Test
    void calculateCaloriesTest() {
        double result = Pizza.calculateCalories(List.of(
                new Topping("prosciutto", 128, 0.89),
                new Topping("wurstel", 228, 0.99),
                new Topping("fries", 315, 0.59)
        ));
        assertEquals(1104 + 128 + 228 + 315, result);
    }

    @Test
    void checkOrdersCalculateTotal() {
        Order order = new Order(new Tavolo(1, 3, true), List.of(
                new Topping("prosciutto", 128, 0.89),
                new Topping("wurstel", 228, 0.99),
                new Topping("fries", 315, 0.59), new Drink("Birra", 200, 3.99, 0.33)
        ), 3, 1.5);

        double result = order.calculateTotal();
        assertEquals(4.5 + 0.89 + 0.99 + 0.59 + 3.99, result);
    }

    @Test
    void contextLoads() {
        assertNotNull(hawaiian);
        assertNotNull(menu);
        assertEquals(1.5, coperto);
    }

    @ParameterizedTest
    @CsvSource({"0, 4.99", "1.00, 5.99", "2.50, 7.49"})
    void calculatePriceTest(double toppingsPrice, double expected) {

        List<Topping> toppings = List.of(
                new Topping("Test", 0, toppingsPrice)
        );

        assertEquals(expected, Pizza.calculatePrice(toppings));
    }


}
