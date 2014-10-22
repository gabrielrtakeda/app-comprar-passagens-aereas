package project.modules.Airport.View;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.AbstractView;
import project.modules.Airport.View.Template.AirportDeleteContentTemplate;

public class AirportDeleteContentView extends AbstractView
{
    public AirportDeleteContentView(ConfigurationEntity configuration)
    {
        configuration.setView(this);
        setConfiguration(configuration);

        setTitle(configuration.getTranslator().__("Excluir Aeroporto"));
        setTemplate(new AirportDeleteContentTemplate(configuration));
        showTemplate();
    }
}
