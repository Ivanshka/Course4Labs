package znp.fit.bstu.pms2.listener;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

import lombok.RequiredArgsConstructor;
import znp.fit.bstu.pms2.context.ContextHolder;
import znp.fit.bstu.pms2.model.Human;
import znp.fit.bstu.pms2.util.InputValidator;

@RequiredArgsConstructor
public class WeightTextChangedListener implements TextWatcher {

    private final InputValidator inputValidator;
    private final Human human;

    @Override
    public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int start, int count, int after) {
        if(!inputValidator.isDouble(charSequence.toString())){
            Log.w(getClass().toString(), charSequence + "is not a number");
            return;
        }
        double weight = Double.parseDouble(charSequence.toString());
        human.setWeight(weight);

        Log.d(getClass().toString(), "weight was set to " + weight);
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
