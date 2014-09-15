package project.modules.Application.View.Layout;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Component;
import javax.swing.JPanel;

public class AbstractGridBagLayout
{
    public static void addGridBagElement(JPanel panel,
                                         Component component,
                                         GridBagLayout gridBagLayout,
                                         GridBagConstraints gridBagConstraints)
    {
        gridBagLayout.setConstraints(component, gridBagConstraints);
        panel.add(component);
    }
}
