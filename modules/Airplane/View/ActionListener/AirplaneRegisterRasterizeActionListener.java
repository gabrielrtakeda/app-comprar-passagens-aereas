package project.modules.Airplane.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Airplane.View.AirplaneRegisterRasterizeView;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.util.Iterator;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class AirplaneRegisterRasterizeActionListener extends AbstractActionListener
{
    public AirplaneRegisterRasterizeActionListener(ConfigurationEntity configuration)
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
                configuration.getTranslator().__(errorMessage) + ": [" + errorFields +"]",
                configuration.getTranslator().__("Campo Obrigatório"),
                JOptionPane.ERROR_MESSAGE
            );
        } else {
            configuration.getView().dispose();
            configuration.setParameter("airplane-register-form-data", getComponents());
            new AirplaneRegisterRasterizeView(configuration);
        }
    }
}
