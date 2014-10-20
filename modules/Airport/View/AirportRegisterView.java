package project.modules.Airport.View;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.AbstractView;
import project.modules.Airport.View.Template.AirportRegisterTemplate;

public class AirportRegisterView extends AbstractView
{
    public AirportRegisterView(ConfigurationEntity configuration)
    {
        configuration.setView(this);
        setConfiguration(configuration);

        setTitle(configuration.getTranslator().__("Cadastro de Aeroporto"));
        setTemplate(new AirportRegisterTemplate(configuration));
        showTemplate();
    }
}
