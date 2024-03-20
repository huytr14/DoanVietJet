package com.sinhvien.doan.FragmentParents;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sinhvien.doan.Class.News;
import com.sinhvien.doan.Class.NewsAdapter;
import com.sinhvien.doan.R;

import java.util.ArrayList;


public class NotificationFragment extends Fragment {

    private ArrayList<News> newsArrayList;
    private String[] newsHeading;
    private int[] imageResourceID;
    RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_notification, container, false);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataInitialize();
        recyclerView=view.findViewById(R.id.rcv_news);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        NewsAdapter newsAdapter=new NewsAdapter(getContext(),newsArrayList);
        recyclerView.setAdapter(newsAdapter);
        newsAdapter.notifyDataSetChanged();
    }
    public void dataInitialize(){
        newsArrayList=new ArrayList<>();
        newsHeading=new String[]{
                getString(R.string.head1),
                getString(R.string.head2),
                getString(R.string.head2),
                getString(R.string.head4),
                getString(R.string.head5),
                getString(R.string.head6),
                getString(R.string.head7),
                getString(R.string.head8),
                getString(R.string.head9),
                getString(R.string.head10),
        };
        imageResourceID=new int[]{
                R.drawable.ic_letter_64dp,
                R.drawable.ic_letter_64dp,
                R.drawable.ic_letter_64dp,
                R.drawable.ic_letter_64dp,
                R.drawable.ic_letter_64dp,
                R.drawable.ic_letter_64dp,
                R.drawable.ic_letter_64dp,
                R.drawable.ic_letter_64dp,
                R.drawable.ic_letter_64dp,
                R.drawable.ic_letter_64dp,
        };
        for(int i=0;i<newsHeading.length;i++){
            News news=new News(imageResourceID[i], newsHeading[i]);
            newsArrayList.add(news);
        }

    }
}