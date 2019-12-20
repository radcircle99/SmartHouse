package com.example.iothouse20.Adapter;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.battleent.ribbonviews.RibbonLayout;
import com.example.iothouse20.GetFragment;
import com.example.iothouse20.Manipulationitem.itemClickListener;
import com.example.iothouse20.Model.item;
import com.example.iothouse20.R;
import com.squareup.picasso.Picasso;

import java.nio.DoubleBuffer;
import java.util.List;

class  CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{

    public RibbonLayout ribbonLayout;
    public ImageView imageView;

    private com.example.iothouse20.Manipulationitem.itemClickListener itemClickListener;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);

        ribbonLayout = (RibbonLayout)itemView.findViewById(R.id.ribbornLayout);
        imageView = (ImageView)itemView.findViewById(R.id.Imageview_rb1);
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        itemClickListener.onClick(v,getLayoutPosition(),false);
    }
    public void setItemClickListener (itemClickListener itemClickListener)
    {
        this.itemClickListener=itemClickListener;
    }

    @Override
    public boolean onLongClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition(),true);
        return true;
    }
}

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    Context context;
    List<item> itemList;
    private item getUser;

    public CustomAdapter(Context context, List<item> itemList) {
        this.context = context;
        this.itemList = itemList;
    }
//Pour récupérer nos éléments
    public item getUser(int position){
        return this.itemList.get(position);
    }
    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View itemview = LayoutInflater.from(context).inflate(R.layout.itemhome,parent,false);
        return new CustomViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, final int position) {
        final item itemc = itemList.get(position);


        if(itemc.type == 0)
        {
            holder.ribbonLayout.setShowBottom(true);

            holder.ribbonLayout.setHeaderRibbonColor(Color.parseColor("#2B323A"));
            holder.ribbonLayout.setHeaderRibbonColor(Color.parseColor("#FFFFFF"));

            holder.ribbonLayout.setBottomText(itemc.BottomText);
            Picasso.with(context).load(itemc.imageURL)
                    .into(holder.imageView);
        }

    }



    @Override
    public int getItemCount() {
        return itemList.size();
    }

}
