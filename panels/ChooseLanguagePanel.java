package panels;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import panels.ChooseLanguageFlagsPanel;
import panels.ChooseLanguageHeaderPanel;

public class ChooseLanguagePanel extends JPanel implements JPanelInterface
{
    public ChooseLanguagePanel()
    {
        super(new GridLayout(2, 1));
        setBorder(new EmptyBorder(10, 10, 10, 10));
        add(new ChooseLanguageHeaderPanel().get());
        add(new ChooseLanguageFlagsPanel().get());
    }

    public JPanel get()
    {
        return this;
    }
}
