package project.modules.Passenger.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PassengerRegisterModalCloseActionListener extends AbstractActionListener
{
    protected String nameModal = "passenger-register";

    public PassengerRegisterModalCloseActionListener(ConfigurationEntity configuration)
    {
        setConfiguration(configuration.setActionListener(this));
    }

    public void actionPerformed(ActionEvent e)
    {
        config.getModal(nameModal).dispose();
    }
}
