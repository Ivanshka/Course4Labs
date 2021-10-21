package student.fit.bstu.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

import student.fit.bstu.app.model.Card;
import student.fit.bstu.app.model.CardDao;

public class CameraActivity extends Activity  implements View.OnClickListener {
    private static final int CAMERA_REQUEST = 1888;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;
    private Card card;

    private ImageView imageView;
    private EditText cardNameEditText;
    private EditText cardDescriptionEditText;
    private Button continueButton;
    private Button deleteButton;

    private AppDatabase db;
    private CardDao cardDao;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        this.db = App.getInstance().getDatabase();
        this.cardDao = db.cardDao();

        this.imageView = this.findViewById(R.id.imageNew);
        this.cardNameEditText = findViewById(R.id.cardTitleNew);
        this.cardDescriptionEditText = findViewById(R.id.cardDescriptionNew);
        this.continueButton = findViewById(R.id.continueButton);
        this.deleteButton = findViewById(R.id.DeleteButton);

        Bundle arguments = getIntent().getExtras();

        if(arguments!=null){
            card = (Card) arguments.getSerializable(Card.ADD_NEW_CARD_KEY);
            cardNameEditText.setText(card.title);
            cardDescriptionEditText.setText(card.description);
            imageView.setImageBitmap(BitmapFactory.decodeByteArray(card.bitmap, 0, card.bitmap.length));
        } else {
            card = new Card();
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

        cardNameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                card.title = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        cardDescriptionEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                card.description = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        continueButton.setOnClickListener(this);
        deleteButton.setOnClickListener(this);
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
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            photo.compress(Bitmap.CompressFormat.JPEG, 100, bos);
            byte[] img = bos.toByteArray();
            card.bitmap = img;
        }
    }
    //
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.continueButton:{
                Intent intent = new Intent(this, MainActivity.class);
                if(cardDao.getAll().stream()
                        .anyMatch(c -> c.id == card.id)){
                    cardDao.update(card);
                } else {
                    cardDao.insert(card);
                }
                card = null;
                MainActivity.model.update();
                startActivity(intent);
            }
            case R.id.DeleteButton:{
                cardDao.delete(card);
                MainActivity.model.update();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
        }
    }
}