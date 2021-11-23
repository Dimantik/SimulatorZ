package com.example.simulatorz.view.fragment_main;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.simulatorz.R;
import com.example.simulatorz.game.interfaces.GameInterface;
import com.example.simulatorz.view.fragment_reports.ReportsFragment;
import com.example.simulatorz.view.fragment_improvements.ImprovementsFragment;
import com.example.simulatorz.view.fragment_survivors.SurvivorsFragment;

public class TopMenu {

    private final FragmentManager fm;
    private final View root;
    private final Context context;

    private final TextView currentTitle;
    private Fragment currentFragment;

    private ReportsFragment reportsFragment;
    private SurvivorsFragment survivorsFragment;
    private ImprovementsFragment improvementsFragment;

    public TopMenu(
            FragmentManager fm,
            View root,
            Context context
    ) {
        this.fm = fm;
        this.root = root;
        this.context = context;
        this.currentTitle = root.findViewById(R.id.top_title);
    }

    private void changeLastIcon() {
        if (currentFragment == reportsFragment) {
            ((ImageView) root.findViewById(R.id.last_move_info)).setImageDrawable(AppCompatResources.getDrawable(context, R.drawable.menu_img_dark_events));
            (root.findViewById(R.id.last_move_info)).setBackground(AppCompatResources.getDrawable(context, R.drawable.background_light_no_stroke_with_left_bottom_round_border));
        }

        if (currentFragment == survivorsFragment) {
            ((ImageView) root.findViewById(R.id.survivors)).setImageDrawable(AppCompatResources.getDrawable(context, R.drawable.menu_img_dark_survivors));
            (root.findViewById(R.id.survivors)).setBackground(AppCompatResources.getDrawable(context, R.drawable.background_light_no_stroke));
        }

        if (currentFragment == improvementsFragment) {
            ((ImageView) root.findViewById(R.id.improvements)).setImageDrawable(AppCompatResources.getDrawable(context, R.drawable.menu_img_dark_improvements));
            (root.findViewById(R.id.improvements)).setBackground(AppCompatResources.getDrawable(context, R.drawable.background_light_no_stroke_with_right_bottom_round_border));
        }

    }

    void showEventsFragment() {
        if (reportsFragment == null) {
            reportsFragment = ReportsFragment.newInstance();
        }

        if (currentFragment == reportsFragment) {
            return;
        }

        currentTitle.setText(context.getResources().getString(R.string.last_events));

        ((ImageView) root.findViewById(R.id.last_move_info)).setImageDrawable(AppCompatResources.getDrawable(context, R.drawable.menu_img_light_events));
        (root.findViewById(R.id.last_move_info)).setBackground(AppCompatResources.getDrawable(context, R.drawable.background_dark_no_stroke_with_left_bottom_round_border));

        changeLastIcon();

        fm.beginTransaction()
                .replace(R.id.top_container, reportsFragment)
                .commit();

        currentFragment = reportsFragment;
    }

    void showSurvivorsFragment() {
        if (survivorsFragment == null) {
            survivorsFragment = SurvivorsFragment.newInstance();
        }

        if (currentFragment == survivorsFragment) {
            return;
        }

        currentTitle.setText(context.getResources().getString(R.string.survivors) + ": " + GameInterface.getCurrentPopulationSize());

        ((ImageView) root.findViewById(R.id.survivors)).setImageDrawable(AppCompatResources.getDrawable(context, R.drawable.menu_img_light_survivors));
        (root.findViewById(R.id.survivors)).setBackground(AppCompatResources.getDrawable(context, R.drawable.background_dark_no_stroke));

        changeLastIcon();

        fm.beginTransaction()
                .replace(R.id.top_container, survivorsFragment)
                .commit();

        currentFragment = survivorsFragment;
    }

    void showImprovementsFragment() {
        if (improvementsFragment == null) {
            improvementsFragment = ImprovementsFragment.newInstance();
        }

        if (currentFragment == improvementsFragment) {
            return;
        }

        currentTitle.setText(context.getResources().getString(R.string.improvements));

        ((ImageView) root.findViewById(R.id.improvements)).setImageDrawable(AppCompatResources.getDrawable(context, R.drawable.menu_img_light_improvements));
        (root.findViewById(R.id.improvements)).setBackground(AppCompatResources.getDrawable(context, R.drawable.background_dark_no_stroke_with_right_bottom_round_border));

        changeLastIcon();

        if (improvementsFragment == null) {
            improvementsFragment = ImprovementsFragment.newInstance();
        }

        fm.beginTransaction()
                .replace(R.id.top_container, improvementsFragment)
                .commit();

        currentFragment = improvementsFragment;
    }

    public void updateCurrentFragment() {
        if (currentFragment == reportsFragment) {
            reportsFragment = null;
            showEventsFragment();
            return;
        }

        if (currentFragment == survivorsFragment) {
            survivorsFragment = null;
            showSurvivorsFragment();
            return;
        }

        if (currentFragment == improvementsFragment) {
            improvementsFragment = null;
            showImprovementsFragment();
            return;
        }
    }
}
