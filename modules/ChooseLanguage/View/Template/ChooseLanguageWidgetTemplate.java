package project.modules.ChooseLanguage.View.Template;

import project.modules.Application.View.Template.AbstractTemplate;
import project.modules.ChooseLanguage.View.Panel.ChooseLanguageWidgetPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ChooseLanguageWidgetTemplate extends AbstractTemplate
{
    public ChooseLanguageWidgetTemplate()
    {
        setLayout(new BorderLayout());
        add(new ChooseLanguageWidgetPanel(), BorderLayout.CENTER);
    }
}
