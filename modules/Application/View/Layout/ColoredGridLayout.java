package project.modules.Application.View.Layout;

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

    public static JPanel build(Integer[] borderWeight,
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
                borderWeight[0], borderWeight[1], borderWeight[2], borderWeight[3],
                borderColor
            )
        );
        setBorderPanel.setPreferredSize(panelSize);

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
}
