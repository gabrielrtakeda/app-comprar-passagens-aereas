package project.modules.Flight.View.Modal;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.Modal.AbstractModal;
import project.modules.Flight.View.Template.FlightAvailabilityConfirmationTemplate;

public class FlightAvailabilityConfirmationModal extends AbstractModal
{
    public FlightAvailabilityConfirmationModal(ConfigurationEntity configuration)
    {
        super(configuration.getView());
        configuration.setModal("flight-availability-confirmation", this);
        setConfiguration(configuration);

        setTitle(configuration.getTranslator().__("Disponibilidade do Voo"));
        setTemplate(new FlightAvailabilityConfirmationTemplate(configuration));
        showModal();
    }
}
