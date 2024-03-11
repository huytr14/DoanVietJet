package com.sinhvien.doan.FragmentParents;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewFlipper;

import com.sinhvien.doan.R;


public class HomeFragment extends Fragment {


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
}