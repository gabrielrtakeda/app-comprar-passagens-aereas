package project.modules.Airport.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
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
        String errorFields = "";
        Integer errorCount = 0;

        Iterator<String> keySetIterator = getComponents().keySet().iterator();
        while (keySetIterator.hasNext()) {
            String field = keySetIterator.next();

            JTextField textField = (JTextField) getComponent(field);
            if (textField.getText().equals("")) {

                if (errorFields.equals("")) {
                    errorFields += field;
                } else {
                    errorFields += ", " + field;
                }
                errorCount++;
            }
        }

        if (errorCount > 0) {
            String errorMessage = errorCount > 1
                ? "Preencha os campos"
                : "Preencha o campo";
            JOptionPane.showMessageDialog(
                null,
                config.getTranslator().__(errorMessage) + ": [" + errorFields +"]",
                config.getTranslator().__("Campo Obrigatório"),
                JOptionPane.ERROR_MESSAGE
            );
        } else {
            config.getView().dispose();
            config.setParameter("airport-register-form-data", getComponents());
            new AirportRegisterRasterizeView(config);
        }
    }
}
