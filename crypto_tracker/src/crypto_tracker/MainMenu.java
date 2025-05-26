package crypto_tracker;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class MainMenu {
	private MainWindow mainWindow;
	private JMenuBar menuBar;
	
	public MainMenu(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		
		initialize();
	}
	
// Getters and Setters
	public MainWindow getMainWindow() {
		return mainWindow;
	}
	
	public JMenuBar getMenuBar() {
		return menuBar;
	}
// Methods
	private void initialize() {
		menuBar = new JMenuBar();
		
		this.addMenu("File");
		this.addMenu("Edit");
		this.addMenu("Forms");
	}

	private JMenu addMenu(String menuName) {
		JMenu newMenu = new JMenu(menuName); 
		this.menuBar.add(newMenu);
		
		return newMenu;
	}
}
