package andreasaderi.L1.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class MenuItem {
    protected double price;
    protected int calories;
}
