package project.modules.Passenger.View.Modal;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.Modal.AbstractModal;
import project.modules.Passenger.View.Template.PassengerRegisterTemplate;

public class PassengerRegisterModal extends AbstractModal
{
    public PassengerRegisterModal(ConfigurationEntity configuration)
    {
        super(configuration.getView());
        configuration.setModal(this);
        setConfiguration(configuration);

        setTitle(configuration.getTranslator().__("Cadastro de Passageiro"));
        setTemplate(new PassengerRegisterTemplate(configuration));
        showModalTemplate();
        System.out.println("Actual View: " + config.getModal().getClass().getName());
        System.out.println("PassengerRegisterModal");
        System.out.println("--------------------------------------");
    }
}
