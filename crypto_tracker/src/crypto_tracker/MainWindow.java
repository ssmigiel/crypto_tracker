package crypto_tracker;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainWindow {
    private JFrame frame;
    private int width;
    private int length;

    private MainMenu mainMenu;

    public MainWindow(int width, int length) {
        this.width = width;
        this.length = length;

        initialize();
    }

    public int getWidth() {
        return this.width;
    }

    public int getLength() {
        return this.length;
    }

    private void initialize() {
        frame = new JFrame();
        this.frame.setTitle("Crypto tracker");
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.frame.setSize(this.width, this.length);
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);

        mainMenu = new MainMenu();
        this.frame.add(this.mainMenu.getMainMenuPanel(), BorderLayout.EAST);
    }
}
