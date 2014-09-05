package project.view.panels;

import java.awt.BorderLayout;
import javax.swing.JPanel;

public class AuthenticationPanel extends JPanel
{
    public AuthenticationPanel()
    {
        super(new BorderLayout());
        add(new AuthenticationHeaderPanel());
    }
}
