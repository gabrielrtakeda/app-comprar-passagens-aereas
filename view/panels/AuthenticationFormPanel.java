package project.view.panels;

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
		add(new JLabel("Login: "));
		add(new JTextField(10));
		add(new JLabel("Password: "));
		add(new JPasswordField(10));
		add(new JLabel());
		add(new JButton("Sign in"));
	}
}