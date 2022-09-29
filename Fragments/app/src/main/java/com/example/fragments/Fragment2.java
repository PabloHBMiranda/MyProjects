package com.example.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {
    Button btnFrag1, btnFrag2, btnSensor;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment2,container,false);
        btnSensor = view.findViewById(R.id.btnSensor);
        btnFrag1 = view.findViewById(R.id.btn01);
        btnFrag2 = view.findViewById(R.id.btn02);
        btnSensor.setAlpha(0.5f);

        btnSensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent((MainActivity)getActivity(),SensorAct.class);
                startActivity(i);
            }
        });

        btnFrag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).setViewPager(1);
                Toast.makeText(getContext(),"Você está na Fragment 2",Toast.LENGTH_SHORT).show();
            }
        });

        btnFrag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).setViewPager(0);
            }
        });

        return view;
    }
}
