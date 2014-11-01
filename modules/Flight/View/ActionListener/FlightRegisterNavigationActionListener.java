package project.modules.Flight.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Flight.Controller.FlightController;
import project.modules.Flight.View.FlightMenuView;
import java.awt.event.ActionEvent;

public class FlightRegisterNavigationActionListener extends AbstractActionListener
{
    public FlightRegisterNavigationActionListener(ConfigurationEntity configuration)
    {
        configuration.setActionListener(this);
        setConfiguration(configuration);
    }

    public void actionPerformed(ActionEvent e)
    {
        getController().navigateAction("menu");
    }

    private FlightController getController()
    {
        return new FlightController(configuration);
    }
}
