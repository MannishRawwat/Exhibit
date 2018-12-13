package com.rawggar.exhibit.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rawggar.exhibit.R;
import com.rawggar.exhibit.model.tShirt;

import java.util.List;

public class ShirtAdapter extends RecyclerView.Adapter<ShirtAdapter.MyViewHolder> {
    private Context context;
    private List<tShirt> shirtList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        //here we will bind graphic items to thier given names here.
        public ImageView thumbnail;
        public TextView title;

        public MyViewHolder(View view) {
            super(view);
            thumbnail = view.findViewById(R.id.shirt_image);
            title = view.findViewById(R.id.shirt_title);
        }
    }

    public ShirtAdapter(Context context, List<tShirt> shirtList) {
        this.context = context;
        this.shirtList = shirtList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.shirt_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final tShirt shirt = shirtList.get(position);

        holder.title.setText(shirt.getTitle());

        Glide.with(context)
                .load(shirt.getUrl())
                .into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return shirtList.size();
    }
}
