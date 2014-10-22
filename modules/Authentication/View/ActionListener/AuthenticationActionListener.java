package project.modules.Authentication.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Authentication.Controller.AuthenticationController;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class AuthenticationActionListener extends AbstractActionListener
{
    public AuthenticationActionListener(ConfigurationEntity configuration)
    {
        configuration.setActionListener(this);
        setConfiguration(configuration);
    }

    public void actionPerformed(ActionEvent e)
    {
        JTextField userTextField = (JTextField) getComponent("userTextField");
        JPasswordField userPasswordField = (JPasswordField) getComponent("userPasswordField");

        getController().authenticateAction(
            userTextField.getText(),
            String.valueOf(userPasswordField.getPassword())
        );
    }

    public AuthenticationController getController()
    {
        return new AuthenticationController(configuration);
    }
}
