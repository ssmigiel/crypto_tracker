package crypto_tracker;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainWindow {
    private System system;
    private JFrame frame;
    private int width;
    private int length;

    private MainMenu mainMenu;
    private FormCurrencies currenciesForm;

    public MainWindow(System system, int width, int length) {
        this.system = system;
        this.width = width;
        this.length = length;

        initialize();
    }
    
// Getters and Setters
    public int getWidth() {
        return this.width;
    }

    public int getLength() {
        return this.length;
    }
    
// Methods
    private void initialize() {
        frame = new JFrame();
        this.frame.setTitle("Crypto tracker");
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.frame.setSize(this.width, this.length);
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);

        mainMenu = new MainMenu();
        this.frame.add(this.mainMenu.getMainMenuPanel(), BorderLayout.EAST);

        currenciesForm = new FormCurrencies(this.system.getCurrencies());
        this.frame.add(this.currenciesForm.getCurrenciesForm(), BorderLayout.CENTER);
    }
}
