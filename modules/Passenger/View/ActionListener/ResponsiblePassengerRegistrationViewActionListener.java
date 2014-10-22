package project.modules.Passenger.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import java.awt.event.ActionEvent;

public class ResponsiblePassengerRegistrationViewActionListener extends AbstractActionListener
{
    public ResponsiblePassengerRegistrationViewActionListener(ConfigurationEntity configuration)
    {
        configuration.setActionListener(this);
        setConfiguration(configuration);
    }

    public void actionPerformed(ActionEvent e)
    {
        configuration.getView().dispose();
        // new ResponsiblePassengerRegistrationView(configuration);
    }
}
