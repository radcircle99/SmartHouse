package com.example.iothouse20;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.iothouse20.Adapter.CustomAdapter;
import com.example.iothouse20.Manipulationitem.itemClickListener;
import com.example.iothouse20.Model.item;
import com.example.iothouse20.Utils.ItemClickSupport;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.FormatFlagsConversionMismatchException;
import java.util.List;

import static androidx.recyclerview.widget.RecyclerView.*;

public class HomeFragment<CustomViewHolder> extends Fragment {


    RecyclerView recyclerView;
    LayoutManager layoutManager;

    List<item> items =new ArrayList<>();
    CustomAdapter adapter;
    View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home, container, false);




        recyclerView = (RecyclerView) view.findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        items.add(new item(0, "Consulter votre maison", "https://cdn.pixabay.com/photo/2016/01/19/17/08/vintage-1149558_960_720.jpg"));
        items.add(new item(0, "Contrôler votre maison", "https://cdn.pixabay.com/photo/2017/11/04/10/25/success-2917048_960_720.jpg"));

        // 2 - Calling the method that configuring click on RecyclerView
        this.configureOnClickRecyclerView();

        adapter = new CustomAdapter(view.getContext(), items);
        recyclerView.setAdapter(adapter);


        return view;
    }

    private void configureOnClickRecyclerView(){
        ItemClickSupport.addTo(recyclerView, R.layout.fragment_home)
                .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                       item aitem = adapter.getUser(position);
                        FragmentTransaction fragmentTransaction =getActivity().getSupportFragmentManager().beginTransaction();
                       switch (position)
                       {
                           case 0:

                               fragmentTransaction.replace(R.id.fragment_container,new GetFragment());
                               fragmentTransaction.addToBackStack(null);
                               fragmentTransaction.commit();
                               break;
                           case 1:

                                fragmentTransaction.replace(R.id.fragment_container,new PutFragment());
                               fragmentTransaction.addToBackStack(null);
                               fragmentTransaction.commit();
                               break;
                       }

                        Log.e("TAG", "Position : "+position);
                    }


                });
    }


}
