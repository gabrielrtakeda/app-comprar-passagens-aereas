package project.modules.Passage.View.Template;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.Template.AbstractTemplate;
import project.modules.Application.View.Panel.ApplicationBaseLayoutHeaderPanel;
import project.modules.Application.View.Panel.ApplicationBaseLayoutFooterPanel;
import project.modules.Passage.View.Panel.PassageInformationsPanel;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;

public class PassagePurchaseTemplate extends AbstractTemplate
{
    public PassagePurchaseTemplate(ConfigurationEntity configuration)
    {
        setConfiguration(configuration.setTemplate(this));
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        add(new ApplicationBaseLayoutHeaderPanel(configuration), BorderLayout.NORTH);
        add(new ApplicationBaseLayoutFooterPanel(configuration), BorderLayout.SOUTH);
        add(new PassageInformationsPanel(configuration), BorderLayout.CENTER);
    }
}
