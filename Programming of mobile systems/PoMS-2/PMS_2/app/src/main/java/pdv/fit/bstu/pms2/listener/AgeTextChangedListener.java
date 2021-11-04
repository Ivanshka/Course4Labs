package znp.fit.bstu.pms2.listener;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

import lombok.RequiredArgsConstructor;
import znp.fit.bstu.pms2.context.ContextHolder;
import znp.fit.bstu.pms2.model.Human;
import znp.fit.bstu.pms2.util.InputValidator;

@RequiredArgsConstructor
public class AgeTextChangedListener implements TextWatcher {

    private final InputValidator inputValidator;
    private final Human human;

    @Override
    public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int start, int count, int after) {
        if(!inputValidator.isInteger(charSequence.toString())){
            Log.w(getClass().toString(), charSequence + "is not a number");
            return;
        }

        int age = Integer.parseInt(charSequence.toString());
        human.setAge(age);

        Log.d(getClass().toString(), "age was set to " + age);
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
