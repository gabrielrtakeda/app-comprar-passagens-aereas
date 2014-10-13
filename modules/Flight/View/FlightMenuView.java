package project.modules.Flight.View;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.AbstractView;
import project.modules.Flight.View.Template.FlightMenuTemplate;

public class FlightMenuView extends AbstractView
{
    public FlightMenuView(ConfigurationEntity configuration)
    {
        configuration.setView(this);
        setConfiguration(configuration);

        setTitle(configuration.getTranslator().__("Voo"));
        setTemplate(new FlightMenuTemplate(configuration));
        showTemplate();
    }
}
