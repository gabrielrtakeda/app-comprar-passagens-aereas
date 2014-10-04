package project.modules.Passenger.View;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.AbstractView;
import project.modules.Passage.View.Template.PassagePurchaseTemplate;
import project.modules.Passenger.View.Template.PassengerRegisterTemplate;

public class PassengerRegisterView extends AbstractView
{
    public PassengerRegisterView(ConfigurationEntity configuration)
    {
        configuration.setView(this);
        setConfiguration(configuration);

        setTitle(config.getTranslator().__("Cadastro de Passageiro"));
        setTemplate(new PassengerRegisterTemplate(config));
        showTemplate();
    }
}
