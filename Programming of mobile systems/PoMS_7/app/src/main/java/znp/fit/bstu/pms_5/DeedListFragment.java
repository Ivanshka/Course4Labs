package znp.fit.bstu.pms_5;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import znp.fit.bstu.pms_5.context.DiContext;
import znp.fit.bstu.pms_5.model.Deed;

public class DeedListFragment extends Fragment implements View.OnClickListener {

    private final static int DELETE_BUTTON = 9991;
    private final static int CHANGE_BUTTON = 9992;
    private final static int REVIEW_BUTTON = 9993;
    private final static int UP_BUTTON = 9994;

    private ListView doneTodayListView;
//    private com.google.android.material.card.MaterialCardView doneTodayListView;
    private Button addDeedButton;
    public static Deed currentDeed;

    public DeedListFragment() {
        super(R.layout.fragment_deed_list);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if(DiContext.getDiContext().getSqlDatabase() == null){
            DiContext.getDiContext().addSqlDatabase(getActivity().getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null));
        }

        doneTodayListView = view.findViewById(R.id.doneTodayListView);
        addDeedButton = view.findViewById(R.id.addDeedButton);
        updateView();

        addDeedButton.setOnClickListener(this);

        doneTodayListView.setOnItemClickListener((parent, view2, position, id) -> {
            Deed deed = (Deed)parent.getItemAtPosition(position);
            Log.i("DEED", "a deed was clicked " + deed.getId());
            Intent intent = new Intent(getActivity(), CameraActivity.class);
            intent.putExtra(Deed.ADD_DEED_KEY, deed);
            startActivity(intent);
        });

    }

    @Override
    public void onResume() {
        super.onResume();

        registerForContextMenu(doneTodayListView);
        updateView();
    }

    public void updateView(){

        List<Deed> deedList = DiContext.getDiContext().getAllDeeds();
        Log.i("DB INIT", "onCreate: " + deedList);
        DiContext.getDiContext().getDeedsHolder().setDeeds(deedList);

        ListAdapter customAdapter = new ListAdapter(getActivity(), R.layout.list_layout, DiContext.getDiContext().getDeedsHolder().getDeeds());
        doneTodayListView.setAdapter(customAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addDeedButton: {
                Intent intent = new Intent(getActivity(), CameraActivity.class);
                intent.putExtra(Deed.ADD_DEED_KEY, new Deed());
                startActivity(intent);
            }
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        CharSequence message;
        switch (item.getItemId())
        {
            case DELETE_BUTTON:
                showDeleteDialog(currentDeed);
                updateView();
                break;
            case REVIEW_BUTTON:
                int orientation = getResources().getConfiguration().orientation;
                if (orientation == Configuration.ORIENTATION_PORTRAIT) {
                    Fragment descriptionFragment = new DescriptionFragment(currentDeed);
                    FragmentTransaction trans = getFragmentManager().beginTransaction();
                    trans.replace(R.id.frag, descriptionFragment);
                    trans.addToBackStack(null);
                    trans.commit();
                } else {
                    Fragment descriptionFragment = new DescriptionFragment(currentDeed);
                    FragmentTransaction trans = getFragmentManager().beginTransaction();
                    trans.replace(R.id.descriptionFragment, descriptionFragment);
                    trans.addToBackStack(null);
                    trans.commit();
                }
                break;
            case CHANGE_BUTTON:
                Intent intent = new Intent(getActivity(), CameraActivity.class);
                intent.putExtra(Deed.ADD_DEED_KEY, currentDeed);
                startActivity(intent);
                break;
            case UP_BUTTON:
                doneTodayListView.smoothScrollToPosition(0);
                break;
        }

        return true;
    }

        public void showDeleteDialog(Deed deed) {

        CustomDialogFragment dialog = new CustomDialogFragment(deed);
        dialog.show(getActivity().getSupportFragmentManager(), "tag");
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        if (v.getId() == R.id.doneTodayListView) {
            ListView lv = (ListView) v;
            AdapterView.AdapterContextMenuInfo acmi = (AdapterView.AdapterContextMenuInfo) menuInfo;
            Deed obj = (Deed) lv.getItemAtPosition(acmi.position);
            currentDeed = obj;

            menu.add(Menu.NONE, DELETE_BUTTON, Menu.NONE, "Delete");
            menu.add(Menu.NONE, CHANGE_BUTTON, Menu.NONE, "Change");
            menu.add(Menu.NONE, REVIEW_BUTTON, Menu.NONE, "Review");
            menu.add(Menu.NONE, UP_BUTTON, Menu.NONE, "Up");
//        }
    }
}