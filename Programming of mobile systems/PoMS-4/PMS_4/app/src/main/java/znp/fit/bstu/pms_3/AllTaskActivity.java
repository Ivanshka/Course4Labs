package znp.fit.bstu.pms_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.File;

import znp.fit.bstu.pms_3.context.DiContext;
import znp.fit.bstu.pms_3.model.Task;
import znp.fit.bstu.pms_3.model.TaskHolder;

public class AllTaskActivity extends AppCompatActivity implements View.OnClickListener,
        AdapterView.OnItemClickListener {

    private Button cameraButton;
    private Button socialButton;
    private Button mailButton;
    private Button phoneButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_task);

        cameraButton = findViewById(R.id.cameraButton);
        socialButton = findViewById(R.id.socialButton);
        mailButton = findViewById(R.id.mailButton);
        phoneButton = findViewById(R.id.phoneButton);

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
        tasksList.setOnItemClickListener(this);
        addNewTaskButton.setOnClickListener(this);

        cameraButton.setOnClickListener(this);
        socialButton.setOnClickListener(this);
        mailButton.setOnClickListener(this);
        phoneButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.addNewTaskButton:{
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            } break;
            case R.id.cameraButton:{
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(intent);
            } break;
            case R.id.mailButton:{
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[] {});
                intent.putExtra(android.content.Intent.EXTRA_SUBJECT,"");
                intent.putExtra(android.content.Intent.EXTRA_TEXT, "");
                startActivity(Intent.createChooser(intent,"Send"));
            } break;
            case R.id.socialButton:{
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://telegram.me/nikita_idcau"));
                startActivity(browserIntent);
            } break;
            case R.id.phoneButton:{
                String toDial="tel:375291367702";
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(toDial)));
            }break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view,
                            int position, long id) {
        Intent intent = new Intent(this, TaskExtendDescriptionActivity.class);
        Task selectedTask = (Task) parent.getItemAtPosition(position);
        intent.putExtra(Task.CURRENT_TASK_KEY, selectedTask);
        startActivity(intent);
    }
}