package znp.fit.bstu.pms2.model;

import lombok.Getter;

@Getter
public enum Sex {
    MAN(66.4730, 13.7516, 5.0033, 6.7550),
    WOMAN(655.0955, 9.5634, 1.8496, 4.6756);

    private final double bmrConstant;
    private final double weightConstant;
    private final double heightConstant;
    private final double ageConstant;

    Sex(double bmrConstant, double weightConstant, double heightConstant, double ageConstant){
        this.bmrConstant = bmrConstant;
        this.weightConstant = weightConstant;
        this.heightConstant = heightConstant;
        this.ageConstant = ageConstant;
    }
}
