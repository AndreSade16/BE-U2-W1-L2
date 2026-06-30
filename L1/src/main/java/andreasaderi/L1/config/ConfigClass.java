package andreasaderi.L1.config;

import andreasaderi.L1.entities.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ConfigClass {
    @Bean
    public Topping getCheese() {
        return new Topping("cheese", 120, 0.79);
    }

    @Bean
    public Topping getHam() {
        return new Topping("ham", 100, 0.99);

    }

    @Bean
    public Topping getOnions() {
        return new Topping("onions", 30, 0.29);
    }

    @Bean
    public Topping getPineapple() {
        return new Topping("pineapple", 80, 0.59);
    }

    @Bean
    public Topping getSalami() {
        return new Topping("salami", 210, 0.99);
    }

    @Bean
    public Pizza getMargherita() {
        return new Pizza("Margherita", List.of());
    }

    @Bean
    public Pizza getHawaiian() {
        return new Pizza("Hawaiian", List.of(getPineapple(), getHam()));
    }

    @Bean
    public Pizza getSalamiPizza() {
        return new Pizza("Salami", List.of(getSalami()));
    }

    @Bean
    public Drink getLemonade() {
        return new Drink("Lemonade", 128, 1.29, 0.33);
    }

    @Bean
    public Drink getWater() {
        return new Drink("Water", 0, 1.29, 0.5);
    }

    @Bean
    public Drink getWine() {
        return new Drink("Wine", 350, 7.59, 0.75);
    }

    @Bean
    public Menu getMenu() {
        return new Menu(List.of(getMargherita(), getHawaiian(), getSalamiPizza()), List.of(getCheese(), getPineapple(), getSalami(), getHam(), getOnions()), List.of(getWater(), getLemonade(), getWine()));
    }

    @Bean
    public Tavolo getTavolo1() {
        return new Tavolo(1, 4, false);
    }

    @Bean
    public Tavolo getTavolo2() {
        return new Tavolo(2, 6, true);
    }

    @Bean
    public Tavolo getTavolo3() {
        return new Tavolo(3, 2, true);
    }


}
