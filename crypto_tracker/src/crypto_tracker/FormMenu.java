package crypto_tracker;

import java.awt.Color;
import java.awt.FlowLayout;

public class FormMenu extends Form{

    public FormMenu() {
    	super(new FlowLayout(FlowLayout.CENTER, 10, 5));
        initialize();
    }
    
// Getters and Setters
    
// Methods
    private void initialize() {
        this.form.setBackground(Color.BLUE);
    }
}
