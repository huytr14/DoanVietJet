package com.sinhvien.doan;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NotificationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NotificationFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NotificationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NotificationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NotificationFragment newInstance(String param1, String param2) {
        NotificationFragment fragment = new NotificationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_notification, container, false);
        TextView Text1=v.findViewById(R.id.Text1);
        TextView Text2=v.findViewById(R.id.Text2);

        ImageView Buttondown1=v.findViewById(R.id.Buttondown1);
        ImageView Buttondown2=v.findViewById(R.id.Buttondown2);

        Buttondown1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if  (Text1.getVisibility() == View.GONE){
                    Text1.setVisibility (View.VISIBLE);
                    Buttondown1.setImageResource(R.drawable.baseline_arrow_upward_24);
                } else {
                    Text1.setVisibility(View.GONE);
                    Buttondown1.setImageResource(R.drawable.baseline_arrow_downward_24);
                }

            }
        });
        Buttondown2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Text2.getVisibility()==View.GONE){
                    Text2.setVisibility (View.VISIBLE);
                    Buttondown2.setImageResource(R.drawable.baseline_arrow_upward_24);
                } else {
                    Text2.setVisibility(View.GONE);
                    Buttondown2.setImageResource(R.drawable.baseline_arrow_downward_24);
                }

            }
        });
        return v;
    }
}