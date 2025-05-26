package crypto_tracker;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class FormMenu {
    private JPanel mainMenuPanel;

    public FormMenu() {
        initialize();
    }
    
// Getters and Setters
    public JPanel getMenuPanel() {
        return this.mainMenuPanel;
    }
    
// Methods
    private void initialize() {
        mainMenuPanel = new JPanel();
        mainMenuPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        mainMenuPanel.setBackground(Color.BLUE);
    }
}
