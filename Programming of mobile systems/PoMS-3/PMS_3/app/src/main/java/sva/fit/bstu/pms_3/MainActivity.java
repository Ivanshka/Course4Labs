package sva.fit.bstu.pms_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

import sva.fit.bstu.pms_3.model.Task;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, DatePicker.OnDateChangedListener {

    private EditText taskNameEditView;
    private EditText taskDescriptionEditView;
    private Button toTaskInfoNextButton;
    private CheckBox taskIsImportantCheckBox;
    private DatePicker taskSchedule;
    private Task task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskNameEditView = findViewById(R.id.taskName);
        taskDescriptionEditView = findViewById(R.id.taskDescription);
        toTaskInfoNextButton = findViewById(R.id.toTaskInfoNextButton);
        taskIsImportantCheckBox = findViewById(R.id.taskIsImportant);
        taskSchedule = findViewById(R.id.taskSchedule);

        Bundle arguments = getIntent().getExtras();

        if(arguments!=null){
            task = (Task) arguments.getSerializable(Task.NEW_TASK_KEY);
            taskNameEditView.setText(task.getName());
            taskDescriptionEditView.setText(task.getDescription());
        } else {
            task = new Task();
        }

        toTaskInfoNextButton.setOnClickListener(this);
        taskIsImportantCheckBox.setOnClickListener(this);
        taskSchedule.setOnDateChangedListener(this);

        taskNameEditView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                task.setName(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        taskDescriptionEditView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                task.setDescription(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.toTaskInfoNextButton:{
                Intent intent = new Intent(this, TaskInfoActivity.class);
                intent.putExtra(Task.NEW_TASK_KEY, task);
                startActivity(intent);
            } break;
            case R.id.taskIsImportant:{
                task.setImportant(taskIsImportantCheckBox.isChecked());
            }break;
        }
    }

    @Override
    public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
        int day = taskSchedule.getDayOfMonth();
        int month = taskSchedule.getMonth() + 1;
        int year = taskSchedule.getYear();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MM-dd-yyyy");
        Date date = new Date(year, month, day);
        task.setTaskSchedule(date);
    }
}