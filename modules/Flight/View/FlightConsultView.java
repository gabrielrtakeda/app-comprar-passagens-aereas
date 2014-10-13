package project.modules.Flight.View;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.AbstractView;
import project.modules.Flight.Controller.FlightController;
import project.modules.Flight.View.Template.FlightConsultTemplate;

public class FlightConsultView extends AbstractView
{
    public FlightConsultView(ConfigurationEntity configuration)
    {
    	new FlightController(configuration);
        configuration.setView(this);
        setConfiguration(configuration);

        setTitle(configuration.getTranslator().__("Consultar Voo"));
        setTemplate(new FlightConsultTemplate(configuration));
        showTemplate();
    }
}
