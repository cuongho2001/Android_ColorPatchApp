package edu.temple.fragapp;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ColorFragment extends Fragment {

    TextView randomDisplay;

    int number;

    InitiateInterface parent;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        parent = (InitiateInterface) context;

    }

    @Override
    // For DisplayFragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        number = bundle.getInt("displayNumber");

    }

    public static DisplayFragment newInstance(int number) {
        DisplayFragment dFragment = new DisplayFragment();

        Bundle bundle = new Bundle();
        bundle.putInt("displayNumber",number);

        dFragment.setArguments(bundle);

        return dFragment;
    }

    public ColorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_color, container, false);

        randomDisplay = v.findViewById(R.id.randomDisplay);
        displayNumber(number);

        return v;
    }

    public void generateNewNumber() {
        randomDisplay.setText(String.valueOf(Math.random() * 100));
    }

    interface InitiateInterface {
        public void buttonClicked();
    }
}
