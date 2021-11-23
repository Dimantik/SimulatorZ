package com.example.simulatorz.view.fragment_menu;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.simulatorz.R;
import com.example.simulatorz.game.db.GameManager;

public class MenuFragment extends Fragment {

    private Callback callback;
    private View root;

    public static MenuFragment newInstance() {
        return new MenuFragment();
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
        root = inflater.inflate(R.layout.fragment_menu, container, false);
        init();
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (GameManager.getInstance().continueGame()) {
            root.findViewById(R.id.continue_game).setVisibility(View.VISIBLE);
        } else {
            root.findViewById(R.id.continue_game).setVisibility(View.INVISIBLE);
        }
    }

    private void init() {
        root.findViewById(R.id.continue_game).setOnClickListener(view -> continueGame());
        root.findViewById(R.id.new_game).setOnClickListener(view -> newGame());
        root.findViewById(R.id.scores).setOnClickListener(view -> scores());
    }

    private void continueGame() {
        callback.play();
    }

    private void newGame() {
        GameManager.getInstance().startNewGame();
        callback.play();
    }

    private void scores() {

    }

    public interface Callback {

        public void play();
        public void showScores();

    }

}