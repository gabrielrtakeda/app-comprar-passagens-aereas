package project.modules.Application.View.Panel;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class ApplicationBaseLayoutHeaderPanel extends JPanel
{
    public ApplicationBaseLayoutHeaderPanel()
    {
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(3, 3, 20, 3));
        add(buildWelcomeLabel("Seja bem-vindo(a) ${nomeAtendente}"), BorderLayout.WEST);
        add(buildLogoutButton("Sair"), BorderLayout.EAST);
    }

    private JLabel buildWelcomeLabel(String message)
    {
        JLabel label = new JLabel(message);
        label.setFont(new Font("Arial", Font.PLAIN, 10));
        return label;
    }

    private JButton buildLogoutButton(String message)
    {
        JButton button = new JButton(message);
        button.setFont(new Font("Arial", Font.PLAIN, 10));
        button.setFocusable(false);
        return button;
    }
}
