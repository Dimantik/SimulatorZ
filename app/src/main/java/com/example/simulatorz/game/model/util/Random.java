package com.example.simulatorz.game.model.util;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Random {

    public static final int MAX_PERCENT = 100;
    public static final int MIN_PERCENT = 1;

    public static final int WINNER_FIRST_ID = 1;
    public static final int WINNER_SECOND_ID = 2;
    public static final int WINNER_THIRD_ID = 3;
    public static final int WINNER_FOURTH_ID = 4;
    public static final int DEFAULT_WINNER_ID = 0;

    public static int getRandomNumber(int max) {
        return  (int)((Math.random() * max) + 1);
    }

    public static int getRandomNumber(int min, int max) {
        int different = max - min;
        return min + getRandomNumber(different);
    }

    public static double getRandomNumber(double max) {
        return  (int)((Math.random() * max) + 1);
    }

    public static double getRandomNumber(double min, double max) {
        double different = max - min;
        return min + getRandomNumber(different);
    }

    public static int getOneOfManyResult(int ... percentages) {
        int random = (int)((Math.random() * MAX_PERCENT) + 1);

        List<Result> resultList = new ArrayList<>();

        int lastPercentage = 0;

        for (int i = 0; i < percentages.length; i++) {
            if (i == 0) {
                resultList.add(new Result(i + 1, MIN_PERCENT, percentages[i]));
                lastPercentage = percentages[i];
            } else if (i == percentages.length - 1) {
                resultList.add(new Result(i + 1, lastPercentage + 1, MAX_PERCENT));
            } else {
                resultList.add(new Result(i + 1, lastPercentage + 1, lastPercentage + percentages[i]));
                lastPercentage += percentages[i];
            }
        }

        ResultList results = new ResultList(resultList);

        return results.getWinner(random);
    }

    public static boolean isWin(int percentage) {
        int random = (int)((Math.random() * 100) + 1);
        return random <= percentage;
    }

    public static class Result {

        private final int id;
        private final int start;
        private final int end;

        public Result(int id, int start, int end) {
            Log.i("RAND", "WINNER ID: " + id + " {" + start + ", " + end + "}");
            this.id = id;
            this.start = start;
            this.end = end;
        }

        public boolean isSuccess(int result) {
            return result >= start && end >= result;
        }

        public int getId() {
            return id;
        }

    }

    public static class ResultList {

        private final List<Result> resultList;

        public ResultList(List<Result> resultList) {
            this.resultList = resultList;
        }

        public int getWinner(int random) {
            for (Result result : resultList) {
                if (result.isSuccess(random)) {
                    Log.i("RAND", "WIN: " + result.getId());
                    return result.getId();
                }
            }

            return 0;
        }
    }

}
