package project.modules.Airport.View;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.AbstractView;
import project.modules.Airport.View.Template.AirportConsultTemplate;

public class AirportConsultView extends AbstractView
{
    public AirportConsultView(ConfigurationEntity configuration)
    {
        configuration.setView(this);
        setConfiguration(configuration);

        setTitle(configuration.getTranslator().__("Consulta de Aeroporto"));
        setTemplate(new AirportConsultTemplate(configuration));
        showTemplate();
    }
}
