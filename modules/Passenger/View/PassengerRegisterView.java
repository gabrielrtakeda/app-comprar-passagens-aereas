package project.modules.Passenger.View;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.AbstractView;
import project.modules.Passenger.View.Template.PassengerRegisterTemplate;

public class PassengerRegisterView extends AbstractView
{
    public PassengerRegisterView(ConfigurationEntity configuration)
    {
        setConfiguration(configuration.setView(this));
        setTitle(
            config.getTranslator().__("Cadastro de Passageiro")
        );
        setTemplate(new PassengerRegisterTemplate(config));
        showTemplate();
    }
}
