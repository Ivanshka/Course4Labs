package sva.fit.bstu.pms_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import sva.fit.bstu.pms_3.context.DiContext;
import sva.fit.bstu.pms_3.model.Task;

public class TaskSummaryActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView taskNameSummaryTextView;
    private TextView taskDescriptionSummaryTextView;
    private TextView taskEstimatedPointsSummaryTextView;
    private TextView taskEstimatedTimeSummaryTextView;
    private TextView taskOwnerSummaryTextView;

    private Button toTaskInfoBackButton;
    private Button addTaskButton;
    private Task task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_summary);

        taskNameSummaryTextView = findViewById(R.id.taskNameSummary);
        taskDescriptionSummaryTextView = findViewById(R.id.taskDescriptionSummary);
        taskEstimatedPointsSummaryTextView = findViewById(R.id.taskEstimatedPointsSummary);
        taskEstimatedTimeSummaryTextView = findViewById(R.id.taskEstimatedTimeSummary);
        taskOwnerSummaryTextView = findViewById(R.id.taskOwnerSummary);

        toTaskInfoBackButton = findViewById(R.id.toTaskInfoBackButton);
        addTaskButton = findViewById(R.id.addTaskButton);

        Bundle arguments = getIntent().getExtras();

        if(arguments!=null){
            task = (Task) arguments.getSerializable(Task.NEW_TASK_KEY);
            taskNameSummaryTextView.setText(task.getName());
            taskDescriptionSummaryTextView.setText(task.getDescription());
            taskEstimatedPointsSummaryTextView.setText(String.valueOf(task.getEstimatedPoints()));
            taskEstimatedTimeSummaryTextView.setText(String.valueOf(task.getEstimatedTime()));
            taskOwnerSummaryTextView.setText(task.getOwner());
        }

        toTaskInfoBackButton.setOnClickListener(this);
        addTaskButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.toTaskInfoBackButton:{
                Intent intent = new Intent(this, TaskInfoActivity.class);
                intent.putExtra(Task.NEW_TASK_KEY, task);
                startActivity(intent);
            } break;
            case R.id.addTaskButton:{
                Intent intent = new Intent(this, AllTaskActivity.class);
                DiContext.getDiContext().getTaskHolder().getTasks().add(task);
                DiContext.getDiContext().getJsonUtil()
                        .serializeTasks(DiContext.getDiContext().getTaskHolder(), DiContext.PATH_TO_JSON);
                task = null;
                startActivity(intent);
            } break;
        }
    }
}