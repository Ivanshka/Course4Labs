package znp.fit.bstu.pms2.listener;

import android.util.Log;
import android.widget.RadioGroup;

import lombok.RequiredArgsConstructor;
import znp.fit.bstu.pms2.R;
import znp.fit.bstu.pms2.context.ContextHolder;
import znp.fit.bstu.pms2.model.Human;
import znp.fit.bstu.pms2.model.Sex;

@RequiredArgsConstructor
public class SexRadioGroupListener implements RadioGroup.OnCheckedChangeListener {

    private final Human human;

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int radioButtonId) {
        Log.d(getClass().toString(), radioButtonId + " radiobutton was set");
        switch (radioButtonId) {
            case R.id.manRadioGroup: human.setSex(Sex.MAN); break;
            case R.id.womanRadioGroup: human.setSex(Sex.WOMAN); break;
        }

    }
}
