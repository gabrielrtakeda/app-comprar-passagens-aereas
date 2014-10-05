package project.modules.Flight.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Flight.View.Modal.FlightAvailabilityConfirmationModal;
import java.awt.event.ActionEvent;

public class FlightAvailabilityConfirmationActionListener extends AbstractActionListener
{
    public FlightAvailabilityConfirmationActionListener(ConfigurationEntity configuration)
    {
        configuration.setActionListener(this);
        setConfiguration(configuration);
    }

    public void actionPerformed(ActionEvent e)
    {
        new FlightAvailabilityConfirmationModal(config);
    }
}
