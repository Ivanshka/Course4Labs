package znp.fit.bstu.pms_5.context;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import znp.fit.bstu.pms_5.ListAdapter;
import znp.fit.bstu.pms_5.R;
import znp.fit.bstu.pms_5.model.Deed;
import znp.fit.bstu.pms_5.model.DeedsHolder;

public class DiContext {
    public static final String PATH_TO_JSON = "tasks.json";

    private static DiContext diContext;

    public static DiContext getDiContext(){
        if(diContext == null){
            synchronized (DiContext.class){
                if (diContext == null){
                    diContext = new DiContext();
                }
            }
        }

        return diContext;
    }

    private final DeedsHolder deedsHolder;
    private SQLiteDatabase sqLiteDatabase;

    private DiContext(){
        this.deedsHolder = new DeedsHolder();
    }

    public void addSqlDatabase(SQLiteDatabase sqLiteDatabase){
        this.sqLiteDatabase = sqLiteDatabase;
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS deeds (id TEXT, name TEXT," +
                " description TEXT, image BLOB)");
    }

    public SQLiteDatabase getSqlDatabase(){
        return sqLiteDatabase;
    }

    public void saveDeed(Deed deed){
        deleteDeed(deed);
        ContentValues values = new ContentValues();
        if(deed.getImage() != null) {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            deed.getImage().compress(Bitmap.CompressFormat.JPEG, 100, bos);
            byte[] img = bos.toByteArray();
            values.put("image", img);
        }

        values.put("id", deed.getId());
        values.put("name", deed.getDeedName());
        values.put("description", deed.getDeedDescription());

        try {
            sqLiteDatabase.insert("deeds", null, values);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteDeed(Deed deed){
        sqLiteDatabase.execSQL("delete from deeds where id='" + deed.getId() + "'");
    }

    public List<Deed> getAllDeeds(){
        List<Deed> deeds = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from deeds",null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                String id = cursor.getString(cursor.getColumnIndex("id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String description = cursor.getString(cursor.getColumnIndex("description"));
                byte[] imageBlob = cursor.getBlob(cursor.getColumnIndex("image"));
                Bitmap image = BitmapFactory.decodeByteArray(imageBlob, 0, imageBlob.length);
                Deed deed = new Deed(id, imageBlob, name, description);
                deeds.add(deed);
                cursor.moveToNext();
            }
        }

        return deeds;
    }

    public DeedsHolder getDeedsHolder() {
        return deedsHolder;
    }
}
