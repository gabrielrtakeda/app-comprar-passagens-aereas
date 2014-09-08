package project.modules.Authentication.View.Template;

import project.modules.Authentication.View.Panel.AuthenticationHeaderPanel;
import project.modules.Authentication.View.Panel.AuthenticationFormPanel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AuthenticationTemplate extends JPanel
{
	public AuthenticationTemplate()
	{
		super(new BorderLayout());
		setBorder(new EmptyBorder(30, 150, 30, 150));
        add(new AuthenticationHeaderPanel(), BorderLayout.NORTH);
        add(new AuthenticationFormPanel(), BorderLayout.CENTER);
	}
}
