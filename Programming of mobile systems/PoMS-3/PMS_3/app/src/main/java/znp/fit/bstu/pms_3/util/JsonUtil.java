package znp.fit.bstu.pms_3.util;

import android.os.Debug;
import android.os.Environment;
import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;

import lombok.SneakyThrows;
import znp.fit.bstu.pms_3.model.TaskHolder;

public class JsonUtil {
    @SneakyThrows
    public void serializeTasks(TaskHolder taskHolder, String fileName){
        File jsonFile = new File(Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                + "/" + File.separator + fileName);


        Log.d(this.getClass().toString(), "written " + taskHolder.toString());

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(jsonFile, taskHolder);
    }
    @SneakyThrows
    public TaskHolder deserializeTasks(String fileName){
        File jsonFile = new File(Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                + "/" + File.separator + fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        TaskHolder taskHolder = objectMapper.readValue(jsonFile, TaskHolder.class);

        Log.d(this.getClass().toString(), "read " + taskHolder.toString());

        return taskHolder;
    }
}
