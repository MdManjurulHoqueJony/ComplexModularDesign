package com.wordpress.jonyonandroidcraftsmanship.complexmodulardesign;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DescriptionFragment extends Fragment {

    private TextView tvDescription = null;
    private int position = 0;
    private static final int DEFAULT_VALUE = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_description, container, false);
        tvDescription = (TextView) view.findViewById(R.id.tvDescription);
        if (savedInstanceState != null) {
            position = savedInstanceState.getInt(getActivity().getString(R.string.pos_des_frag), DEFAULT_VALUE);
            String[] descriptions = getResources().getStringArray(R.array.descriptions);
            tvDescription.setText(descriptions[position]);
        }
        return view;
    }

    public void changeData(int position) {
        String[] descriptions = getResources().getStringArray(R.array.descriptions);
        tvDescription.setText(descriptions[position]);
        this.position = position;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(getActivity().getString(R.string.pos_des_frag), position);
    }
}
