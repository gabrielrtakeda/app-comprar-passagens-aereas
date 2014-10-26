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
        Map<String, Component> parameter = configuration.getParameter("airport-register-form-data");
        JTextField description   = (JTextField) parameter.get("description");
        JTextField abbreviation  = (JTextField) parameter.get("abbreviation");
        JTextField address       = (JTextField) parameter.get("address");

        AirportEntity airportEntity = new AirportEntity();
        airportEntity.setDescription(description.getText())
                     .setAbbreviation(abbreviation.getText())
                     .setAddress(address.getText());

        getController(configuration).registerAction(airportEntity);
    }

    private AirportController getController(ConfigurationEntity configuration)
    {
        return new AirportController(configuration);
    }
}
