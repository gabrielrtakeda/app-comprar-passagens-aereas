package project.view.panels;

import javax.swing.JPanel;
import javax.swing.JLabel;
import project.GUI;

public class AuthenticationHeaderPanel extends JPanel
{
    public AuthenticationHeaderPanel()
    {
        add(new JLabel(GUI.language));
    }
}
