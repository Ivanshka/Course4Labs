package student.fit.bstu.app;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;
import java.util.Observable;

import student.fit.bstu.app.model.Card;
import student.fit.bstu.app.model.CardCollection;
import student.fit.bstu.app.model.CardDao;
import student.fit.bstu.app.model.CardViewModel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private AppDatabase db;
    private CardDao cardDao;
    RecyclerView recyclerView;
    static CardViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.db = App.getInstance().getDatabase();
        this.cardDao = db.cardDao();

        if(model == null) {
            model = ViewModelProviders.of(this).get(CardViewModel.class);
        }
        // начальная инициализация списка
        RecyclerView recyclerView = findViewById(R.id.list);

        LiveData<CardCollection> data = model.getData();

        Context context = this;

        data.observe(this, cardCollection -> {
            // создаем адаптер
            CardAdapter adapter = new CardAdapter(context, cardCollection.cards, this);
            // устанавливаем для списка адаптер
            recyclerView.setAdapter(adapter);
        });

        findViewById(R.id.addNewButton).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.addNewButton: {
                Intent intent = new Intent(this, CameraActivity.class);
//                intent.putExtra(Card.ADD_NEW_CARD_KEY, new Card());
                startActivity(intent);
            }
        }
    }
}