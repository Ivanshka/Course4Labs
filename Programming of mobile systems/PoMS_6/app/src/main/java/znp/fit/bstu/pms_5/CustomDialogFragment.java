package znp.fit.bstu.pms_5;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

import znp.fit.bstu.pms_5.context.DiContext;
import znp.fit.bstu.pms_5.model.Deed;

public class CustomDialogFragment extends DialogFragment {

    private Deed deed;

    public CustomDialogFragment(Deed deed) {
        this.deed = deed;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {

        android.app.AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        return builder
                .setTitle("Dialog box")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setMessage("Are you sure")
                .setPositiveButton("Yes", (dialog, which) -> {DiContext.getDiContext().deleteDeed(deed);
                    ((DeedListFragment)getActivity().getSupportFragmentManager()
                            .findFragmentById(R.id.frag)).updateView();
                })
                .setNegativeButton("No", null)
                .create();
    }
}
