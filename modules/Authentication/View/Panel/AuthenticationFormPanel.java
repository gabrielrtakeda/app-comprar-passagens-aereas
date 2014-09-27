package project.modules.Authentication.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
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
    protected AbstractActionListener authenticationActionListener;

    public AuthenticationFormPanel(ConfigurationEntity configuration)
    {
        super(new GridLayout(3, 2));
        setBorder(new EmptyBorder(0, 150, 30, 150));
        authenticationActionListener = new AuthenticationActionListener(configuration);

        add(new JLabel(configuration.getTranslator().__("Usuário") + ":"));
        add(authenticationActionListener.addComponent(
            "userTextField",
            new JTextField(10)
        ));

        add(new JLabel(configuration.getTranslator().__("Senha") + ":"));
        add(authenticationActionListener.addComponent(
            "userPasswordField",
            new JPasswordField(10)
        ));

        add(new JLabel());
        add(buildSendButton(configuration.getTranslator().__("Entrar")));
    }

    private JButton buildSendButton(String message)
    {
        JButton authenticationButton = new JButton(message);
        authenticationButton.addActionListener(authenticationActionListener);
        return authenticationButton;
    }
}
