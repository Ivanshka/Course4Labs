package pdv.fit.bstu.pms_5.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.util.UUID;

public class Deed implements Serializable {
    public static final String ADD_DEED_KEY = "ADD_DEED_KEY";

    private String id;
    private byte[] image;
    private String deedName;
    private String deedDescription;

    public Deed(String id, byte[] image, String deedName, String deedDescription) {
        this.id = id;
        this.image = image;
        this.deedName = deedName;
        this.deedDescription = deedDescription;
    }

    public Deed(){
        id = UUID.randomUUID().toString();
    }

    public Bitmap getImage() {
        if(image == null){
            return null;
        }

        Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
        return bitmap;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeedName() {
        return deedName;
    }

    public String getDeedDescription() {
        return deedDescription;
    }

    public void setImage(Bitmap image) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, bos);
        this.image = bos.toByteArray();
    }

    public void setDeedName(String deedName) {
        this.deedName = deedName;
    }

    public void setDeedDescription(String deedDescription) {
        this.deedDescription = deedDescription;
    }
}
