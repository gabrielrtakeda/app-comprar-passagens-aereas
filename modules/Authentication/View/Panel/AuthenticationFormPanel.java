package project.modules.Authentication.View.Panel;

import project.modules.Translation.Exception.TranslationNotFoundException;
import project.Main;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class AuthenticationFormPanel extends JPanel
{
    public AuthenticationFormPanel()
    {
        super(new GridLayout(3, 2));

        try {
            add(new JLabel(Main.translator.__("Usuário") + ":"));
            add(new JTextField(10));

            add(new JLabel(Main.translator.__("Senha") + ":"));
            add(new JPasswordField(10));

            add(new JLabel());
            add(new JButton(Main.translator.__("Entrar")));
        } catch (TranslationNotFoundException e) {
            e.printMessage();
        }
    }
}
