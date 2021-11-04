package znp.fit.bstu.pms2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import znp.fit.bstu.pms2.context.ContextHolder;
import znp.fit.bstu.pms2.listener.AgeTextChangedListener;
import znp.fit.bstu.pms2.listener.HeightTextChangedListener;
import znp.fit.bstu.pms2.listener.SexRadioGroupListener;
import znp.fit.bstu.pms2.listener.SportActivitySelectedListener;
import znp.fit.bstu.pms2.listener.WeightTextChangedListener;
import znp.fit.bstu.pms2.model.Human;
import znp.fit.bstu.pms2.model.SportActivity;
import znp.fit.bstu.pms2.service.CaloriesService;
import znp.fit.bstu.pms2.util.InputValidator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final ContextHolder contextHolder = ContextHolder.getContext();

    private EditText ageEditText;
    private TextView caloriesField;
    private Button calculateButton;
    private RadioGroup sexRadioGroup;
    private EditText heightEditText;
    private EditText weightEditText;

    private final SportActivitySelectedListener sportActivitySelectedListener = contextHolder.getSportActivitySelectedListener();
    private final HeightTextChangedListener heightTextChangedListener = contextHolder.getHeightTextChangedListener();
    private final WeightTextChangedListener weightTextChangedListener = contextHolder.getWeightTextChangedListener();
    private final AgeTextChangedListener ageTextChangedListener = contextHolder.getAgeTextChangedListener();
    private final SexRadioGroupListener sexRadioGroupListener = contextHolder.getSexRadioGroupListener();

    private final CaloriesService caloriesService = contextHolder.getCaloriesService();
    private final InputValidator inputValidator = contextHolder.getInputValidator();

    private final Human human = contextHolder.getHuman();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ageEditText = (EditText) findViewById(R.id.ageEditText);
        caloriesField = (TextView) findViewById(R.id.caloriesShouldBeEatenTextView);
        calculateButton = (Button) findViewById(R.id.calculateCaloriesButton);
        sexRadioGroup = (RadioGroup) findViewById(R.id.sexRadioGroup);
        heightEditText = (EditText) findViewById(R.id.heightEditText);
        weightEditText = (EditText) findViewById(R.id.weightEditText);

        Spinner spinner = (Spinner) findViewById(R.id.planets_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                SportActivity.getAllActivitiesDescriptions());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(sportActivitySelectedListener);

        sexRadioGroup.setOnCheckedChangeListener(sexRadioGroupListener);
        heightEditText.addTextChangedListener(heightTextChangedListener);
        weightEditText.addTextChangedListener(weightTextChangedListener);
        ageEditText.addTextChangedListener(ageTextChangedListener);

        calculateButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.calculateCaloriesButton: {
                String validationReport = inputValidator.checkHumanData(human);
                if (validationReport.equals(InputValidator.HUMAN_DATA_IS_VALID)) {
                    double calories = caloriesService.calculate(human);
                    caloriesField.setText(Double.toString(calories));
                    return;
                }
                Snackbar.make(view, validationReport, Snackbar.LENGTH_LONG)
                        .show();

            } break;
        }
    }
}