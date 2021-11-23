package com.example.simulatorz.view.fragment_event;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.simulatorz.R;
import com.example.simulatorz.game.interfaces.GameInterface;
import com.example.simulatorz.game.model.events.Event;
import com.example.simulatorz.game.model.events.category.GameOverEvent;

import static com.example.simulatorz.game.interfaces.GameInterface.nextMove;


public class MainEventFragment extends Fragment {

    private Callback callback;

    private View root;
    private TextView info;
    private View actionsRoot;
    private View nextMoveRoot;

    public static MainEventFragment newInstance() {
        return new MainEventFragment();
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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_main_event, container, false);
        init();
        updateMainEvent();
        return root;
    }

    private void init() {
        info = root.findViewById(R.id.info);
        actionsRoot = root.findViewById(R.id.actions_root);
        nextMoveRoot = root.findViewById(R.id.next_move_root);

        root.findViewById(R.id.left_action).setOnClickListener(view -> leftAction());
        root.findViewById(R.id.right_action).setOnClickListener(view -> rightAction());
        root.findViewById(R.id.next_move).setOnClickListener(view -> nextMove());
    }

    private void nextMove() {
        GameInterface.nextMove();
        callback.afterNextMove();
        updateMainEvent();
    }

    private void leftAction() {
        GameInterface.executeLeftAction();
        updateMainEvent();
    }

    private void rightAction() {
        GameInterface.executeRightAction();
        updateMainEvent();
    }

    private void updateMainEvent() {
        Event event = GameInterface.getCurrentEvent();

        info.setText(event.getInfo(getContext()));

        if (event.isResultEvent()) {
            actionsRoot.setVisibility(View.GONE);
            nextMoveRoot.setVisibility(View.VISIBLE);
        } else if (event instanceof GameOverEvent) {
            actionsRoot.setVisibility(View.GONE);
            nextMoveRoot.setVisibility(View.GONE);
        }
    }

    public interface Callback {

        void afterNextMove();

    }

}