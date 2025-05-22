package crypto_tracker;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class MainMenu {
    private JPanel mainMenuPanel;

    public MainMenu() {
        initialize();
    }

    public JPanel getMainMenuPanel() {
        return this.mainMenuPanel;
    }

    private void initialize() {
        mainMenuPanel = new JPanel();
        mainMenuPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        mainMenuPanel.setBackground(Color.BLUE);
    }
}
