package znp.fit.bstu.pms2.listener;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import lombok.RequiredArgsConstructor;
import znp.fit.bstu.pms2.model.Human;
import znp.fit.bstu.pms2.model.SportActivity;

@RequiredArgsConstructor
public class SportActivitySelectedListener implements AdapterView.OnItemSelectedListener {

    private final Human human;

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        SportActivity sportActivity = SportActivity
                .fromDescription(adapterView.getSelectedItem().toString());

        human.setSportActivity(sportActivity);

        Log.d(getClass().toString(), "sport activity was set to "
                + sportActivity.getDescription());
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
