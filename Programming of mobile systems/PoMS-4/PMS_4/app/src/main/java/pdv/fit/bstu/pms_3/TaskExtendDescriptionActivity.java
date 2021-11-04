package znp.fit.bstu.pms_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import znp.fit.bstu.pms_3.model.Task;

public class TaskExtendDescriptionActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView taskNameTextView;
    private TextView taskDescriptionTextView;
    private TextView taskSummary;
    private Button backButton;

    private Task task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_extend_description);

        taskNameTextView = findViewById(R.id.taskNameExtendedDescription);
        taskDescriptionTextView = findViewById(R.id.taskDescriptionExtendedDescription);
        taskSummary = findViewById(R.id.taskSummary);
        backButton = findViewById(R.id.backToAllTasksButton);

        backButton.setOnClickListener(this);

        Bundle arguments = getIntent().getExtras();

        if(arguments!=null){
            task = (Task) arguments.getSerializable(Task.CURRENT_TASK_KEY);
            taskNameTextView.setText(task.getName());
            taskDescriptionTextView.setText(task.getDescription());
            taskSummary.setText(task.toExtendedString());
        } else {
            task = new Task();
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.backToAllTasksButton:
                Intent intent = new Intent(this, AllTaskActivity.class);
                startActivity(intent);
        }
    }
}