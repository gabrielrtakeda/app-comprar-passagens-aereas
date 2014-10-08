package project.modules.Application.View.Layout;

import project.modules.Application.Entity.ColoredGridDependencyEntity;
import project.modules.Application.View.Layout.AbstractGridBagLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.BorderFactory;

public class ColoredGridLayout
{
    public static Integer[] allBorders = {1, 1, 1, 1};
    public static Integer[] sidesBorders = {0, 1, 0, 1};
    public static Integer[] exceptTopBorders = {0, 1, 1, 1};

    public ColoredGridLayout()
    {}

    public static JPanel build(Integer[] borderPosition,
                               Color borderColor,
                               Dimension panelSize,
                               Integer[] lineColumns,
                               Color backgroundColor,
                               Component[] components)
    {
        // Seta as bordas
        JPanel setBorderPanel = new JPanel(new BorderLayout());
        setBorderPanel.setBorder(
            BorderFactory.createMatteBorder(
                borderPosition[0], borderPosition[1], borderPosition[2], borderPosition[3],
                borderColor
            )
        );
        if (panelSize != null) {
            setBorderPanel.setPreferredSize(panelSize);
        }

        JPanel marginPanel = new JPanel(
            new GridLayout(lineColumns[0], lineColumns[1])
        );
        // Padding
        marginPanel.setBorder(BorderFactory.createEmptyBorder(0, 8, 0, 8));
        // Border
        marginPanel.setBackground(backgroundColor);

        // Adiciona os componentes
        for (Component component : components) {
            marginPanel.add(component);
        }

        setBorderPanel.add(marginPanel);

        return setBorderPanel;
    }

    public static void make(JPanel container, ColoredGridDependencyEntity gridEntity)
    {
        Integer count = 0;
        for (Component[] components : gridEntity.getComponents()) {
            AbstractGridBagLayout.addGridBagElement(
                container,
                build(
                    count == 0
                        ? ColoredGridLayout.allBorders
                        : ColoredGridLayout.exceptTopBorders,
                    gridEntity.getBorderColor(),
                    gridEntity.getPanelSize(),
                    gridEntity.getLineColumns(),
                    count % 2 == 0
                        ? gridEntity.getBackgroundColor("gray")
                        : gridEntity.getBackgroundColor("white"),
                    components
                ),
                gridEntity.getGridBagLayout(),
                gridEntity.getGridBagConstraints()
            );
            count++;
        }
    }
}
