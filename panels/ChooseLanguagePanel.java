package panels;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import panels.ChooseLanguageFlagsPanel;
import panels.ChooseLanguageHeaderPanel;

public class ChooseLanguagePanel extends JPanel
{
    public ChooseLanguagePanel()
    {
        super(new BorderLayout());
        setBorder(new EmptyBorder(10, 10, 10, 10));
        add(new ChooseLanguageHeaderPanel(), BorderLayout.NORTH);
        add(new ChooseLanguageFlagsPanel(), BorderLayout.CENTER);
    }
}
