package com.example.iothouse20;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class CapTerrasseFragment extends Fragment implements View.OnClickListener{

  CardView tempCard,moveCard,whaterCard,lightCard,addCard;
  View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_acqui_terrasse,container,false);

        tempCard =(CardView)view.findViewById(R.id.temp_card);
        moveCard =(CardView)view.findViewById(R.id.move_card);
        whaterCard =(CardView)view.findViewById(R.id.wather_card);
        addCard =(CardView)view.findViewById(R.id.add_card);

        tempCard.setOnClickListener(this);
        moveCard.setOnClickListener(this);
        whaterCard.setOnClickListener(this);
        addCard.setOnClickListener(this);




        return view;
    }
    @Override
    public void onClick(View v) {

        FragmentTransaction fragmentTransaction =getActivity().getSupportFragmentManager().beginTransaction();
        switch (v.getId())
        {
            case R.id.temp_card:
                fragmentTransaction.replace(R.id.fragment_container,new TempterrasseFragment());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
        }
    }
}
