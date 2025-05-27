package crypto_tracker;

import java.awt.LayoutManager;

import javax.swing.JPanel;

public class Form {
	protected MainWindow window;
	protected JPanel form;
	protected boolean isActiveForm;
	
	public Form(MainWindow window, LayoutManager layout) {
		this.window = window;
		form = new JPanel();
		this.form.setLayout(layout);
		this.isActiveForm = false;
	}

// Getters and Setters
	public JPanel getForm() {
		return form;
	}

	public boolean getIsActiveForm() {
		return isActiveForm;
	}
	public void setIsActiveForm(boolean isActiveForm) {
		this.isActiveForm = isActiveForm;
	}

// Methods	
	public void deactivate() {
		this.window = null;
		this.isActiveForm = false;
	}
	
}
