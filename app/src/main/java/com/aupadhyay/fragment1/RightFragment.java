package com.aupadhyay.fragment1;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class RightFragment extends Fragment {

    private TextView movieNameTV, thanksTV;
    private RatingBar ratingBar;


    public RightFragment() {
        // Required empty public constructor
    }

    public void getValuesFromActivity(String movieName, float movieRating)
    {
        movieNameTV.setText(movieName);
        ratingBar.setRating(movieRating);
        thanksTV.setText(R.string.tnx);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_right, container, false);
        View view = inflater.inflate(R.layout.fragment_right, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        movieNameTV = (TextView) view.findViewById(R.id.movieNameTV);
        ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);
        thanksTV = (TextView) view.findViewById(R.id.thanksTV);
    }
}
