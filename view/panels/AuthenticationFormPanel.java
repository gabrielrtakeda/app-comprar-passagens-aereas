package project.view.panels;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class AuthenticationFormPanel extends JPanel
{
    public AuthenticationFormPanel()
    {
        super(new GridLayout(3, 2));
        add(new JLabel(""));
    }
}
