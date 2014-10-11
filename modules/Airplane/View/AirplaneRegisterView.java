package project.modules.Airplane.View;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.AbstractView;
import project.modules.Airplane.View.Template.AirplaneRegisterTemplate;

public class AirplaneRegisterView extends AbstractView
{
    public AirplaneRegisterView(ConfigurationEntity configuration)
    {
        configuration.setView(this);
        setConfiguration(configuration);

        setTitle(configuration.getTranslator().__("Cadastrar Aeronave"));
        setTemplate(new AirplaneRegisterTemplate(configuration));
        showTemplate();
    }
}
