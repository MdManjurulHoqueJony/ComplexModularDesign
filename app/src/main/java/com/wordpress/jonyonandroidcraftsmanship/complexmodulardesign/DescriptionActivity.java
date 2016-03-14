package com.wordpress.jonyonandroidcraftsmanship.complexmodulardesign;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class DescriptionActivity extends AppCompatActivity {

    private static final int DEFAULT_VALUE = 0;
    private FragmentManager fragmentManager = null;
    private DescriptionFragment descriptionFragment = null;
    private int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        Intent intent = getIntent();
        position = intent.getIntExtra(getString(R.string.pos_main), DEFAULT_VALUE);
        fragmentManager = getSupportFragmentManager();
        descriptionFragment = (DescriptionFragment) fragmentManager.findFragmentById(R.id.frgDescription);
        if (descriptionFragment!=null) {
            descriptionFragment.changeData(position);
        }
    }

}
