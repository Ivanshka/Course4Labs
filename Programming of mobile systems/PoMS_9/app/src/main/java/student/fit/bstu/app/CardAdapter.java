package student.fit.bstu.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import student.fit.bstu.app.model.Card;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder>{

    private final LayoutInflater inflater;
    private final List<Card> cards;
    private final Context ccontext;
    private final Context activity;

    CardAdapter(Context context, List<Card> cards, Activity activity) {
        this.cards = cards;
        this.inflater = LayoutInflater.from(context);
        this.ccontext = context;
        this.activity = activity;

    }

    @Override
    public CardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CardAdapter.ViewHolder holder, int position) {
        Card card = cards.get(position);
        holder.cardImageView.setImageBitmap(BitmapFactory.decodeByteArray(card.bitmap, 0, card.bitmap.length));
        holder.titleView.setText(card.title);
        holder.descriptionView.setText(card.description);

        holder.mRootView.setOnClickListener(view -> {
            Intent intent = new Intent(ccontext, CameraActivity.class);
            intent.putExtra(Card.ADD_NEW_CARD_KEY, card);
            activity.startActivity(intent);
        });
//        holder.capitalView.setText(state.getCapital());
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView cardImageView;
        TextView titleView;
        TextView descriptionView;
        View mRootView;
        ViewHolder(View view){
            super(view);
            cardImageView = view.findViewById(R.id.cardImageView);
            titleView = view.findViewById(R.id.titleTextView);
            descriptionView = view.findViewById(R.id.descriptionTextView);
            mRootView = view;
        }
    }
}
