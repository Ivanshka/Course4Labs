package znp.fit.bstu.pms_5;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import znp.fit.bstu.pms_5.model.Deed;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("BusyDay");
        if (savedInstanceState == null) {
            DeedListFragment fragment = new DeedListFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frag, fragment, null)
                    .commit();
        }
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
}