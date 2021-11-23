package com.example.simulatorz.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.simulatorz.R;
import com.example.simulatorz.view.fragment_indicators.IndicatorsFragment;
import com.example.simulatorz.view.fragment_menu.MenuFragment;

public class RootActivity extends AppCompatActivity implements
        MenuFragment.Callback,
        IndicatorsFragment.Callback
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        openMenu();
    }

    @Override
    public void openMenu() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, MenuFragment.newInstance())
                .commit();
    }

    @Override
    public void play() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, IndicatorsFragment.newInstance())
                .commit();
    }

    @Override
    public void showScores() {

    }

}