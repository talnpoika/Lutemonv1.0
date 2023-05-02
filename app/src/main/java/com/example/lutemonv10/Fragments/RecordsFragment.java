package com.example.lutemonv10.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lutemonv10.LutemonListAdapter;
import com.example.lutemonv10.R;
import com.example.lutemonv10.RecordListAdapter;
import com.example.lutemonv10.Storage;


public class RecordsFragment extends Fragment {

    private RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_records, container, false);


        recyclerView = view.findViewById(R.id.rvRecords);

        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new RecordListAdapter(getContext().getApplicationContext(), Storage.getInstance().getLutemons()));

        return view;
    }
}