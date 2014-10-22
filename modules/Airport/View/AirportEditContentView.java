package project.modules.Airport.View;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.AbstractView;
import project.modules.Airport.View.Template.AirportEditContentTemplate;

public class AirportEditContentView extends AbstractView
{
    public AirportEditContentView(ConfigurationEntity configuration)
    {
        configuration.setView(this);
        setConfiguration(configuration);

        setTitle(configuration.getTranslator().__("Editar Aeroporto"));
        setTemplate(new AirportEditContentTemplate(configuration));
        showTemplate();
    }
}
