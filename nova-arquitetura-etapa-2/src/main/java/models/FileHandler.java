package models;

import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;
import views.InterfaceView;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileHandler {

    public void openFile(InterfaceView rootView) {
        FileDialog chooseFileDialog = new FileDialog(rootView, "Choose a file", FileDialog.LOAD);
        chooseFileDialog.setDirectory("C:\\");
        chooseFileDialog.setFile("*.txt"); // abordagem para Windows
        chooseFileDialog.setFilenameFilter((dir, name) -> name.endsWith(".txt")); // abordagem para MacOS
        chooseFileDialog.setVisible(true);
        String filename = chooseFileDialog.getFile();

        if (filename != null) {
            try {
                final String pathName = chooseFileDialog.getDirectory() + filename;
                final File file = new File(pathName);
                final String textRegexPattern = "\\Z";

                String contentFromFile = new Scanner(file).useDelimiter(textRegexPattern).next();

                rootView.playerTab.musicTextInput.append(contentFromFile);
                rootView.playerTab.setMessageArea("File read successfully.");
            } catch (FileNotFoundException error) {
                System.out.println(error.getMessage());
            }
        }
    }

    public void saveInFile(JTextArea musicTextInput, InterfaceView rootView) {
        try {
            FileDialog saveFileDialog = new FileDialog(rootView, "Save", FileDialog.SAVE);
            saveFileDialog.setVisible(true);
            String path = saveFileDialog.getDirectory() + saveFileDialog.getFile() + ".mid";
            File file = new File(path);

            String fileName = saveFileDialog.getFile();

            if(fileName != null) {
                MusicInputHandler generatorResponse = new MusicInputHandler(musicTextInput.getText());
                String textMusic = generatorResponse.textProcessing();
                Pattern output = new Pattern(textMusic);

                MidiFileManager.savePatternToMidi(output, file);
                rootView.playerTab.setMessageArea("File " + fileName + ".mid was saved successfully.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
