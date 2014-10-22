package project.modules.Airport.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Airport.Controller.AirportController;
import java.awt.event.ActionEvent;

public class AirportDeleteViewActionListener extends AbstractActionListener
{
    public AirportDeleteViewActionListener(ConfigurationEntity configuration)
    {
        configuration.setActionListener(this);
        setConfiguration(configuration);
    }

    public void actionPerformed(ActionEvent e)
    {
        getController().deleteConsultAction();
    }

    private AirportController getController()
    {
        return new AirportController(configuration);
    }
}
