package znp.fit.bstu.pms_3.context;

import lombok.Getter;
import lombok.Setter;
import znp.fit.bstu.pms_3.model.TaskHolder;
import znp.fit.bstu.pms_3.util.JsonUtil;

@Getter
@Setter
public class DiContext {
    public static final String PATH_TO_JSON = "tasks.json";

    private static DiContext diContext;

    public static DiContext getDiContext(){
        if(diContext == null){
            synchronized (DiContext.class){
                if (diContext == null){
                    diContext = new DiContext();
                }
            }
        }

        return diContext;
    }

    private TaskHolder taskHolder;
    private JsonUtil jsonUtil;

    private DiContext(){
        taskHolder = new TaskHolder();
        jsonUtil = new JsonUtil();
    }
}
