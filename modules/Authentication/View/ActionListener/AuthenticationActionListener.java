package project.modules.Authentication.View.ActionListener;

import project.Main;
import project.modules.Application.Controller.AbstractController;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Authentication.Controller.AuthenticationController;
import project.modules.Menu.View.MenuSupervisorView;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class AuthenticationActionListener extends AbstractActionListener
{
    protected AuthenticationController
        authenticationController = new AuthenticationController();

    public void actionPerformed(ActionEvent e)
    {
        JTextField userTextField = (JTextField) getComponent("userTextField");
        JPasswordField userPasswordField = (JPasswordField) getComponent("userPasswordField");

        authenticationController.authenticate(
            userTextField.getText(),
            String.valueOf(userPasswordField.getPassword())
        );

        Main.view.getTemplate().setVisible(false);
        Main.view = new MenuSupervisorView();
    }
}
