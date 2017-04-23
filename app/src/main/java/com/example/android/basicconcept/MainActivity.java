package com.example.android.basicconcept;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import com.example.android.basicconcept.Adapter.MainAdapter;
import com.example.android.basicconcept.Model.Model;

/**
 * Main page where recyclere view is applied to display names
 */
public class MainActivity extends AppCompatActivity {

    private ArrayList<Model> modelArrayList = new ArrayList<Model>();
    private RecyclerView recyclerView;


    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        modelArrayList.add(new Model("kunal"));
        modelArrayList.add(new Model("Ram"));
        modelArrayList.add(new Model("Akash"));
        modelArrayList.add(new Model("Hitesh"));
        modelArrayList.add(new Model("Sourav"));
        modelArrayList.add(new Model("Sachin"));
        modelArrayList.add(new Model("Arpit"));
        modelArrayList.add(new Model("HoneySingh"));

        MainAdapter name = new MainAdapter(this, modelArrayList);
        recyclerView = (RecyclerView) findViewById(R.id.rvItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(name);
        recyclerView.setHasFixedSize(true);
        return;

    }
}
