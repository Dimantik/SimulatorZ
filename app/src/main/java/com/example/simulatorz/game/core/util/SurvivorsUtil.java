package com.example.simulatorz.game.core.util;

import com.example.simulatorz.game.model.survivors.category.Survivors;
import com.example.simulatorz.game.model.util.Random;

import static com.example.simulatorz.game.model.util.Random.MAX_PERCENT;
import static com.example.simulatorz.game.model.util.Random.WINNER_FIRST_ID;
import static com.example.simulatorz.game.model.util.Random.WINNER_SECOND_ID;
import static com.example.simulatorz.game.model.util.Random.WINNER_THIRD_ID;

public class SurvivorsUtil {

    public static Result die(
            Survivors survivors,
            int chanceToDie,
            int chanceToPatient,
            int chanceToGone
    ) {
        int die = 0;
        int patients = 0;
        int gone = 0;
        for (int i = 0; i < survivors.getQuantity(); i++) {
            int winnerId = Random.getOneOfManyResult(
                    chanceToDie,
                    chanceToPatient,
                    chanceToGone,
                    MAX_PERCENT - chanceToDie - chanceToPatient - chanceToGone
            );

            if (winnerId == WINNER_FIRST_ID) {
                die++;
            }

            if (winnerId == WINNER_SECOND_ID) {
                patients++;
            }

            if (winnerId == WINNER_THIRD_ID) {
                gone++;
            }
        }

        survivors.reduceQuantity(die);
        survivors.increasePatientsQuantity(patients);
        survivors.increaseGoneQuantity(gone);

        return new Result(die, patients, gone, 0);
    }

    public static  class Result {

        int goneQuantity;
        int dieQuantity;
        int patientQuantity;
        int backQuantity;

        public Result(
                int goneQuantity,
                int dieQuantity,
                int patientQuantity,
                int backQuantity
        ) {
            this.goneQuantity = goneQuantity;
            this.dieQuantity = dieQuantity;
            this.patientQuantity = patientQuantity;
            this.backQuantity = backQuantity;
        }

        public int getGoneQuantity() {
            return goneQuantity;
        }

        public int getDieQuantity() {
            return dieQuantity;
        }

        public int getPatientQuantity() {
            return patientQuantity;
        }

        public int getBackQuantity() {
            return backQuantity;
        }

    }

}
