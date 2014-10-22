package project.modules.Passenger.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.AbstractView;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Passenger.View.Modal.PassengerRegisterModal;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

public class PassengerRegisterModalActionListener extends AbstractActionListener
{
    public PassengerRegisterModalActionListener(ConfigurationEntity configuration)
    {
        configuration.setActionListener(this);
        setConfiguration(configuration);
    }

    public void actionPerformed(ActionEvent e)
    {
        new PassengerRegisterModal(configuration);
    }
}
