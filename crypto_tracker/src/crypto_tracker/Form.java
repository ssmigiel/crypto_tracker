package crypto_tracker;

import java.awt.LayoutManager;

import javax.swing.JPanel;

public class Form {
	protected JPanel form;
	
	public Form(LayoutManager layout) {
		form = new JPanel();
		this.form.setLayout(layout);
	}

// Getters and Setters
	public JPanel getForm() {
		return form;
	}
	
}
