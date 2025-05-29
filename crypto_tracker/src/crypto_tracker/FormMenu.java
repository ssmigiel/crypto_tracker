package crypto_tracker;

import java.awt.Color;

import javax.swing.JButton;

public class FormMenu extends Form{

    public FormMenu(MainWindow window) {
    	super(window);
        initialize();
    }
    
// Getters and Setters
    
// Methods
    private void initialize() {
        this.form.setBackground(Color.BLUE);
    }
    
    public JButton addButton(String label) {
    	JButton btn = new JButton(label);
    	this.form.add(btn);
    	
    	return btn;
    }
}
