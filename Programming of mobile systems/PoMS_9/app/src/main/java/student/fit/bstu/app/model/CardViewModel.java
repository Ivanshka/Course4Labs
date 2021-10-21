package student.fit.bstu.app.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import student.fit.bstu.app.App;
import student.fit.bstu.app.AppDatabase;

public class CardViewModel extends ViewModel {
    MutableLiveData<CardCollection> data;
    private AppDatabase db;
    private CardDao cardDao;

    public CardViewModel(){
        this.db = App.getInstance().getDatabase();
        this.cardDao = db.cardDao();
    }

    public LiveData<CardCollection> getData() {
        if (data == null) {
            data = new MutableLiveData<>();
            loadData();
        }
        return data;
    }

    private void loadData() {
        CardCollection cardCollection = new CardCollection();
        cardCollection.cards = cardDao.getAll();
        data.setValue(cardCollection);
    }

    public void update() {
        data.getValue().cards.clear();
        data.getValue().cards.addAll(cardDao.getAll());
    }
}
