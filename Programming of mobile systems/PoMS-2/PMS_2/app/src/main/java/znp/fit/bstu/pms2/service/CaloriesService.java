package znp.fit.bstu.pms2.service;

import znp.fit.bstu.pms2.model.Human;
import znp.fit.bstu.pms2.model.Sex;

public class CaloriesService {

    public double calculate(Human human){
        return (human.getSex().getBmrConstant()
                + (human.getSex().getWeightConstant() * human.getWeight())
                + (human.getSex().getHeightConstant() * human.getHeight())
                - (human.getSex().getAgeConstant() * human.getAge()))
                * human.getSportActivity().getCoefficient();
    }
}
