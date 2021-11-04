package znp.fit.bstu.pms2.util;

import znp.fit.bstu.pms2.model.Human;

public class InputValidator {
    public static String HUMAN_DATA_IS_VALID = "HUMAN_DATA_IS_VALID";

    public boolean isInteger(String string){
        try {
            Integer.parseInt(string);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public boolean isDouble(String string){
        try {
            Double.parseDouble(string);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public String checkHumanData(Human human){
        if(human.getSex() == null){
            return "sex wasn't set";
        }

        if(human.getHeight() == null){
            return "height wasn't set";
        }

        if(human.getWeight() == null){
            return "weight wasn't set";
        }

        if(human.getAge() == null){
            return "age wasn't set";
        }

        return HUMAN_DATA_IS_VALID;
    }
}
