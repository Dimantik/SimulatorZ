package com.example.simulatorz.game.settings;

public class SurvivorsSettings {

    public static final class CooksSettings {

        public static final String NAME = "Повары";
        public static final int POWER = 5;
        public static final double REDUCE_MULTIPLIER = 0.8;
        public static final double MIN_REQUIRED_FOOD_BY_ONE_SURVIVOR_PER_MOVE = 0.4;
        public static final double MAX_REQUIRED_FOOD_BY_ONE_SURVIVOR_PER_MOVE = 0.5;
        public static final int MIN_CHANCE_TO_SPOIL_FOOD = 5;
        public static final int INCREASE_MIN_CHANCE_TO_SPOIL_FOOD = 1;
        public static final int REQUIRED_FOOD_TO_INCREASE_CHANCE_TO_SPOIL_FOOD = 100;
        public static final double REDUCE_FOOD_IS_SPOIL = 0.9;
        public static final int CHANCE_TO_POISONED = 5;
        public static final double REDUCE_AUTHORITY_IF_POISONED_ONE_SURVIVOR = 1.0;

    }

    public static final class FarmersSettings {

        public static final String NAME = "Фермеры";
        public static final int MIN_GROWN_FOOD_BY_ONE_FARMER = 5;
        public static final int MAX_GROWN_FOOD_BY_ONE_FARMER = 10;
        public static final int[] NO_GROWN_FOOD_MONTHS = {10, 11, 12, 1, 2, 3, 4, 5};
        public static final int CHANE_TO_DROUGHT = 20;
        public static final int CHANCE_TO_HURRICANE = 20;
        public static final double REDUCE_GROWN_FOOD_IF_HURRICANE = 0.8;
        public static final double REDUCE_GROWN_FOOD_IF_DROUGHT = 0.4;

    }

    public static final class FishersSettings {

        public static final String NAME = "Рыбаки";
        public static final int MIN_CAUGHT_FISH_BY_ONE_FISHER = 3;
        public static final int MAX_CAUGHT_FISH_BY_ONE_FISHER = 6;
        public static final int[] FEW_FOOD_EXTRACTION_MONTHS = {11, 12, 1, 2, 3};
        public static final int[] MUCH_FOOD_EXTRACTION_MONTHS = {4, 5, 6, 7, 8, 9, 10};
        public static final double FEW_FOOD_EXTRACTION_MULTIPLIER = 0.6;
        public static final double MUCH_FOOD_EXTRACTION_MULTIPLIER = 1.0;
        public static final int CHANCE_TO_DIE = 2;
        public static final int CHANCE_TO_PATIENT = 5;
        public static final int CHANCE_TO_GONE = 10;

    }

    public static final class HuntersSettings {

        public static final String NAME = "Охотники";
        public static final int MIN_EXTRACTED_FOOD_BY_ONE_HUNTER = 3;
        public static final int MAX_EXTRACTED_FOOD_BY_ONE_HUNTER = 6;
        public static final int[] FEW_FOOD_EXTRACTION_MONTHS = {11, 12, 1, 2, 3};
        public static final int[] MUCH_FOOD_EXTRACTION_MONTHS = {4, 5, 6, 7, 8, 9, 10};
        public static final double FEW_FOOD_EXTRACTION_MULTIPLIER = 0.8;
        public static final double MUCH_FOOD_EXTRACTION_MULTIPLIER = 1.0;
        public static final int CHANCE_TO_DIE = 5;
        public static final int CHANCE_TO_PATIENT = 10;
        public static final int CHANCE_TO_GONE = 10;

    }

    public static final class ForestersSettings {

        public static final String NAME = "Рейнджеры";
        public static final int MIN_EXTRACTED_FOOD_BY_ONE_FORESTER = 1;
        public static final int MAX_EXTRACTED_FOOD_BY_ONE_FORESTER = 2;
        public static final int[] NO_FOOD_EXTRACTION_MONTHS = {11, 12, 1, 2, 3};
        public static final int[] FEW_FOOD_EXTRACTION_MONTHS = {4, 5, 6, 7};
        public static final int[] MUCH_FOOD_EXTRACTION_MONTHS = {8, 9, 10};
        public static final double FEW_FOOD_EXTRACTION_MULTIPLIER = 0.4;
        public static final double MUCH_FOOD_EXTRACTION_MULTIPLIER = 1.0;
        public static final int CHANCE_TO_DIE = 5;
        public static final int CHANCE_TO_PATIENT = 10;
        public static final int CHANCE_TO_GONE = 10;

    }

    public static final class DoctorsSettings {

        public static final String NAME = "Докторы";
        public static final int POWER = 5;

    }

    public static final class FightersSettings {

        public static final String NAME = "Бойцы";
        public static final int POWER = 2;
        public static final double LOAD_CAPACITY = 5;
        public static final int CHANE_TO_FIND_SMALL_FOOD_SUPPLIES = 30;
        public static final int CHANE_TO_FIND_MEDIUM_FOOD_SUPPLIES = 10;
        public static final int CHANE_TO_FIND_LARGE_FOOD_SUPPLIES = 5;
        public static final int CHANCE_TO_DIE = 20;
        public static final int CHANCE_TO_PATIENT = 10;
        public static final int CHANCE_TO_GONE = 30;
        public static final double MIN_SMALL_FOOD_SUPPLIES = 5;
        public static final double MAX_SMALL_FOOD_SUPPLIES = 10;
        public static final double MIN_MEDIUM_FOOD_SUPPLIES = 10;
        public static final double MAX_MEDIUM_FOOD_SUPPLIES = 20;
        public static final double MIN_LARGE_FOOD_SUPPLIES = 30;
        public static final double MAX_LARGE_FOOD_SUPPLIES = 50;

    }

    public static final class ScoutsSettings {

        public static final String NAME = "Разведчики";

    }

    public static final class RecruitersSettings {

        public static final String NAME = "Рекрутеры";
        public static final double POWER = 10.0;
        public static final double REQUIRED_PERCENT_PER_ONE_SURVIVOR = 20.0;
        public static final int CHANCE_TO_DIE = 20;
        public static final int CHANCE_TO_PATIENT = 10;
        public static final int CHANCE_TO_GONE = 30;

        public static final int CHANCE_TO_RECRUITING_FIGHTERS = 30;
        public static final int CHANCE_TO_RECRUITING_FARMERS = 20;
        public static final int CHANCE_TO_RECRUITING_FISHERS = 20;
        public static final int CHANCE_TO_RECRUITING_FORESTERS = 15;
        public static final int CHANCE_TO_RECRUITING_HUNTERS = 15;
        public static final int CHANCE_TO_RECRUITING_COOKS = 10;
        public static final int CHANCE_TO_RECRUITING_DOCTORS = 5;
        public static final int CHANCE_TO_RECRUITING_SCOUTS = 5;
        public static final int CHANCE_TO_RECRUITING_RECRUITERS = 5;

    }


}
