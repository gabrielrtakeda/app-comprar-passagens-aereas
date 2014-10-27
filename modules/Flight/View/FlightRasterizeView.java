package project.modules.Flight.View;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.AbstractView;
import project.modules.Flight.Controller.FlightController;
import project.modules.Flight.View.Template.FlightRasterizeTemplate;

public class FlightRasterizeView extends AbstractView
{
    public FlightRasterizeView(ConfigurationEntity configuration)
    {
        new FlightController(configuration);
        configuration.setView(this);
        setConfiguration(configuration);

        setTitle(configuration.getTranslator().__("Cadastrar Voo"));
        setTemplate(new FlightRasterizeTemplate(configuration));
        showTemplate();
    }
}
