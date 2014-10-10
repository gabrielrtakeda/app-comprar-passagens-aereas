package project.modules.Flight.View.ActionListener;

import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Flight.View.FlightRegisterView;
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
        config.getView().dispose();
        new FlightRegisterView(config);
    }
}
