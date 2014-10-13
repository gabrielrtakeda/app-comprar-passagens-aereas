package project.modules.Flight.View;

import project.modules.Application.View.AbstractView;
import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Flight.Controller.FlightController;
import project.modules.Flight.View.Template.FlightRegisterTemplate;

public class FlightRegisterView extends AbstractView
{
    public FlightRegisterView(ConfigurationEntity configuration)
    {
    	new FlightController(configuration);
        configuration.setView(this);
        setConfiguration(configuration);

        setTitle(configuration.getTranslator().__("Cadastrar Voo"));
        setTemplate(new FlightRegisterTemplate(configuration));
        showTemplate();
    }
}
