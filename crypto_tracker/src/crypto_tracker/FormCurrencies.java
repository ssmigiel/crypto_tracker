package crypto_tracker;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

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
				String s = (String)JOptionPane.showInputDialog(
                    form,
                    "Currency name:",
                    "Add new currency",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    "");

                if ((s != null) && (s.length() > 0)) {
                    refreshCurrenciesPanel(window.getSystem().addCurrency(s));
                    return;
                }
// TODO check if currency already exists
                JOptionPane.showMessageDialog(form, "Name cannot be empty", "Error", JOptionPane.INFORMATION_MESSAGE);
			}
			
		});

        this.menu.addButton("Remove currency").addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                List<Currency> currencies = window.getSystem().getCurrencies();
                Object[]currencyNames = currencies.stream().map(Currency::getName).collect(Collectors.toList()).toArray();

                Currency c = Currency.getCurrencyByName(currencies, (String)JOptionPane.showInputDialog(
                                                                    form,
                                                                    "Select currency to remove:",
                                                                    "Remove currency",
                                                                    JOptionPane.PLAIN_MESSAGE,
                                                                    null,
                                                                    currencyNames,
                                                                    currencyNames[0])
                                                        );
                
                if(c != null) {
                    window.getSystem().removeCurrency(c);
                    refreshCurrenciesPanel(c);
                    return;
                }

                JOptionPane.showMessageDialog(form, "Could not find chosen currency", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
            
        });
    }

    private void refreshCurrenciesPanel(Currency c) {
        // Tab is deleted
        if(c.getIsSoftDeleted()) {
            for(int i = 0; i < this.currenciesPanel.getTabCount(); i++) {
                if(this.currenciesPanel.getTitleAt(i).equals(c.getName())) {
                    this.currenciesPanel.remove(i);
                    break;
                }
            }
            if(this.currenciesPanel.getTabCount() == 0) {
                JPanel panel = new JPanel();
                panel.add(new JLabel("No currencies were found"), BorderLayout.CENTER);
                this.currenciesPanel.addTab("", panel);
            }
        }
        // Tab is added
        else {
            int index = window.getSystem().getCurrencies().indexOf(c);
            // Only info tab exists - needs to be deleted
            if (index == 0 && this.currenciesPanel.getTitleAt(0).equals("")) {
                currenciesPanel.removeAll();
            }
            JPanel panel = new JPanel();
            this.currenciesPanel.insertTab(c.getName(), null, panel, null, index);
        }
    }
}
