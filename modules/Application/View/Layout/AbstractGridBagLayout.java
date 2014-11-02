package project.modules.Application.View.Layout;

import project.modules.Application.Entity.ColoredGridDependencyEntity;
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
    public static void addGridBagElement(ColoredGridDependencyEntity gridEntity,
                                         Component component)
    {
        gridEntity.getGridBagLayout().setConstraints(
            component,
            gridEntity.getGridBagConstraints()
        );
        gridEntity.getContainer().add(component);
    }
}
