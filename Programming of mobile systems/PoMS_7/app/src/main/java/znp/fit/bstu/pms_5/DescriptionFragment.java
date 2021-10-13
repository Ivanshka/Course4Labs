package znp.fit.bstu.pms_5;

import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import znp.fit.bstu.pms_5.model.Deed;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DescriptionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DescriptionFragment extends Fragment {

    private Deed currentDeed;

    public DescriptionFragment() {
        super(R.layout.fragment_description);
    }

    public DescriptionFragment(Deed deed) {
        super(R.layout.fragment_description);
        currentDeed = deed;
    }

    public static DescriptionFragment newInstance(String param1, String param2) {
        DescriptionFragment fragment = new DescriptionFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {

        Bundle arguments = getActivity().getIntent().getExtras();

        TextView deedDescription = view.findViewById(R.id.deedDescriptionTextView);
        TextView deedName = view.findViewById(R.id.deedNameTextView);
        ImageView deedImage = view.findViewById(R.id.imageView2);

        if(currentDeed != null)
        {
            deedName.setText(currentDeed.getDeedName());
            deedDescription.setText(currentDeed.getDeedDescription());
            deedImage.setImageBitmap(currentDeed.getImage());
        } else if(arguments!=null){
            Deed deed = (Deed) arguments.getSerializable(Deed.ADD_DEED_KEY);
            deedName.setText(deed.getDeedName());
            deedDescription.setText(deed.getDeedDescription());
            deedImage.setImageBitmap(deed.getImage());
        } else {
            deedName.setText("nothing to show");
            deedDescription.setText("nothing to show");
        }

    }
}