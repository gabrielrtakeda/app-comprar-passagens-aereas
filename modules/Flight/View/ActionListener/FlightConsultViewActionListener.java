package project.modules.Flight.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Flight.View.FlightConsultView;
import java.awt.event.ActionEvent;

public class FlightConsultViewActionListener extends AbstractActionListener
{
    public FlightConsultViewActionListener(ConfigurationEntity configuration)
    {
        configuration.setActionListener(this);
        setConfiguration(configuration);
    }

    public void actionPerformed(ActionEvent e)
    {
        configuration.getView().dispose();
        new FlightConsultView(configuration);
    }
}
