package project.modules.Airplane.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Application.Form.Validator.FormRequiredFieldValidator;
import project.modules.Airplane.Entity.AirplaneEntity;
import project.modules.Airplane.View.AirplaneRasterizeView;
import project.modules.Airplane.Type.AirplaneStatusType;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.util.Iterator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class AirplaneRasterizeActionListener extends AbstractActionListener
{
    public AirplaneRasterizeActionListener(ConfigurationEntity configuration)
    {
        configuration.setActionListener(this);
        setConfiguration(configuration);
    }

    public void actionPerformed(ActionEvent e)
    {
        JTextField description  = (JTextField) getComponent("description");
        JTextField family       = (JTextField) getComponent("family");
        JTextField model        = (JTextField) getComponent("model");
        JComboBox  status       = (JComboBox) getComponent("status");

        Iterator<String> keySetIterator = getComponents().keySet().iterator();
        while (keySetIterator.hasNext()) {
            String fieldName = keySetIterator.next();
            switch (fieldName) {
                case "description":
                    FormRequiredFieldValidator.validateField(fieldName, description.getText());
                    break;
                case "family":
                    FormRequiredFieldValidator.validateField(fieldName, family.getText());
                    break;
                case "model":
                    FormRequiredFieldValidator.validateField(fieldName, model.getText());
                    break;
            }
        }

        if (FormRequiredFieldValidator.getErrorCount() > 0) {
            FormRequiredFieldValidator.setConfiguration(configuration);
            FormRequiredFieldValidator.showErrorMessage();
        } else {
            AirplaneEntity airplaneEntity = new AirplaneEntity();
            airplaneEntity.setDescription(description.getText())
                          .setFamily(family.getText())
                          .setModel(model.getText())
                          .setStatus(
                                ((AirplaneStatusType) status.getSelectedItem()).getValue()
                          );

            configuration.getView().dispose();
            configuration.setEntity("airplane", airplaneEntity);
            new AirplaneRasterizeView(configuration);
        }
    }
}
