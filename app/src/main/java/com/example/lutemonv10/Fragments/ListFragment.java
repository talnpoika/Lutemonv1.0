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
import com.example.lutemonv10.Storage;


public class ListFragment extends Fragment {

    private RecyclerView recyclerView;

    private Storage storage;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_list, container, false);

        storage = Storage.getInstance();

        recyclerView = view.findViewById(R.id.rvLutemonList);

        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new LutemonListAdapter(getContext().getApplicationContext(), storage.getLutemons()));

        return view;
    }
}