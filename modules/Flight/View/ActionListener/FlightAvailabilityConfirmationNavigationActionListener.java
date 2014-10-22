package project.modules.Flight.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import java.awt.event.ActionEvent;

public class FlightAvailabilityConfirmationNavigationActionListener extends AbstractActionListener
{
    protected String nameModal = "flight-availability-confirmation";

    public FlightAvailabilityConfirmationNavigationActionListener(ConfigurationEntity configuration)
    {
        configuration.setActionListener(this);
        setConfiguration(configuration);
    }

    public void actionPerformed(ActionEvent e)
    {
        configuration.getModal(nameModal).dispose();
        configuration.removeModal(nameModal);
    }
}
