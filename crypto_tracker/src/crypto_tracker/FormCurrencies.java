package crypto_tracker;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class FormCurrencies {
    private JTabbedPane currenciesForm;

    public FormCurrencies(List<Currency> currencies) {
        initialize(currencies);
    }

    public JTabbedPane getCurrenciesForm() {
        return this.currenciesForm;
    }

    private void initialize(List<Currency> currencies) {
        currenciesForm = new JTabbedPane(JTabbedPane.LEFT);
    /* 
     * Try to add tabs for every currency
     * On fail add single tab with info for user
    */
        try {
            for(int i = 0; i < currencies.size(); i++) {
                JPanel panel = new JPanel();
                this.currenciesForm.addTab(currencies.get(i).getName(), panel);
            }
        }
        catch(Exception e) {
            JPanel panel = new JPanel();
            panel.add(new JLabel("No currencies were found"), BorderLayout.CENTER);
            this.currenciesForm.addTab("", panel);
        }
    }
}
