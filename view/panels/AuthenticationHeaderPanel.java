package project.view.panels;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;

public class AuthenticationHeaderPanel extends JPanel
{
    public AuthenticationHeaderPanel()
    {
    	setBorder(new EmptyBorder(0, 0, 10, 0));
        add(
        	new JLabel(
        		new ImageIcon(getClass().getResource("/images/lock.png"))
        	)
        );
    }
}
