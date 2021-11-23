package com.example.simulatorz.view.fragment_indicators;

import android.view.View;
import android.widget.TextView;

import com.example.simulatorz.R;
import com.example.simulatorz.game.interfaces.GameInterface;

public class IndicatorsManager {

    private static final String[] months = {
            "Январь", "Февраль", "Март",
            "Апрель", "Май", "Июнь",
            "Июль", "Август", "Сентябрь",
            "Октябрь", "Ноябрь", " Декабрь"
    };

    private final View root;

    private TextView currentMove;
    private TextView authority;
    private TextView food;
    private TextView protection;
    private TextView currentMonth;

    public IndicatorsManager(View root) {
        this.root = root;
        init();
    }

    private void init() {
        currentMove = root.findViewById(R.id.current_move);
        authority = root.findViewById(R.id.authority);
        food = root.findViewById(R.id.food);
        protection = root.findViewById(R.id.protection);
        currentMonth = root.findViewById(R.id.current_month);
    }


    void updateIndicators() {
        currentMove.setText(Integer.toString(GameInterface.getCurrentMove()));
        authority.setText(GameInterface.getAuthority() + "%");
        currentMonth.setText(months[GameInterface.getCurrentMonth() - 1]);
        protection.setText(Integer.toString((int) GameInterface.getProtection()));
        food.setText(Integer.toString((int) GameInterface.getFood()));
    }


}
