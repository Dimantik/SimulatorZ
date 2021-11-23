package com.example.simulatorz.view.fragment_survivors;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simulatorz.R;
import com.example.simulatorz.game.model.survivors.category.Survivors;

public class SurvivorsKindHolder extends RecyclerView.ViewHolder {

    private TextView survivorKind;
    private TextView quantity;

    private Survivors survivors;

    public SurvivorsKindHolder(@NonNull View itemView) {
        super(itemView);

        survivorKind = itemView.findViewById(R.id.survivors_kind);
        quantity = itemView.findViewById(R.id.quantity);
    }

    void onBind(Survivors survivors, boolean isLast) {
        this.survivors = survivors;

        survivorKind.setText(survivors.getName());
        quantity.setText(Integer.toString(survivors.getQuantity()));

        if (isLast) {
            itemView.findViewById(R.id.bottom_line).setVisibility(View.INVISIBLE);
        } else {
            itemView.findViewById(R.id.bottom_line).setVisibility(View.VISIBLE);
        }
    }

}
