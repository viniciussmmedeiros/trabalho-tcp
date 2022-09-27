package controller;

import views.InterfaceView;
import models.GenerateMusicResponse;

public class InterfaceController {

    public static void main(String[] args) {
        InterfaceView rootView = new InterfaceView();
        rootView.playerTab.playMusicButton
            .addActionListener(click -> playMusic(rootView.playerTab.musicTextInput.getText()));
    }

    public static void playMusic(String text) {
        GenerateMusicResponse generatorResponse = new GenerateMusicResponse(text);
        generatorResponse.textProcessing();
    }
}
