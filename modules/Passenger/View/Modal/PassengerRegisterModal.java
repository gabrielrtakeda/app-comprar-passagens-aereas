package project.modules.Passenger.View.Modal;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.Modal.AbstractModal;
import project.modules.Passenger.View.Template.PassengerRegisterModalTemplate;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;

public class PassengerRegisterModal extends AbstractModal
{
    public PassengerRegisterModal(ConfigurationEntity configuration)
    {
        super(configuration.getView());
        configuration.setModal("passenger-register", this);
        setConfiguration(configuration);

        setTitle(configuration.getTranslator().__("Cadastro de Passageiro"));
        setTemplate(new PassengerRegisterModalTemplate(configuration));
        showModal();
    }
}
