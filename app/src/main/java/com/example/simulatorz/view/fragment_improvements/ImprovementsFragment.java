package com.example.simulatorz.view.fragment_improvements;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.simulatorz.R;


public class ImprovementsFragment extends Fragment {

    private View root;

    public static ImprovementsFragment newInstance() {
        return new ImprovementsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_improvements, container, false);
        return root;
    }

}