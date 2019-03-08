package com.example.test.expandable_recyclerView_custom;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test.R;

import java.util.ArrayList;

public class ExpandableRecyclerViewAdapter extends RecyclerView.Adapter<ExpandableRecyclerViewAdapter.ViewHolder> {
    ArrayList<String> nameList = new ArrayList<String>();
    ArrayList<ArrayList> itemNameList = new ArrayList<ArrayList>();
    Context context;
    ArrayList<Integer> counter = new ArrayList<Integer>();

    public ExpandableRecyclerViewAdapter(Context context, ArrayList<String> nameList,ArrayList<ArrayList> itemNameList) {
        this.nameList = nameList;
        this.context = context;
        this.itemNameList=itemNameList;

        for (int i = 0; i < nameList.size(); i++) {
            counter.add(0);
        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.group_view_holder, viewGroup, false);

        ExpandableRecyclerViewAdapter.ViewHolder vh = new ExpandableRecyclerViewAdapter.ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.name.setText(nameList.get(position));

        InnerRecyclerViewAdapter itemInnerRecyclerView = new InnerRecyclerViewAdapter(itemNameList.get(position));



        holder.cardRecyclerView.setLayoutManager(new LinearLayoutManager(context));


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (counter.get(position) % 2 == 0) {
                    holder.cardRecyclerView.setVisibility(View.VISIBLE);

                } else {
                    holder.cardRecyclerView.setVisibility(View.GONE);
                }

                counter.set(position, counter.get(position) + 1);


            }
        });
        holder.cardRecyclerView.setAdapter(itemInnerRecyclerView);
    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        CardView cardView;
        RecyclerView cardRecyclerView;
        ImageView iview;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.mobile_os);
            cardView=itemView.findViewById(R.id.cardView);
            cardRecyclerView=itemView.findViewById(R.id.innerRecyclerView);
            itemView=iview.findViewById(R.id.iview);
        }
    }
}
