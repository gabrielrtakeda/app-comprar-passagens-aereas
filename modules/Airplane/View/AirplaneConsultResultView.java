package project.modules.Airplane.View;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.AbstractView;
import project.modules.Airplane.View.Template.AirplaneConsultResultTemplate;

public class AirplaneConsultResultView extends AbstractView
{
    public AirplaneConsultResultView(ConfigurationEntity configuration)
    {
        configuration.setView(this);
        setConfiguration(configuration);

        setTitle(configuration.getTranslator().__("Resultado da Pesquisa"));
        setTemplate(new AirplaneConsultResultTemplate(configuration));
        showTemplate();
    }
}
