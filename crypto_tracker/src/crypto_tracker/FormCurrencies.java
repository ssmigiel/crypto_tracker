package crypto_tracker;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class FormCurrencies extends Form{
    private JTabbedPane currenciesPanel;
    private FormMenu menu;

    public FormCurrencies(List<Currency> currencies) {
    	super(new BorderLayout());
        initialize(currencies);
    }
    
// Getters and Setters
    
// Methods
    private void initialize(List<Currency> currencies) {
    	menu = new FormMenu();
    	currenciesPanel = new JTabbedPane(JTabbedPane.LEFT);
    	
    /* 
     * Try to add tabs for every currency
     * On fail add single tab with info for user
    */
        try {
            for(int i = 0; i < currencies.size(); i++) {
                JPanel panel = new JPanel();
                this.currenciesPanel.addTab(currencies.get(i).getName(), panel);
            }
        }
        catch(Exception e) {
            JPanel panel = new JPanel();
            panel.add(new JLabel("No currencies were found"), BorderLayout.CENTER);
            this.currenciesPanel.addTab("", panel);
        }
        
        form.add(this.currenciesPanel, BorderLayout.CENTER);
        form.add(menu.getForm(), BorderLayout.EAST);
    }
}
