package com.example.simulatorz.game.core.survivors_cores;

import com.example.simulatorz.R;
import com.example.simulatorz.game.core.util.SurvivorsUtil;
import com.example.simulatorz.game.model.GameModel;
import com.example.simulatorz.game.model.events.Event;
import com.example.simulatorz.game.model.reports.Report;
import com.example.simulatorz.game.model.survivors.category.Cooks;
import com.example.simulatorz.game.model.survivors.category.Doctors;
import com.example.simulatorz.game.model.survivors.category.Farmers;
import com.example.simulatorz.game.model.survivors.category.Fighters;
import com.example.simulatorz.game.model.survivors.category.Fishers;
import com.example.simulatorz.game.model.survivors.category.Foresters;
import com.example.simulatorz.game.model.survivors.category.Hunters;
import com.example.simulatorz.game.model.survivors.category.Recruiters;
import com.example.simulatorz.game.model.survivors.category.Survivors;
import com.example.simulatorz.game.model.util.InfoPart;
import com.example.simulatorz.game.model.util.Random;

import java.util.ArrayList;
import java.util.List;

import static com.example.simulatorz.game.settings.SurvivorsSettings.RecruitersSettings.*;

public class RecruitersCore {

    public static Event execute(GameModel gameModel) {
        if (gameModel.getPopulationModel().getRecruiters().getQuantity() == 0) {
            return null;
        }

        die(gameModel);

        if (gameModel.getPopulationModel().getForesters().getQuantity() == 0) {
            return null;
        }

        //return recruiting();

        return null;
    }

    private static Event recruiting(GameModel gameModel) {
        boolean isRecruiting = Random.isWin((int) gameModel.getPopulationModel().getRecruiters().getRecruitingProgress());

        if (isRecruiting) {
            int recruitingQuantity = Random.getRandomNumber((int) gameModel.getPopulationModel().getRecruiters().getRecruitingProgress() / (int) REQUIRED_PERCENT_PER_ONE_SURVIVOR);
            List<Survivors> recruitingSurvivorsList = new ArrayList<>();

            while (recruitingQuantity != 0) {
                int index = Random.getRandomNumber(recruitingSurvivorsList.size() - 2);
                boolean isWin = false;

                if (recruitingSurvivorsList.get(index) instanceof Fighters) {
                    isWin = Random.isWin(CHANCE_TO_RECRUITING_FIGHTERS);
                } else if (recruitingSurvivorsList.get(index) instanceof Cooks) {
                    isWin = Random.isWin(CHANCE_TO_RECRUITING_COOKS);
                } else if (recruitingSurvivorsList.get(index) instanceof Doctors) {
                    isWin = Random.isWin(CHANCE_TO_RECRUITING_DOCTORS);
                } else if (recruitingSurvivorsList.get(index) instanceof Farmers) {
                    isWin = Random.isWin(CHANCE_TO_RECRUITING_FARMERS);
                } else if (recruitingSurvivorsList.get(index) instanceof Foresters) {
                    isWin = Random.isWin(CHANCE_TO_RECRUITING_FORESTERS);
                } else if (recruitingSurvivorsList.get(index) instanceof Fishers) {
                    isWin = Random.isWin(CHANCE_TO_RECRUITING_FIGHTERS);
                } else if (recruitingSurvivorsList.get(index) instanceof Hunters) {
                    isWin = Random.isWin(CHANCE_TO_RECRUITING_HUNTERS);
                } else if (recruitingSurvivorsList.get(index) instanceof Recruiters) {
                    isWin = Random.isWin(CHANCE_TO_RECRUITING_RECRUITERS);
                }

                if (isWin) {
                    recruitingSurvivorsList.get(index).increaseQuantity(1);
                    recruitingQuantity--;
                }
            }



        }

        return null;
    }

    private static List<Survivors> generateEmptySurvivorsList() {
        List<Survivors> recruitingSurvivorsList = new ArrayList<>();

        recruitingSurvivorsList.add(new Fighters(23));
        recruitingSurvivorsList.add(new Cooks(1));
        recruitingSurvivorsList.add(new Doctors(3));
        recruitingSurvivorsList.add(new Farmers(14));
        recruitingSurvivorsList.add(new Fishers(2));
        recruitingSurvivorsList.add(new Foresters(3));
        recruitingSurvivorsList.add(new Hunters(6));
        recruitingSurvivorsList.add(new Recruiters(1));

        return recruitingSurvivorsList;
    }

    private static void die(GameModel gameModel) {
        SurvivorsUtil.Result result = SurvivorsUtil.die(
                gameModel.getPopulationModel().getRecruiters(),
                CHANCE_TO_DIE,
                CHANCE_TO_PATIENT,
                CHANCE_TO_GONE
        );

        if (result.getDieQuantity() != 0) {
            gameModel.getPopulationModel().getRecruiters().reduceQuantity(result.getDieQuantity());
            gameModel.getReportsModel().addReport(new Report(new InfoPart(R.string.recruiters_die_several, result.getDieQuantity())));
        }

        if (result.getPatientQuantity() != 0) {
            gameModel.getPopulationModel().getRecruiters().increasePatientsQuantity(result.getPatientQuantity());
            gameModel.getReportsModel().addReport(new Report(new InfoPart(R.string.recruiters_wounded_several, result.getPatientQuantity())));
        }

        if (result.getGoneQuantity() != 0) {
            gameModel.getPopulationModel().getRecruiters().increasePatientsQuantity(result.getGoneQuantity());
            gameModel.getReportsModel().addReport(new Report(new InfoPart(R.string.recruiters_gone_several, result.getGoneQuantity())));
        }


        if (result.getBackQuantity() != 0) {
            gameModel.getPopulationModel().getRecruiters().reduceGoneQuantity(result.getBackQuantity());
            gameModel.getReportsModel().addReport(new Report(new InfoPart(R.string.recruiters_back_several, result.getBackQuantity())));
        }
    }

}
