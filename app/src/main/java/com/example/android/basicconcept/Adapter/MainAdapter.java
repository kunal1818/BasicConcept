package com.example.android.basicconcept.Adapter;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.basicconcept.MainViewPager;
import com.example.android.basicconcept.Model.Model;
import com.example.android.basicconcept.R;

import java.util.ArrayList;

/**
 * Created by mark63 on 20/4/17.
 */

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Model> modelArrayList;
    private TextView tvName;
    private Context context;

    /**
     * @param context to fetch data of ths context
     * @param model   to input data
     */


    public MainAdapter(final Context context, final ArrayList<Model> model) {
        this.context = context;
        this.modelArrayList = model;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View convertview = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_name, parent, false);
        ViewHolder viewHolder = new ViewHolder(convertview);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        Model objName = modelArrayList.get(position);
        TextView textname = tvName;
        textname.setText(objName.getItemname());
    }

    @Override


    public int getItemCount() {
        return modelArrayList.size();
    }

    /**
     * viewholder class
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        /**
         * @param itemview select items
         */
        public ViewHolder(final View itemview) {
            super(itemview);
            tvName = (TextView) itemview.findViewById(R.id.tvname);
            itemview.setOnClickListener(this);

        }


        @Override
        public void onClick(final View v) {
            Intent intent = new Intent(context, MainViewPager.class);
            context.startActivity(intent);

        }
    }
}