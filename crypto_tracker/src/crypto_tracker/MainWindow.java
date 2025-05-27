package crypto_tracker;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainWindow {
    private MainSystem system;
    private JFrame frame;
    private int width;
    private int length;

    private MainMenu mainMenu;
    private Form activeForm;

    public MainWindow(MainSystem system, int width, int length) {
        this.system = system;
        this.width = width;
        this.length = length;

        initialize();
    }
    
// Getters and Setters
    public MainSystem getSystem() {
    	return this.system;
    }
    
    public int getWidth() {
        return this.width;
    }

    public int getLength() {
        return this.length;
    }
    
    public Form getActiveForm() {
		return activeForm;
	}

	// Methods
    private void initialize() {
        frame = new JFrame();
        this.frame.setTitle("Crypto tracker");
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.frame.setSize(this.width, this.length);
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
        
        mainMenu = new MainMenu(this);
        frame.setJMenuBar(mainMenu.getMenuBar());
    }
    
    public void setActiveForm(Form activeForm) {
    	if(this.activeForm != null) {
    		this.activeForm.deactivate();
    	}
    	
    	this.frame.add(activeForm.getForm(), BorderLayout.CENTER);
		this.activeForm = activeForm;
		activeForm.setIsActiveForm(true);
		this.frame.setVisible(true);
	}

}
