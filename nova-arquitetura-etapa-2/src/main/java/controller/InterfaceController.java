package controller;

import org.jfugue.pattern.Pattern;
import org.jfugue.midi.MidiFileManager;
import views.InterfaceView;
import models.GenerateMusicResponse;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InterfaceController {

    public static void main(String[] args) {
        InterfaceView rootView = new InterfaceView();
        rootView.playerTab.playMusicButton
            .addActionListener(click -> playMusic(rootView.playerTab.musicTextInput.getText(), rootView));
        rootView.playerTab.openFileButton
            .addActionListener(click -> openFile(rootView));
        rootView.playerTab.saveInFileButton
            .addActionListener(click -> saveInFile(rootView.playerTab.musicTextInput, rootView));
    }

    public static void playMusic(String text, InterfaceView rootView) {
        GenerateMusicResponse generatorResponse = new GenerateMusicResponse(text);
        generatorResponse.textProcessing();

        if(generatorResponse.getInputErrorChars().length() > 0) {
            rootView.playerTab.setMessageArea("Invalid characters: " + generatorResponse.getInputErrorChars());
        } else {
            rootView.playerTab.setMessageArea("");
        }

        generatorResponse.playTextMusic();
    }

    public static void openFile(InterfaceView rootView) {
        FileDialog chooseFileDialog = new FileDialog(rootView, "Choose a file", FileDialog.LOAD);
        chooseFileDialog.setDirectory("C:\\");
        chooseFileDialog.setFile("*.txt"); // abordagem para windows
        chooseFileDialog.setFilenameFilter((dir, name) -> name.endsWith(".txt")); // abordagem para mac *solução para possível bug
        chooseFileDialog.setVisible(true);
        String filename = chooseFileDialog.getFile();

        if (filename != null) {
            try {
                String content = new Scanner(new File(chooseFileDialog.getDirectory() + filename)).useDelimiter("\\Z").next();

                rootView.playerTab.musicTextInput.append(content);
                rootView.playerTab.setMessageArea("File read successfully.");
            } catch(FileNotFoundException error) {
                System.out.println(error.getMessage());
            }
        }
    }

    public static void saveInFile(JTextArea musicTextInput, InterfaceView rootView) {
        try {
            FileDialog saveFileDialog = new FileDialog(rootView, "Save", FileDialog.SAVE);
            saveFileDialog.setVisible(true);
            String path = saveFileDialog.getDirectory() + saveFileDialog.getFile() + ".mid";
            File f = new File(path);

            String file = saveFileDialog.getFile();

            if(file != null) {
                GenerateMusicResponse generatorResponse = new GenerateMusicResponse(musicTextInput.getText());
                String textMusic = generatorResponse.textProcessing();
                Pattern output = new Pattern(textMusic);

                MidiFileManager.savePatternToMidi(output, f);
                rootView.playerTab.setMessageArea("File " + f.getName() + " was saved successfully.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
