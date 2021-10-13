package znp.fit.bstu.pms_5;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;
import java.util.function.Consumer;

import znp.fit.bstu.pms_5.context.DiContext;
import znp.fit.bstu.pms_5.model.Deed;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final static int DELETE_BUTTON = 9991;
    private final static int CHANGE_BUTTON = 9992;
    private final static int REVIEW_BUTTON = 9993;

    private ListView doneTodayListView;
    private Button addDeedButton;
    private Deed currentDeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("BusyDay");

        if(DiContext.getDiContext().getSqlDatabase() == null){
            DiContext.getDiContext().addSqlDatabase(getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null));
        }

        doneTodayListView = findViewById(R.id.doneTodayListView);
        addDeedButton = findViewById(R.id.addDeedButton);
        updateView();

        addDeedButton.setOnClickListener(this);

        doneTodayListView.setOnItemClickListener((parent, view, position, id) -> {
            Deed deed = (Deed)parent.getItemAtPosition(position);
            Log.i("DEED", "a deed was clicked " + deed.getId());
            Intent intent = new Intent(this, CameraActivity.class);
            intent.putExtra(Deed.ADD_DEED_KEY, deed);
            startActivity(intent);
        });

        registerForContextMenu(doneTodayListView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.create_settings :
                Intent intent = new Intent(this, CameraActivity.class);
                intent.putExtra(Deed.ADD_DEED_KEY, new Deed());
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.addDeedButton: {
                Intent intent = new Intent(this, CameraActivity.class);
                intent.putExtra(Deed.ADD_DEED_KEY, new Deed());
                startActivity(intent);
            }
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (v.getId() == R.id.doneTodayListView) {
            ListView lv = (ListView) v;
            AdapterView.AdapterContextMenuInfo acmi = (AdapterView.AdapterContextMenuInfo) menuInfo;
            Deed obj = (Deed) lv.getItemAtPosition(acmi.position);
            currentDeed = obj;

            menu.add(Menu.NONE, DELETE_BUTTON, Menu.NONE, "Delete");
            menu.add(Menu.NONE, CHANGE_BUTTON, Menu.NONE, "Change");
            menu.add(Menu.NONE, REVIEW_BUTTON, Menu.NONE, "Review");
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
            case CHANGE_BUTTON:
                Intent intent = new Intent(this, CameraActivity.class);
                intent.putExtra(Deed.ADD_DEED_KEY, currentDeed);
                startActivity(intent);
                break;
        }

        return true;
    }

    public void updateView(){

        List<Deed> deedList = DiContext.getDiContext().getAllDeeds();
        Log.i("DB INIT", "onCreate: " + deedList);
        DiContext.getDiContext().getDeedsHolder().setDeeds(deedList);

        ListAdapter customAdapter = new ListAdapter(this, R.layout.list_layout, DiContext.getDiContext().getDeedsHolder().getDeeds());
        doneTodayListView.setAdapter(customAdapter);
    }

    public void showDeleteDialog(Deed deed) {

        CustomDialogFragment dialog = new CustomDialogFragment(deed);
        dialog.show(getSupportFragmentManager(), "tag");
    }

}