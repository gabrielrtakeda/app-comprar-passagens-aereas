package project.modules.ChooseLanguage.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.ChooseLanguage.View.ActionListener.ChooseLanguageActionListener;
import java.awt.Dimension;
import javax.swing.border.EmptyBorder;

public class ChooseLanguageWidgetPanel extends AbstractChooseLanguageFlagsPanel
{
    public ChooseLanguageWidgetPanel(ConfigurationEntity configuration)
    {
        super(
            configuration,
            new EmptyBorder(0, 0, 0, 0),
            "22x16",
            new Dimension(22, 16),
            ChooseLanguageActionListener.USING_WIDGET
        );
    }
}
