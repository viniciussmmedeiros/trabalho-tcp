package main.java.Classes;

import java.util.HashMap;
import java.util.Map;

public class ProcessingMapping {
    public Map<String, String> textMapping = new HashMap<String, String>();

    public ProcessingMapping() {

        // Key: Fragmento de string retirada do texto input
        // Value: String correspondente que é reconhecida pelo JFugue
        this.textMapping.put("A", "A");
        this.textMapping.put("B", "B");
        this.textMapping.put("C", "C");
        this.textMapping.put("D", "D");
        this.textMapping.put("E", "E");
        this.textMapping.put("F", "F");
        this.textMapping.put("G", "G");
        this.textMapping.put(" ", "R");
    }

    public String getMusicalAction(String textFragment) {
        return this.textMapping.get(textFragment);
    }
}
