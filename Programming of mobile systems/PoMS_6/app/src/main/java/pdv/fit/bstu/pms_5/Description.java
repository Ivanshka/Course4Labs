package pdv.fit.bstu.pms_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Description extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

//        Bundle arguments = getIntent().getExtras();
//
//        if(arguments!=null){
//            deed = (Deed) arguments.getSerializable(Deed.ADD_DEED_KEY);
//            deedNameEditText.setText(deed.getDeedName());
//            deedDescriptionEditText.setText(deed.getDeedDescription());
//            imageView.setImageBitmap(deed.getImage());
//        } else {
//            deed = new Deed();
//        }
    }
}