package com.example.simulatorz.game.core.survivors_cores;

import com.example.simulatorz.R;
import com.example.simulatorz.game.model.GameModel;
import com.example.simulatorz.game.model.events.Event;
import com.example.simulatorz.game.model.reports.Report;
import com.example.simulatorz.game.model.survivors.category.Survivors;
import com.example.simulatorz.game.model.util.InfoPart;
import com.example.simulatorz.game.settings.SurvivorsSettings;
import com.example.simulatorz.game.model.util.Random;

import java.util.ArrayList;
import java.util.List;

public class DoctorsCore {

    public static Event execute(GameModel gameModel) {
        if (!gameModel.getPopulationModel().isExistPatients()) {
            return null;
        }

        int doctorsPower = gameModel.getPopulationModel().getDoctors().getQuantity()
                * SurvivorsSettings.DoctorsSettings.POWER
                - gameModel.getPopulationModel().getDoctors().getPatientsQuantity();

        List<Survivors> patientSurvivorsList = new ArrayList<>();

        for (Survivors survivors : gameModel.getPopulationModel().getSurvivorsList()) {
            if (survivors.getPatientsQuantity() != 0) {
                patientSurvivorsList.add(survivors);
            }
        }

        Result result = heal(patientSurvivorsList, doctorsPower);

        Report report;

        if (gameModel.getPopulationModel().getDoctors().getQuantity() == 0) {
            report = new Report(new InfoPart(R.string.doctors_no_doctors_dead_all, result.getHealedQuantity()));

            for (Survivors survivors : result.getPatientSurvivorsList()) {
                report.addInfoPart(new InfoPart(survivors.getNameWithQuantity(), survivors.deadPatients()));
            }
        } else if (result.getDeadQuantity() == 0) {
            report = new Report(new InfoPart(R.string.doctors_heal_all, result.getHealedQuantity()));
        } else {
            report = new Report(new InfoPart(R.string.doctors_heal_not_all, result.getHealedQuantity()));

            for (Survivors survivors : result.getPatientSurvivorsList()) {
                report.addInfoPart(new InfoPart(survivors.getNameWithQuantity(), survivors.deadPatients()));
            }
        }

        gameModel.getReportsModel().addReport(report);

        return null;
    }

    private static Result heal(List<Survivors> patientSurvivorsList, int doctorsPower) {
        Result result = new Result();

        while (doctorsPower != 0 && patientSurvivorsList.size() != 0) {
            int index = Random.getRandomNumber(patientSurvivorsList.size() - 2);
            patientSurvivorsList.get(index).healOnePatient();
            doctorsPower--;
            result.increaseHealedQuantity();
            if (patientSurvivorsList.get(index).getPatientsQuantity() == 0) {
                patientSurvivorsList.remove(index);
            }
        }

        for (Survivors survivors : patientSurvivorsList) {
            result.increaseDeadQuantity(survivors.getPatientsQuantity());
        }

        result.setPatientSurvivorsList(patientSurvivorsList);

        return result;
    }


    private static class Result {

        private int healedQuantity;
        private int deadQuantity;
        private List<Survivors> patientSurvivorsList;

        public int getHealedQuantity() {
            return healedQuantity;
        }

        public int getDeadQuantity() {
            return deadQuantity;
        }

        public void increaseDeadQuantity(int deadQuantity) {
            this.deadQuantity += deadQuantity;
        }

        void increaseHealedQuantity() {
            this.healedQuantity++;
        }

        public void setPatientSurvivorsList(List<Survivors> patientSurvivorsList) {
            this.patientSurvivorsList = patientSurvivorsList;
        }

        public List<Survivors> getPatientSurvivorsList() {
            return patientSurvivorsList;
        }

    }

}
