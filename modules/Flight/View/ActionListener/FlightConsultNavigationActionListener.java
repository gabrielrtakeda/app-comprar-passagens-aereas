package project.modules.Flight.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Flight.View.FlightMenuView;
import java.awt.event.ActionEvent;

public class FlightConsultNavigationActionListener extends AbstractActionListener
{
    public FlightConsultNavigationActionListener(ConfigurationEntity configuration)
    {
        configuration.setActionListener(this);
        setConfiguration(configuration);
    }

    public void actionPerformed(ActionEvent e)
    {
        configuration.getView().dispose();
        new FlightMenuView(configuration);
    }
}
