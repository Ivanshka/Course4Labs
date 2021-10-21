package student.fit.bstu.app.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CardDao {

    @Query("SELECT * FROM card")
    List<Card> getAll();

    @Query("SELECT * FROM card WHERE id = :id")
    Card getById(long id);

    @Insert
    void insert(Card card);

    @Update
    void update(Card card);

    @Delete
    void delete(Card card);

}
