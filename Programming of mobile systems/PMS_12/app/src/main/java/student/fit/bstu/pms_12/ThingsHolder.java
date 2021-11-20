package student.fit.bstu.pms_12;

import java.util.ArrayList;
import java.util.List;

public class ThingsHolder {
    private static ThingsHolder thingsHolder;

    private List<Thing> things = new ArrayList<>();

    public static ThingsHolder get(){
        if(thingsHolder == null){
            thingsHolder = new ThingsHolder();
        }

        return thingsHolder;
    }

    public List<Thing> getThings() {
        return things;
    }
}
