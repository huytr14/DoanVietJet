package com.sinhvien.doan.FragmentParents;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.sinhvien.doan.Activity.Ticket;
import com.sinhvien.doan.R;


public class HomeFragment extends Fragment {


    ImageButton btnTicket;


    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_home, container, false);
        ViewFlipper mViewFlipper = (ViewFlipper) v.findViewById(R.id.viewFlipper);
        mViewFlipper.setFlipInterval(3000);
        mViewFlipper.setAutoStart(true);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnTicket=view.findViewById(R.id.btnTicket);
        btnTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Ticket.class);
                startActivity(intent);
            }
        });
    }
}