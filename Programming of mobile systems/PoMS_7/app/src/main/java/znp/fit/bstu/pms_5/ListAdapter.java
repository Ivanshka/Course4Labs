package znp.fit.bstu.pms_5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import znp.fit.bstu.pms_5.model.Deed;

public class ListAdapter extends ArrayAdapter<Deed> {

    private int resourceLayout;
    private Context mContext;

    public ListAdapter(Context context, int resource, List<Deed> items) {
        super(context, resource, items);
        this.resourceLayout = resource;
        this.mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        

        if (view == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(mContext);
            view = vi.inflate(resourceLayout, null);
        }

        Deed deed = getItem(position);

        if (deed != null) {
            TextView name = view.findViewById(R.id.deedName);
            TextView description = view.findViewById(R.id.deedDescription);
            ImageView image = view.findViewById(R.id.deedImage);

            if (name != null) {
                name.setText(deed.getDeedName());
            }

            if (description != null) {
                description.setText(deed.getDeedDescription());
            }

            if (image != null) {
                image.setImageBitmap(deed.getImage());
            }
        }

        return view;
    }

}