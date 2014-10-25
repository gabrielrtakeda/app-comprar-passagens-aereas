package project.modules.Airport.View;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.AbstractView;
import project.modules.Airport.View.Template.AirportDeleteConfirmationTemplate;

public class AirportDeleteConfirmationView extends AbstractView
{
    public AirportDeleteConfirmationView(ConfigurationEntity configuration)
    {
        configuration.setView(this);
        setConfiguration(configuration);

        setTitle(configuration.getTranslator().__("Confirmação de Exclusão"));
        setTemplate(new AirportDeleteConfirmationTemplate(configuration));
        showTemplate();
    }
}
