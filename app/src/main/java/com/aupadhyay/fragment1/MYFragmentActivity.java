package com.aupadhyay.fragment1;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MYFragmentActivity extends AppCompatActivity implements LeftFragment.OnFragmentClickListener {

    LeftFragment leftFragment;
    RightFragment rightFragment;
    FragmentManager fragmentManager;

    public void initFragments()
    {
        leftFragment = new LeftFragment();
        rightFragment = new RightFragment();

        fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction().replace(R.id.leftFragment, leftFragment).commit();
        fragmentManager.beginTransaction().replace(R.id.rightFragment, rightFragment).commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myfragment);
        initFragments();
    }

    @Override
    public void setOnFragmentClickListener(String movieName, float movieRating) {
        rightFragment.getValuesFromActivity(movieName, movieRating);
    }
}
