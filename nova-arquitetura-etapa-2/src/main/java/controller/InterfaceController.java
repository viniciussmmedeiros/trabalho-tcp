package controller;

import views.InterfaceView;
import models.MusicInputHandler;
import models.FileHandler;

public class InterfaceController {

    final private InterfaceView rootView;
    final private FileHandler fileHandler;

    public InterfaceController() {
        rootView = new InterfaceView();
        fileHandler = new FileHandler();
        setupViewActions();
    }

    private void setupViewActions() {
        rootView.playerTab.playMusicButton
            .addActionListener(click -> playMusic(rootView.playerTab.musicTextInput.getText()));
        rootView.playerTab.openFileButton
            .addActionListener(click -> fileHandler.openFile(rootView));
        rootView.playerTab.saveInFileButton
            .addActionListener(click -> fileHandler.saveInFile(rootView.playerTab.musicTextInput, rootView));
    }

    private void playMusic(String text) {
        MusicInputHandler generatorResponse = new MusicInputHandler(text);
        generatorResponse.textProcessing();

        if(generatorResponse.getInputErrorChars().length() > 0) {
            rootView.playerTab.setMessageArea("Invalid characters: " + generatorResponse.getInputErrorChars());
        } else {
            rootView.playerTab.setMessageArea("");
        }

        generatorResponse.playTextMusic();
    }
}
