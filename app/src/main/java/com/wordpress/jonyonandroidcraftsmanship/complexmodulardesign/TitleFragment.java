package com.wordpress.jonyonandroidcraftsmanship.complexmodulardesign;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TitleFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView lvTitle = null;
    private ArrayAdapter<CharSequence> titleAdapter=null;
    private Communicator communicator=null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_title, container, false);
        lvTitle = (ListView) view.findViewById(R.id.lvTitle);
        titleAdapter=ArrayAdapter.createFromResource(getActivity(),R.array.titles,android.R.layout.simple_list_item_1);
        lvTitle.setAdapter(titleAdapter);
        lvTitle.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        communicator.respond(position);
    }

    public void setCommunicator(Communicator communicator) {
        this.communicator = communicator;
    }

    public interface Communicator{
        public void respond(int position);
    }
}
