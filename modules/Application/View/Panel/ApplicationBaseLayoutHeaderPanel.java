package project.modules.Application.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Application.View.ActionListener.ApplicationCloseActionListener;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class ApplicationBaseLayoutHeaderPanel extends JPanel
{
    public ApplicationBaseLayoutHeaderPanel(ConfigurationEntity configuration)
    {
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(3, 3, 20, 3));
        add(
            buildWelcomeLabel(
                configuration.getTranslator().__("Seja bem-vindo(a)") + " ${nomeAtendente}"
            ), BorderLayout.WEST
        );
        add(
            buildLogoutButton(
                configuration.getTranslator().__("Sair"),
                new ApplicationCloseActionListener(configuration)
            ), BorderLayout.EAST
        );
    }

    private JLabel buildWelcomeLabel(String message)
    {
        JLabel label = new JLabel(message);
        label.setFont(new Font("Arial", Font.PLAIN, 10));
        return label;
    }

    private JButton buildLogoutButton(String message, AbstractActionListener actionListener)
    {
        JButton button = new JButton(message);
        button.setFont(new Font("Arial", Font.PLAIN, 10));
        button.setFocusable(false);
        button.addActionListener(actionListener);
        return button;
    }
}
