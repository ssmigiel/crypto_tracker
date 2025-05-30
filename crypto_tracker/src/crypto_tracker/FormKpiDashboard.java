package crypto_tracker;

import java.util.ArrayList;
import java.util.List;

public class FormKpiDashboard extends Form {
    
    private List<Kpi> kpis;

    public FormKpiDashboard(MainWindow window) {
        super(window);
         kpis = new ArrayList<Kpi>();
    }

// Gettters and setters

// Methods
    public void addKpi(Kpi kpi) {
        kpis.add(kpi);
    }
}
