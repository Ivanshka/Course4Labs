package sva.fit.bstu.pms_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.File;

import sva.fit.bstu.pms_3.context.DiContext;

public class AllTaskActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_task);

        File jsonFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/" + File.separator + DiContext.PATH_TO_JSON);;
        if(jsonFile.exists()) {
            DiContext.getDiContext().setTaskHolder(DiContext
                    .getDiContext()
                    .getJsonUtil()
                    .deserializeTasks(DiContext.PATH_TO_JSON));
        } else {
            DiContext.getDiContext()
                    .getJsonUtil()
                    .serializeTasks(DiContext.getDiContext().getTaskHolder(),
                    DiContext.PATH_TO_JSON);
        }

        ListView tasksList = findViewById(R.id.tasksList);
        Button addNewTaskButton = findViewById(R.id.addNewTaskButton);

        ArrayAdapter<String> adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, DiContext.getDiContext().getTaskHolder().getTasks());

        tasksList.setAdapter(adapter);
        addNewTaskButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.addNewTaskButton:{
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            } break;
        }
    }
}