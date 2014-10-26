package project.modules.Flight.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Flight.Controller.FlightController;
import java.awt.event.ActionEvent;

public class FlightRegisterViewActionListener extends AbstractActionListener
{
    public FlightRegisterViewActionListener(ConfigurationEntity configuration)
    {
        configuration.setActionListener(this);
        setConfiguration(configuration);
    }

    public void actionPerformed(ActionEvent e)
    {
        getController().navigateAction("register-view");
    }

    public FlightController getController()
    {
        return new FlightController(configuration);
    }
}
