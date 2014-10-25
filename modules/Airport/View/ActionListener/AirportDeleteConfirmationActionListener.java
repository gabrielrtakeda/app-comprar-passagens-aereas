package project.modules.Airport.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Airport.Controller.AirportController;
import java.awt.event.ActionEvent;

public class AirportDeleteConfirmationActionListener extends AbstractActionListener
{
    public AirportDeleteConfirmationActionListener(ConfigurationEntity configuration)
    {
        configuration.setActionListener(this);
        setConfiguration(configuration);
    }

    public void actionPerformed(ActionEvent e)
    {
        getController().deleteAction();
    }

    public AirportController getController()
    {
        return new AirportController(configuration);
    }
}
