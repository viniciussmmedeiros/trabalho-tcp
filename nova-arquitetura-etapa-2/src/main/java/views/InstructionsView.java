package views;

import javax.swing.*;

public class InstructionsView extends JPanel {
    // Properties
    private final String instructionsMapping[][] = {
            { "(letra A)", "Nota Lá" },
            { "(Letra B)", "Nota Si" },
            { "(Letra C)", "Nota Dó" },
            { "(Letra D)", "Nota Ré" },
            { "(Letra E)", "Nota Mi" },
            { "(Letra F)", "Nota Fá" },
            { "(Letra G)", "Nota Sol" },
            { "(Letras a,b,c,d,e,f,g) ",
                    "Se caractere anterior era NOTA (A a G), repete nota; Caso contrário, Silêncio ou pausa" },
            { "Caractere Espaço",
                    "Aumenta volume para o DOBRO do volume; Se não puder aumentar, volta ao volume default (de início)" },
            { "Caractere !", "Trocar instrumento para o instrumento General MIDI #114 (Agogo)" },
            { "Qualquer outra letra vogal (O ou o, I ou i , U ou u)",
                    "Trocar instrumento para o instrumento General MIDI #7 (Harpsichord)" },
            { "Qualquer outra letra consoant (todas consoantes exceto as que são notas)",
                    "Se caractere anterior era NOTA (A a G), repete nota; Caso contrário, Silêncio ou pausa" },
            { "Dígito par ou impar Trocar instrumento para o instrumento",
                    "General MIDI cujo numero é igual ao valor do instrumento ATUAL + valor do dígito" },
            { "Caractere ? ou .", "Aumenta UMA oitava; Se não puder, aumentar, volta à oitava default (deinício)" },
            { "Caractere NL (nova linha)",
                    "Trocar instrumento para o instrumento General MIDI #15 (Tubular Bells)" },
            { "Caractere ; (ponto e vírgula)",
                    "Trocar instrumento para o instrumento General MIDI #76 (Pan Flute)" },
            { "Caractere ,", "Trocar instrumento para o instrumento General MIDI #20 (Church Organ)" },
            { "ELSE", "Se caractere anterior era NOTA (A a G), repete nota; Caso contrário, Silêncio ou pausa" },
    };

    private final String instructionsMappingColunns[] = { "Texto", "Informação Musical ou Ação" };

    // Init
    public InstructionsView() {
        super();
        setupView();
    }

    // Setup
    private void setupView() {
        JTable mappingTableView = new JTable(instructionsMapping, instructionsMappingColunns);
        mappingTableView.setBounds(30, 40, 200, 300);
        JScrollPane instructionsScrollView = new JScrollPane(mappingTableView);
        add(instructionsScrollView);
    }
}
