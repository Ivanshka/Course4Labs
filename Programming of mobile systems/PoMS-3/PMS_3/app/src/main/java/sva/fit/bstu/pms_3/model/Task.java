package sva.fit.bstu.pms_3.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Task implements Serializable {
    public static final String NEW_TASK_KEY = "NEW_TASK_KEY";

    private String name;
    private String description;
    private int estimatedPoints;
    private int estimatedTime;
    private String owner;
    private boolean isImportant;
    private Date taskSchedule;

    public String toString(){
        return "Task " + name + " is meant "
                + description + " was estimated as "
                + estimatedPoints + "should be done in "
                + estimatedTime + " was written by "
                + owner + (isImportant? "(IMPORTANT!!!)":"(NOT IMPORTANT)")
                + " " + taskSchedule;
    }
}
