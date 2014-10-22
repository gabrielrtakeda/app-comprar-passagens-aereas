package project.modules.Airport.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Airport.View.AirportMenuView;
import java.awt.event.ActionEvent;

public class AirportRegisterNavigationActionListener extends AbstractActionListener
{
    public AirportRegisterNavigationActionListener(ConfigurationEntity configuration)
    {
        configuration.setActionListener(this);
        setConfiguration(configuration);
    }

    public void actionPerformed(ActionEvent e)
    {
        configuration.getView().dispose();
        new AirportMenuView(configuration);
    }
}
