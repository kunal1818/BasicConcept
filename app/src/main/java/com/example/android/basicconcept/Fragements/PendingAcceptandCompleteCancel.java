package com.example.android.basicconcept.Fragements;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.basicconcept.Model.Model;
import com.example.android.basicconcept.R;
import com.example.android.basicconcept.Adapter.MainAdapter;

import java.util.ArrayList;

import static android.R.attr.name;

/**
 * Created by mark63 on 21/4/17.
 */

public class PendingAcceptandCompleteCancel extends Fragment {

    private String mMode;
    private Bundle mExtra;
    private ArrayList<Model> modelArrayList = new ArrayList<Model>();
    private RecyclerView recyclerView;

    /**
     * @param mMode mode selection
     * @param extra is bundle
     */
    public PendingAcceptandCompleteCancel(final String mMode, final Bundle extra) {
        this.mMode = mMode;
        this.mExtra = extra;


    }

    /**
     * @param inflater           to inflate
     * @param container          container
     * @param savedInstanceState save instance
     * @return return view
     */

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.up_coming_and_past, container, false);
        MainAdapter name = new MainAdapter(this.getContext(), modelArrayList);
        recyclerView = (RecyclerView) view.findViewById(R.id.rvItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(name);
        recyclerView.setHasFixedSize(true);
        return view;
    }


}
