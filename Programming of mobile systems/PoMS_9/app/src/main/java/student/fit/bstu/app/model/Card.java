package student.fit.bstu.app.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

@Entity
public class Card implements Serializable {

    public static final String ADD_NEW_CARD_KEY = "ADD_NEW_CARD_KEY";
    @PrimaryKey
    public long id = ThreadLocalRandom.current().nextLong();

    public String title;
    public String description;
    public byte[] bitmap;
}
