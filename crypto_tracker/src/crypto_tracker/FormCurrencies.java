package crypto_tracker;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class FormCurrencies extends Form{
    private JTabbedPane currenciesPanel;
    private FormMenu menu;

    public FormCurrencies(MainWindow window, List<Currency> currencies) {
    	super(window, new BorderLayout());
        initialize(currencies);
    }
    
// Getters and Setters
    
// Methods
    private void initialize(List<Currency> currencies) {
    	menu = new FormMenu(window);
    	
    	createMenuButtons();
    	
    	currenciesPanel = new JTabbedPane(JTabbedPane.LEFT);
    	
    /* 
     * Try to add tabs for every currency
     * On fail add single tab with info for user
    */
        if(currencies.size() != 0) {
            for(int i = 0; i < currencies.size(); i++) {
                JPanel panel = new JPanel();
                this.currenciesPanel.addTab(currencies.get(i).getName(), panel);
            }
        }
        else{
            JPanel panel = new JPanel();
            panel.add(new JLabel("No currencies were found"), BorderLayout.CENTER);
            this.currenciesPanel.addTab("", panel);
        }
        
        form.add(this.currenciesPanel, BorderLayout.CENTER);
        form.add(menu.getForm(), BorderLayout.WEST);
    }
    
    private void createMenuButtons() {
    	this.menu.addButton("Add currency").addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String s = (String)JOptionPane.showInputDialog(form,
                    "Currency name:",
                    "Add new currency",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    "");

                if ((s != null) && (s.length() > 0)) {
                    window.getSystem().addCurrency(s);
                    refreshCurrenciesPanel();
                    return;
                }
// TODO check if currency already exists
                JOptionPane.showMessageDialog(form, "Name cannot be empty", "Error", JOptionPane.INFORMATION_MESSAGE);
			}
			
		});

        this.menu.addButton("Remove currency").addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                
            }
            
        });
    }

    private void refreshCurrenciesPanel() {
        List<Currency> currencies = window.getSystem().getCurrencies();
        if(currencies.size() == 1) {
            currenciesPanel.removeAll();
            JPanel panel = new JPanel();
            this.currenciesPanel.addTab(currencies.get(0).getName(), panel);
        }
        else {
            for(int i = 0; i < currencies.size(); i++) {
                if(this.currenciesPanel.getTitleAt(i) != currencies.get(i).getName())
                {
                    JPanel panel = new JPanel();
                    this.currenciesPanel.insertTab(currencies.get(i).getName(), null, panel, null, i);
                }
            }
        }
    }
}
