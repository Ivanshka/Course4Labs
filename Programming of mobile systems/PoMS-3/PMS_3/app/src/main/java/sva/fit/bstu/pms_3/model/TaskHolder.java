package sva.fit.bstu.pms_3.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class TaskHolder {
    private List<Task> tasks;

    public TaskHolder(){
        tasks = new ArrayList<>();
    }
}
