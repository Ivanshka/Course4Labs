package student.fit.bstu.app;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import student.fit.bstu.app.model.Card;
import student.fit.bstu.app.model.CardDao;

@Database(entities = {Card.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CardDao cardDao();
}
