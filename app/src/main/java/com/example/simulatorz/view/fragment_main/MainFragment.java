package com.example.simulatorz.view.fragment_main;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.simulatorz.R;
import com.example.simulatorz.view.fragment_event.MainEventFragment;

public class MainFragment extends Fragment implements MainEventFragment.Callback {

    private Callback callback;

    private View root;

    private TopMenu topMenu;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (getParentFragment() instanceof Callback) {
            callback = (Callback) getParentFragment();
        } else {
            throw new ClassCastException();
        }
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        root = inflater.inflate(R.layout.fragment_main, container, false);

        init();

        return root;
    }

    private void init() {
        topMenu = new TopMenu(getChildFragmentManager(), root, getContext());

        root.findViewById(R.id.last_move_info).setOnClickListener(view -> topMenu.showEventsFragment());
        root.findViewById(R.id.survivors).setOnClickListener(view -> topMenu.showSurvivorsFragment());
        root.findViewById(R.id.improvements).setOnClickListener(view -> topMenu.showImprovementsFragment());

        topMenu.showEventsFragment();
        showMainEventFragment();
    }

    private void showMainEventFragment() {
        getChildFragmentManager()
                .beginTransaction()
                .replace(R.id.bottom_container, MainEventFragment.newInstance())
                .commit();
    }

    @Override
    public void afterNextMove() {
        topMenu.updateCurrentFragment();
        showMainEventFragment();
        callback.afterNextMove();
    }

    public interface Callback {

        void afterNextMove();

    }

}
