package project.modules.Airport.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Airport.Controller.AirportController;
import project.modules.Airport.Entity.AirportEntity;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.util.Map;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class AirportRegisterConfirmationActionListener extends AbstractActionListener
{
    public AirportRegisterConfirmationActionListener(ConfigurationEntity configuration)
    {
        configuration.setActionListener(this);
        setConfiguration(configuration);
    }

    public void actionPerformed(ActionEvent e)
    {
        getController(configuration).registerAction(
            (AirportEntity) configuration.getEntity("airport")
        );
    }

    private AirportController getController(ConfigurationEntity configuration)
    {
        return new AirportController(configuration);
    }
}
