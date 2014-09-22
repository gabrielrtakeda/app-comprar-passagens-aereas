package project.modules.Authentication.View.Panel;

import project.Main;
import project.modules.Application.Controller.AbstractController;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Authentication.Controller.AuthenticationController;
import project.modules.Authentication.View.ActionListener.AuthenticationActionListener;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class AuthenticationFormPanel extends JPanel
{
    protected AbstractController
        controller = new AuthenticationController();

    protected AbstractActionListener
        authenticationActionListener = new AuthenticationActionListener();

    public AuthenticationFormPanel()
    {
        super(new GridLayout(3, 2));
        setBorder(new EmptyBorder(0, 150, 30, 150));

        add(new JLabel(Main.translator.__("Usuário") + ":"));
        add(authenticationActionListener.addComponent(
            "userTextField",
            new JTextField(10)
        ));

        add(new JLabel(Main.translator.__("Senha") + ":"));
        add(authenticationActionListener.addComponent(
            "userPasswordField",
            new JPasswordField(10)
        ));

        add(new JLabel());
        add(buildSendButton(Main.translator.__("Entrar")));
    }

    private JButton buildSendButton(String message)
    {
        JButton authenticationButton = new JButton(message);
        authenticationButton.addActionListener(authenticationActionListener);
        return authenticationButton;
    }
}
