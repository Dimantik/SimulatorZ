package com.example.simulatorz.view.fragment_reports;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simulatorz.R;
import com.example.simulatorz.game.model.reports.Report;

public class ReportHolder extends RecyclerView.ViewHolder {

    private final Context context;
    private final TextView eventText;

    public ReportHolder(@NonNull View itemView, Context context) {
        super(itemView);

        this.context = context;
        eventText = itemView.findViewById(R.id.info);
    }

    void onBind(Report report, boolean isLast) {
        eventText.setText(report.getInfo(context));

        if (isLast) {
            itemView.findViewById(R.id.bottom_line).setVisibility(View.INVISIBLE);
        } else {
            itemView.findViewById(R.id.bottom_line).setVisibility(View.VISIBLE);
        }
    }

}
