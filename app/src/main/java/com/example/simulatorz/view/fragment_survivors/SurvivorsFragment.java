package com.example.simulatorz.view.fragment_survivors;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simulatorz.R;
import com.example.simulatorz.game.interfaces.GameInterface;


public class SurvivorsFragment extends Fragment {

    private View root;
    private RecyclerView survivorsKindsRecycler;

    public static SurvivorsFragment newInstance() {
        return new SurvivorsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_survivors, container, false);
        init();
        updateSurvivorsKinds();
        return root;
    }

    private void init() {
        survivorsKindsRecycler = root.findViewById(R.id.survivors_recycler);
        survivorsKindsRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void updateSurvivorsKinds() {
        survivorsKindsRecycler.setAdapter(new SurvivorsKindAdapter(GameInterface.getSurvivorsList()));
    }

}