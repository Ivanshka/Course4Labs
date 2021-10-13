package znp.fit.bstu.pms_5;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import znp.fit.bstu.pms_5.context.DiContext;
import znp.fit.bstu.pms_5.model.Deed;

public class CameraActivity extends Activity implements View.OnClickListener {
    private static final int CAMERA_REQUEST = 1888;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;
    private Deed deed;

    private ImageView imageView;
    private EditText deedNameEditText;
    private EditText deedDescriptionEditText;
    private Button continueButton;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        this.imageView = this.findViewById(R.id.imageView1);
        this.deedNameEditText = findViewById(R.id.deedNameEditText);
        this.deedDescriptionEditText = findViewById(R.id.deedDescriptionEditText);
        this.continueButton = findViewById(R.id.continueButton);

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);

        Bundle arguments = getIntent().getExtras();

        if(arguments!=null){
            deed = (Deed) arguments.getSerializable(Deed.ADD_DEED_KEY);
            deedNameEditText.setText(deed.getDeedName());
            deedDescriptionEditText.setText(deed.getDeedDescription());
            imageView.setImageBitmap(deed.getImage());
        } else {
            deed = new Deed();
        }

        Button photoButton = this.findViewById(R.id.makePhotoButton);

        photoButton.setOnClickListener(v -> {
            if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
            {
                requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_CAMERA_PERMISSION_CODE);
            }
            else
            {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });

        deedNameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                deed.setDeedName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        deedDescriptionEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                deed.setDeedDescription(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        continueButton.setOnClickListener(this);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_CAMERA_PERMISSION_CODE)
        {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(this, "camera permission granted", Toast.LENGTH_LONG).show();
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
            else
            {
                Toast.makeText(this, "camera permission denied", Toast.LENGTH_LONG).show();
            }
        }
    }
//
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK)
        {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
            deed.setImage(photo);
        }
    }
//
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.continueButton:{
                Intent intent = new Intent(this, MainActivity.class);
                DiContext.getDiContext().saveDeed(deed);
                startActivity(intent);
            }
        }
    }
}
//