package views;

import javax.swing.*;

public class InterfaceView extends JFrame {
    // Properties
    JTabbedPane tabbedPaneContainer;
    public PlayerView playerTab = new PlayerView();
    JPanel instructionsTab = new JPanel();
    JPanel aboutTab = new JPanel();

    // Init
    public InterfaceView() {
        super("Music Generator");
        setupView();
    }

    // Setup
    private void setupView() {
        setSize(500, 500);
        setLocation(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);

        tabbedPaneContainer = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);
        tabbedPaneContainer.addTab("Generator", playerTab);
        tabbedPaneContainer.addTab("Instructions", instructionsTab);
        tabbedPaneContainer.addTab("About", aboutTab);

        getContentPane().add(tabbedPaneContainer);

        setVisible(true);
    }

}
