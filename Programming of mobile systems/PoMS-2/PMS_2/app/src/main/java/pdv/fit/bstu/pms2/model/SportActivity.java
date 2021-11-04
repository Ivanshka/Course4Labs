package znp.fit.bstu.pms2.model;

import java.util.Arrays;
import java.util.Collections;

import lombok.Getter;

@Getter
public enum SportActivity {
    NEVER(1.2, "Never"),
    RARELY(1.375, "1-2 times a week"),
    SOMETIMES(1.55, "3-5 times a week"),
    OFTEN(1.725, "6-7 times a week"),
    ALWAYS(1.9, "It is my profession");

    private double coefficient;
    private String description;

    SportActivity(double coefficient, String description){
        this.coefficient = coefficient;
        this.description = description;
    }

    public static String[] getAllActivitiesDescriptions(){
        return Arrays.stream(values()).map(SportActivity::getDescription).toArray(String[]::new);
    }

    public static SportActivity fromDescription(String description){
        return Arrays.stream(values())
                .filter(activity -> activity.description.equals(description))
                .findAny()
                .orElse(NEVER);
    }
}
