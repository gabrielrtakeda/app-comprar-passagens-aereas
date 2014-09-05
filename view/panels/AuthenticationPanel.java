package project.view.panels;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AuthenticationPanel extends JPanel
{
	public AuthenticationPanel()
	{
		super(new BorderLayout());
		setBorder(new EmptyBorder(30, 150, 30, 150));
        add(new AuthenticationHeaderPanel(), BorderLayout.NORTH);
        add(new AuthenticationFormPanel(), BorderLayout.CENTER);
	}
}