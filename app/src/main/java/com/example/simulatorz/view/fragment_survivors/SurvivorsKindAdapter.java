package com.example.simulatorz.view.fragment_survivors;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simulatorz.R;
import com.example.simulatorz.game.model.survivors.category.Survivors;

import java.util.List;

public class SurvivorsKindAdapter extends RecyclerView.Adapter<SurvivorsKindHolder> {

    private final List<Survivors> survivorsList;

    public SurvivorsKindAdapter(List<Survivors> survivorsList) {
        this.survivorsList = survivorsList;
    }

    @NonNull
    @Override
    public SurvivorsKindHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SurvivorsKindHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_survivors_kind, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SurvivorsKindHolder holder, int position) {
        holder.onBind(survivorsList.get(position), position == survivorsList.size() - 1);
    }

    @Override
    public int getItemCount() {
        return survivorsList.size();
    }
}
