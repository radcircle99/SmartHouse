package com.example.iothouse20;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.iothouse20.Adapter.CustomCapAdapter;
import com.example.iothouse20.Model.itemcap;
import com.example.iothouse20.Utils.ItemClickSupport;

import java.util.ArrayList;
import java.util.List;

public class GetFragment extends Fragment  {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    List<itemcap> items =new ArrayList<>();
    CustomCapAdapter adapter;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view=inflater.inflate(R.layout.fragment_acquisition,container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycleView1);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        items.add(new itemcap(0, "Terrasse", "https://cdn.pixabay.com/photo/2017/08/07/22/23/house-2608548_960_720.jpg"));
        items.add(new itemcap(0, "Salon", "https://cdn.pixabay.com/photo/2017/09/09/18/25/living-room-2732939_960_720.jpg"));
        items.add(new itemcap(0, "Cuisine", "https://cdn.pixabay.com/photo/2016/01/31/14/32/architecture-1171462_960_720.jpg"));
        items.add(new itemcap(0, "Salle de Bain", "https://cdn.pixabay.com/photo/2018/01/29/07/55/modern-minimalist-bathroom-3115450_960_720.jpg"));


        // 2 - Calling the method that configuring click on RecyclerView
        this.configureOnClickRecyclerView();

        adapter = new CustomCapAdapter(view.getContext(), items);
        recyclerView.setAdapter(adapter);


        return view;
    }
    private void configureOnClickRecyclerView(){
        ItemClickSupport.addTo(recyclerView, R.layout.fragment_acquisition)
                .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        itemcap aitem = adapter.getUser(position);
                        FragmentTransaction fragmentTransaction =getActivity().getSupportFragmentManager().beginTransaction();
                        switch (position)
                        {
                            case 0:

                                fragmentTransaction.replace(R.id.fragment_container,new CapTerrasseFragment());
                                fragmentTransaction.addToBackStack(null);
                                fragmentTransaction.commit();
                                break;
                            case 1:

                                fragmentTransaction.replace(R.id.fragment_container,new CapSalonFragment());
                                fragmentTransaction.addToBackStack(null);
                                fragmentTransaction.commit();
                                break;
                            case 2 :
                                fragmentTransaction.replace(R.id.fragment_container,new CapCuisineFragment());
                                fragmentTransaction.addToBackStack(null);
                                fragmentTransaction.commit();
                                break;
                        }

                        Log.e("TAG", "Position : "+position);
                    }


                });
    }



}
