package com.example.simulatorz.view.fragment_indicators;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.simulatorz.R;
import com.example.simulatorz.view.fragment_main.MainFragment;

public class IndicatorsFragment extends Fragment implements MainFragment.Callback {

    private Callback callback;

    private IndicatorsManager indicatorsManager;

    private View root;

    public static IndicatorsFragment newInstance() {
        return new IndicatorsFragment();
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Callback) {
            callback = (Callback) context;
        } else {
            throw new ClassCastException();
        }
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        root = inflater.inflate(R.layout.fragment_indicators, container, false);
        init();
        return root;
    }

    private void init() {
        root.findViewById(R.id.back_to_menu).setOnClickListener(view -> callback.openMenu());

        indicatorsManager = new IndicatorsManager(root);
        indicatorsManager.updateIndicators();

        showMainFragment();
    }

    private void showMainFragment() {
        getChildFragmentManager()
                .beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commit();
    }

    @Override
    public void afterNextMove() {
        indicatorsManager.updateIndicators();
    }

    public interface Callback {

        void openMenu();

    }

}
