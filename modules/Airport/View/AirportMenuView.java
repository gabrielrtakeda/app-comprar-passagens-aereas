package project.modules.Airport.View;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.AbstractView;
import project.modules.Airport.Controller.AirportController;
import project.modules.Airport.View.Template.AirportMenuTemplate;

public class AirportMenuView extends AbstractView
{
    public AirportMenuView(ConfigurationEntity configuration)
    {
        new AirportController(configuration);
        configuration.setView(this);
        setConfiguration(configuration);

        setTitle(configuration.getTranslator().__("Aeroportos"));
        setTemplate(new AirportMenuTemplate(configuration));
        showTemplate();
    }
}
