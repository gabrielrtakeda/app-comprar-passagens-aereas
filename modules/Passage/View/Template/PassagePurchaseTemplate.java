package project.modules.Passage.View.Template;

import project.modules.Application.View.Template.AbstractTemplate;
import project.modules.Application.View.Panel.ApplicationBaseLayoutHeaderPanel;
import project.modules.Application.View.Panel.ApplicationBaseLayoutFooterPanel;
import project.modules.Passage.View.Panel.PassageInformationsPanel;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;

public class PassagePurchaseTemplate extends AbstractTemplate
{
    public PassagePurchaseTemplate()
    {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        add(new ApplicationBaseLayoutHeaderPanel(), BorderLayout.NORTH);
        add(new ApplicationBaseLayoutFooterPanel(), BorderLayout.SOUTH);
        add(new PassageInformationsPanel(), BorderLayout.CENTER);
    }
}
