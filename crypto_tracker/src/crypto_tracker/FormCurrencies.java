package crypto_tracker;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class FormCurrencies {
    private JTabbedPane currenciesForm;

    public FormCurrencies() {
        initialize();
    }

    public JTabbedPane getCurrenciesForm() {
        return this.currenciesForm;
    }

    private void initialize() {
        currenciesForm = new JTabbedPane(JTabbedPane.LEFT);

        JPanel page1 = new JPanel();
        page1.add(new JLabel("This is Tab 1"));
        JPanel page2 = new JPanel();
        page2.add(new JLabel("This is Tab 2"));

        this.currenciesForm.addTab("Tab 1", page1);
        this.currenciesForm.addTab("Tab 2", page2);
    }
}
