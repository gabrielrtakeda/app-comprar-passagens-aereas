package project.modules.Airplane.View;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.AbstractView;
import project.modules.Airplane.View.Template.AirplaneConsultTemplate;

public class AirplaneConsultView extends AbstractView
{
    public AirplaneConsultView(ConfigurationEntity configuration)
    {
        configuration.setView(this);
        setConfiguration(configuration);

        setTitle(configuration.getTranslator().__("Consultar Aeronave"));
        setTemplate(new AirplaneConsultTemplate(configuration));
        showTemplate();
    }
}
