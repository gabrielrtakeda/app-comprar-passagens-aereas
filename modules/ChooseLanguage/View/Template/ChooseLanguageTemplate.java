package project.modules.ChooseLanguage.View.Template;

import project.modules.ChooseLanguage.View.Panel.ChooseLanguageFlagsPanel;
import project.modules.ChooseLanguage.View.Panel.ChooseLanguageHeaderPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ChooseLanguageTemplate extends JPanel
{
    public ChooseLanguageTemplate()
    {
        super(new BorderLayout());
        setBorder(new EmptyBorder(10, 10, 10, 10));
        add(new ChooseLanguageHeaderPanel(), BorderLayout.NORTH);
        add(new ChooseLanguageFlagsPanel(), BorderLayout.CENTER);
    }
}
