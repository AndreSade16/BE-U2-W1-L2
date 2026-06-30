package andreasaderi.L1.runners;

import andreasaderi.L1.entities.Menu;
import andreasaderi.L1.entities.MenuItem;
import andreasaderi.L1.entities.Order;
import andreasaderi.L1.entities.Tavolo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Runner.class);
    private final ApplicationContext context;
    private final double coperto;
    private Menu menu;

    @Autowired
    public Runner(@Value("${coperto.price}") double coperto, Menu menu, ApplicationContext context) {
        this.coperto = coperto;
        this.menu = menu;
        this.context = context;
    }

    @Override
    public void run(String... args) {
        System.out.println(menu.printMenu());

        Order order1 = new Order(context.getBean("getTavolo1", Tavolo.class), List.of(context.getBean("getHawaiian", MenuItem.class), context.getBean("getLemonade", MenuItem.class), context.getBean("getWater", MenuItem.class)), 3, coperto);

        logger.info("Order: {}", order1);
    }
}
