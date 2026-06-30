package andreasaderi.L1.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Tavolo {
    private int number;
    private int maxCovers;
    @Setter
    private boolean isOccupied;

    @Override
    public String toString() {
        return "Tavolo{" +
                "number=" + number +
                ", maxCovers=" + maxCovers +
                ", isOccupied=" + isOccupied +
                '}';
    }
}
