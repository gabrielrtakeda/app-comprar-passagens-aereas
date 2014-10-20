package project.modules.Airport.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Airport.View.AirportConsultView;
import java.awt.event.ActionEvent;

public class AirportConsultViewActionListener extends AbstractActionListener
{
    public AirportConsultViewActionListener(ConfigurationEntity configuration)
    {
        configuration.setActionListener(this);
        setConfiguration(configuration);
    }

    public void actionPerformed(ActionEvent e)
    {
        config.getView().dispose();
        new AirportConsultView(config);
    }
}
