package com.example.simulatorz.game.db;

import android.annotation.SuppressLint;
import android.content.Context;

import com.example.simulatorz.game.model.GameModel;

public class GameManager {

    private static final String GAME_FILE = "game_file.txt";

    @SuppressLint("StaticFieldLeak")
    private static GameManager gameManager;

    private final Context context;
    private GameModel gameModel;

    private GameManager(Context context) {
        this.context = context;
    }

    public static void init(Context context) {
        if (gameManager == null) {
            gameManager = new GameManager(context);
        }
    }

    public static GameManager getInstance() {
        return gameManager;
    }

    public GameModel getGameModel() {
        return gameModel;
    }

    public boolean continueGame() {
        gameModel = (GameModel) Saver.loadObject(context, GAME_FILE);

        return gameModel != null;
    }

    public void startNewGame() {
        gameModel = GameGenerator.generate();
        Saver.saveObject(context, gameModel, GAME_FILE);
    }

    public void deleteCurrentGame() {
        Saver.deleteObject(context, GAME_FILE);
        gameModel = null;
    }

}
