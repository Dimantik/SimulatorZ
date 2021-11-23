package com.example.simulatorz.view.fragment_reports;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simulatorz.R;
import com.example.simulatorz.game.model.reports.Report;

import java.util.List;

public class ReportsAdapter extends RecyclerView.Adapter<ReportHolder> {

    private final List<Report> reportList;

    public ReportsAdapter(List<Report> reportList) {
        this.reportList = reportList;
    }

    @NonNull
    @Override
    public ReportHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ReportHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_simple_event, parent, false), parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull ReportHolder holder, int position) {
        holder.onBind(reportList.get(position), position == reportList.size() - 1);
    }

    @Override
    public int getItemCount() {
        return reportList.size();
    }
}
