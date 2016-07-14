package com.aupadhyay.fragment1;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class LeftFragment extends Fragment implements View.OnClickListener {

    OnFragmentClickListener onFragmentClickListener;
    private EditText movieNameET, movieRatingET;
    private Button sumbitButton;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onFragmentClickListener = (OnFragmentClickListener) context;
    }

    public LeftFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_left, container, false);
        View view = inflater.inflate(R.layout.fragment_left, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        movieNameET = (EditText) view.findViewById(R.id.movieNameET);
        movieRatingET = (EditText) view.findViewById(R.id.movieRatingET);
        sumbitButton = (Button) view.findViewById(R.id.sumbitButton);

        sumbitButton.setOnClickListener(this);
    }

    @Override
    public void onDestroy() {
        onFragmentClickListener = null;
        super.onDestroy();
    }

    public void sendMessageToActivity(String name, float rating)
    {
        if(onFragmentClickListener != null)
            onFragmentClickListener.setOnFragmentClickListener(name, rating);
    }

    @Override
    public void onClick(View view) {
        String movieName = movieNameET.getText().toString().trim();
        float movieRating = Float.parseFloat(movieRatingET.getText().toString().trim());

        sendMessageToActivity(movieName, movieRating);
    }

    public interface OnFragmentClickListener
    {
        void setOnFragmentClickListener(String movieName, float movieRating);
    }

}
