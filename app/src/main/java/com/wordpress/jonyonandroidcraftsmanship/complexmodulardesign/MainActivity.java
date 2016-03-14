package com.wordpress.jonyonandroidcraftsmanship.complexmodulardesign;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements TitleFragment.Communicator {

    private TitleFragment titleFragment = null;
    private DescriptionFragment descriptionFragment = null;
    private FragmentManager fragmentManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager=getSupportFragmentManager();
        titleFragment= (TitleFragment) fragmentManager.findFragmentById(R.id.frgTitle);
        titleFragment.setCommunicator(this);
    }

    @Override
    public void respond(int position) {
        descriptionFragment= (DescriptionFragment) fragmentManager.findFragmentById(R.id.frgDescription);
        if (descriptionFragment != null && descriptionFragment.isVisible()) {
            descriptionFragment.changeData(position);
        }else{
            Intent intent=new Intent(this,DescriptionActivity.class);
            intent.putExtra(getString(R.string.pos_main),position);
            startActivity(intent);
        }
    }
}
