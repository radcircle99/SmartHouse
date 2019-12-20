package com.example.iothouse20.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.battleent.ribbonviews.RibbonLayout;
import com.example.iothouse20.Manipulationitem.itemClickListener;
import com.example.iothouse20.Model.itemcap;
import com.example.iothouse20.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomCapAdapter extends RecyclerView.Adapter<CustomCapViewHolder> {

    Context context;
    List<itemcap> itemList;
    private itemcap getUser;

    public CustomCapAdapter(Context context, List<itemcap> itemList) {
        this.context = context;
        this.itemList = itemList;
    }
    //Pour récupérer nos éléments
    public itemcap getUser(int position){
        return this.itemList.get(position);
    }
    @NonNull
    @Override
    public CustomCapViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View itemview = LayoutInflater.from(context).inflate(R.layout.itemacqui,parent,false);
        return new CustomCapViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomCapViewHolder holder, int position) {
        final itemcap itemc = itemList.get(position);


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
class  CustomCapViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{

    public RibbonLayout ribbonLayout;
    public ImageView imageView;

    private com.example.iothouse20.Manipulationitem.itemClickListener itemClickListener;



    public CustomCapViewHolder(@NonNull View itemView) {
        super(itemView);
        ribbonLayout = (RibbonLayout)itemView.findViewById(R.id.ribbornLayout);
        imageView = (ImageView)itemView.findViewById(R.id.Imageview_rb2);
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        itemClickListener.onClick(v,getLayoutPosition(),false);
    }
    public void setItemClickListener (com.example.iothouse20.Manipulationitem.itemClickListener itemClickListener)
    {
        this.itemClickListener=itemClickListener;
    }

    @Override
    public boolean onLongClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition(),true);
        return true;
    }
}
