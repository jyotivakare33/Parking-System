package src;

import java.util.ArrayList;
import java.util.List;

public class ParkedVechicle {
    public List<Vechicle> getParkedVechicle() {
        return parkedVechicle;
    }

    public void setParkedVechicle(List<Vechicle> parkedVechicle) {
        this.parkedVechicle = parkedVechicle;
    }

    private List<Vechicle> parkedVechicle = new ArrayList<Vechicle>();
}
