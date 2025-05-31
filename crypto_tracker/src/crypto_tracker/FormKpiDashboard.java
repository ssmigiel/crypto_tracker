package crypto_tracker;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

public class FormKpiDashboard extends Form {
    
    private List<Kpi> kpis;

    public FormKpiDashboard(MainWindow window) {
        super(window);
        kpis = new ArrayList<Kpi>();
    }

// Gettters and setters

// Methods
    public void addKpiBox() {
        Box box = new Box(BoxLayout.Y_AXIS);
        box.setBorder(BorderFactory.createLineBorder(Color.black));
        
        this.form.add(box);
    }
}
