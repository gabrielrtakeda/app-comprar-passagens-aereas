package project.modules.Passenger.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.AbstractView;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Passenger.View.PassengerRegisterView;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

public class PassengerRegisterShowFormActionListener extends AbstractActionListener
{
    public PassengerRegisterShowFormActionListener(ConfigurationEntity configuration)
    {
        setConfiguration(configuration.setActionListener(this));
    }

    public void actionPerformed(ActionEvent e)
    {
        AbstractView view = new PassengerRegisterView(config);
        view.setAlwaysOnTop(true);
        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
