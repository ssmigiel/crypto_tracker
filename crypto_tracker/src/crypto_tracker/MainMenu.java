package crypto_tracker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainMenu {
	private MainWindow mainWindow;
	private JMenuBar menuBar;
	
	int iconTextGap;
	
	public MainMenu(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		this.iconTextGap = 10;
		
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
		
		this.addMenu("File", KeyEvent.VK_F);
		this.addMenu("Edit", KeyEvent.VK_E);
		JMenu formsMenu = this.addMenu("Forms", KeyEvent.VK_O);
		
		formsMenu.add(new JMenuItem("Currencies")).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainWindow.setActiveForm(new FormCurrencies(mainWindow.getSystem().getCurrencies()));
			}
			
		});
	}

	private JMenu addMenu(String menuName, int keyEvent) {
		JMenu newMenu = new JMenu(menuName);
		newMenu.setMnemonic(keyEvent);
		newMenu.setIconTextGap(iconTextGap);
		
		this.menuBar.add(newMenu);
		
		return newMenu;
	}
	
	private JMenu addMenu(String menuName, int keyEvent, ImageIcon icon) {
		JMenu newMenu = new JMenu(menuName);
		newMenu.setMnemonic(keyEvent);
		newMenu.setIcon(icon);
		newMenu.setIconTextGap(iconTextGap);
		
		this.menuBar.add(newMenu);
		
		return newMenu;
	}
}
