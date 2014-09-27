package project.modules.Authentication.View.ActionListener;

import project.modules.Application.Controller.AbstractController;
import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.AbstractView;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Authentication.Controller.AuthenticationController;
import project.modules.Authentication.Entity.UserEntity;
import project.modules.Menu.View.MenuAtendenteView;
import project.modules.Menu.View.MenuSupervisorView;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class AuthenticationActionListener extends AbstractActionListener
{
    protected AuthenticationController authenticationController = new AuthenticationController();

    public AuthenticationActionListener(ConfigurationEntity configuration)
    {
        configuration.setActionListener(this);
        setConfiguration(configuration);
    }

    public void actionPerformed(ActionEvent e)
    {
        JTextField userTextField = (JTextField) getComponent("userTextField");
        JPasswordField userPasswordField = (JPasswordField) getComponent("userPasswordField");

        UserEntity userEntity = authenticationController.authenticate(
            userTextField.getText(),
            String.valueOf(userPasswordField.getPassword())
        );

        if (!userEntity.isEmpty()) {

            config.getView().dispose();
            if (userEntity.isSupervisor()) {
                new MenuSupervisorView(config);
            } else {
                new MenuAtendenteView(config);
            }
        } else {
            JOptionPane.showMessageDialog(
                null,
                config.getTranslator().__("Falha na autenticação") + ".",
                config.getTranslator().__("Autenticação"),
                JOptionPane.WARNING_MESSAGE
            );
        }
    }
}
