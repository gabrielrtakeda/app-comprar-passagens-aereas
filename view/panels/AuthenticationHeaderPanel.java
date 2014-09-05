package project.view.panels;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import project.GUI;

public class AuthenticationHeaderPanel extends JPanel
{
    public AuthenticationHeaderPanel()
    {
        super(new GridBagLayout());
        add(
            new JLabel(
                new ImageIcon(getClass().getResource("/images/lock.png"))
            )
        );
    }
}
