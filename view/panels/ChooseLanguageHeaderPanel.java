package project.view.panels;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class ChooseLanguageHeaderPanel extends JPanel
{
    public ChooseLanguageHeaderPanel()
    {
        super(new GridBagLayout());
        add(new JLabel("Choose the language"));
    }
}
