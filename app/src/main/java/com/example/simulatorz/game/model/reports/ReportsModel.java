package com.example.simulatorz.game.model.reports;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ReportsModel implements Serializable {

    private List<Report> reportList;

    public ReportsModel() {
        this.reportList = new ArrayList<>();
    }

    public void addReport(Report report) {
        reportList.add(report);
    }


    public void clearReportList() {
        reportList = new ArrayList<>();
    }

    public List<Report> getReportList() {
        return reportList;
    }

}
