package src;

import java.util.*;

public class Vechicle {
    public HashMap<String, String> getVechicleDetails() {
        return vechicleDetails;
    }

    public void setVechicleDetails(HashMap<String, String> vechicleDetails) {
        this.vechicleDetails = vechicleDetails;
    }

    private HashMap<String, String> vechicleDetails = new HashMap<String, String>();
}
