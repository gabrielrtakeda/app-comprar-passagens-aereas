package project.modules.Airport.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Form.Validator.FormRequiredFieldValidator;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Airport.Entity.AirportEntity;
import project.modules.Airport.View.AirportRegisterRasterizeView;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.util.Iterator;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class AirportRegisterRasterizeActionListener extends AbstractActionListener
{
    public AirportRegisterRasterizeActionListener(ConfigurationEntity configuration)
    {
        configuration.setActionListener(this);
        setConfiguration(configuration);
    }

    public void actionPerformed(ActionEvent e)
    {
        JTextField description = (JTextField) getComponent("description");
        JTextField abbreviation = (JTextField) getComponent("abbreviation");
        JTextField address = (JTextField) getComponent("address");

        Iterator<String> keySetIterator = getComponents().keySet().iterator();
        while (keySetIterator.hasNext()) {
            String fieldName = keySetIterator.next();
            switch (fieldName) {
                case "description":
                    FormRequiredFieldValidator.validateField(fieldName, description.getText());
                    break;
                case "abbreviation":
                    FormRequiredFieldValidator.validateField(fieldName, abbreviation.getText());
                    break;
                case "address":
                    FormRequiredFieldValidator.validateField(fieldName, address.getText());
                    break;
            }
        }

        if (FormRequiredFieldValidator.getErrorCount() > 0) {
            FormRequiredFieldValidator.setConfiguration(configuration);
            FormRequiredFieldValidator.showErrorMessage();
        } else {
            AirportEntity airportEntity = new AirportEntity();
            airportEntity.setDescription(description.getText())
                         .setAbbreviation(abbreviation.getText())
                         .setAddress(address.getText());

            configuration.getView().dispose();
            configuration.setEntity("airport", airportEntity);
            configuration.setQueryString("airport-consult-confirmation", "register");
            new AirportRegisterRasterizeView(configuration);
        }
    }
}
