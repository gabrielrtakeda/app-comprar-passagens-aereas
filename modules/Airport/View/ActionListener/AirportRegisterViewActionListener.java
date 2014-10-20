package project.modules.Airport.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Airport.View.AirportRegisterView;
import java.awt.event.ActionEvent;

public class AirportRegisterViewActionListener extends AbstractActionListener
{
    public AirportRegisterViewActionListener(ConfigurationEntity configuration)
    {
        configuration.setActionListener(this);
        setConfiguration(configuration);
    }

    public void actionPerformed(ActionEvent e)
    {
        config.getView().dispose();
        new AirportRegisterView(config);
    }
}
