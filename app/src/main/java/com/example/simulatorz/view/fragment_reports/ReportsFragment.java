package com.example.simulatorz.view.fragment_reports;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.simulatorz.R;
import com.example.simulatorz.game.interfaces.GameInterface;


public class ReportsFragment extends Fragment {

    private View root;
    private RecyclerView simpleEventRecycler;

    public static ReportsFragment newInstance() {
        return new ReportsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_events, container, false);
        init();
        updateReports();
        return root;
    }

    private void init() {
        simpleEventRecycler = root.findViewById(R.id.simple_events_recycler);
        simpleEventRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void updateReports() {
        simpleEventRecycler.setAdapter(new ReportsAdapter(GameInterface.getReportList()));
    }

}