package sva.fit.bstu.pms_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import sva.fit.bstu.pms_3.model.Task;

public class TaskInfoActivity extends AppCompatActivity implements View.OnClickListener {

    private Spinner taskEstimatedPointsEditView;
    private EditText taskEstimatedTimeEditView;
    private EditText taskOwnerEditView;
    private Button toMainTaskBackButton;
    private Button toTaskSummaryNextButton;
    private Task task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_info);

        taskEstimatedPointsEditView = findViewById(R.id.taskEstimatedPoints);
        taskEstimatedTimeEditView = findViewById(R.id.taskEstimatedTime);
        taskOwnerEditView = findViewById(R.id.taskOwner);

        toMainTaskBackButton = findViewById(R.id.toMainTaskBackButton);
        toTaskSummaryNextButton = findViewById(R.id.toTaskSummaryNextButton);

        Bundle arguments = getIntent().getExtras();

        if(arguments!=null){
            task = (Task) arguments.getSerializable(Task.NEW_TASK_KEY);
//            taskEstimatedPointsEditView.set(String.valueOf(task.getEstimatedPoints()));
            taskEstimatedTimeEditView.setText(String.valueOf(task.getEstimatedTime()));
            taskOwnerEditView.setText(task.getOwner());
        } else {
            task = new Task();
        }

        taskEstimatedPointsEditView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                task.setEstimatedPoints(Integer.parseInt(adapterView.getSelectedItem().toString()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        taskEstimatedTimeEditView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length() != 0 && TextUtils.isDigitsOnly(charSequence)) {
                    task.setEstimatedTime(Integer.parseInt(charSequence.toString()));
                } else {
                    task.setEstimatedTime(0);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        taskOwnerEditView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                task.setOwner(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        toMainTaskBackButton.setOnClickListener(this);
        toTaskSummaryNextButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.toMainTaskBackButton:{
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra(Task.NEW_TASK_KEY, task);
                startActivity(intent);
            } break;
            case R.id.toTaskSummaryNextButton:{
                Intent intent = new Intent(this, TaskSummaryActivity.class);
                intent.putExtra(Task.NEW_TASK_KEY, task);
                startActivity(intent);
            } break;
        }
    }
}