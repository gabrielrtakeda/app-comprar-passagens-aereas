package project.modules.ChooseLanguage.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import java.awt.Dimension;
import javax.swing.border.EmptyBorder;

public class ChooseLanguageFlagsPanel extends AbstractChooseLanguageFlagsPanel
{
    public ChooseLanguageFlagsPanel(ConfigurationEntity configuration)
    {
        super(
            configuration,
            new EmptyBorder(10, 0, 0, 0),
            "128x128",
            new Dimension(130, 130)
        );
    }
}
