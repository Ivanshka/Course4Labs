package znp.fit.bstu.pms2.model;

import lombok.Data;

@Data
public class Human {
    private Sex sex;
    private Double weight;
    private Integer height;
    private Integer age;
    private SportActivity sportActivity;
}
