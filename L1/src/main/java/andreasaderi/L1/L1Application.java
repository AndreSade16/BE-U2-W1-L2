package andreasaderi.L1;

import andreasaderi.L1.entities.Menu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class L1Application {

    public static void main(String[] args) {
        SpringApplication.run(L1Application.class, args);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(L1Application.class);

        Menu menu = context.getBean(Menu.class);

        System.out.println(menu.printMenu());
    }

}
