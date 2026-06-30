package andreasaderi.L1.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.PropertySource;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@PropertySource("application.properties")
public class Order {
    private Tavolo table;
    private List<MenuItem> items;
    @Setter
    private OrderState state;
    private int numOfCovers;
    private LocalDateTime time;
    private double total;

    public Order(Tavolo table, List<MenuItem> items, int numOfCovers, double coperto) {
        this.table = table;
        this.items = items;
        this.state = OrderState.IN_CORSO;
        this.numOfCovers = numOfCovers;
        this.time = LocalDateTime.now();
        this.total = calculateTotal();
    }

    public double calculateTotal() {
        return this.items.stream().mapToDouble(MenuItem::getPrice).sum();
    }

    @Override
    public String toString() {
        return "Order{" +
                "table=" + table +
                ", items=" + items +
                ", state=" + state +
                ", numOfCovers=" + numOfCovers +
                ", time=" + time +
                ", total=" + total +
                '}';
    }
}
