package project.modules.Passage.View.Panel;

import project.modules.Application.View.Button.ImageButton;
import project.modules.Passenger.View.Panel.PassengerInformationsPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.border.LineBorder;

public class PassageInformationsPanel extends JPanel
{
    public PassageInformationsPanel()
    {
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        setLayout(gridBagLayout);

        gridBagConstraints.fill = GridBagConstraints.CENTER;
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        addGridBagElement(
            buildTitleLabel("Informações da Passagem"),
            gridBagLayout,
            gridBagConstraints
        );

        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        Integer[] containerMatrix = {1, 1};
        Integer[] allBorders = {1, 1, 1, 1};
        Integer[] sidesBorders = {0, 1, 0, 1};
        Integer[] bottomSidesBorders = {1, 1, 0, 1};
        Integer[] lineColumns = {1, 4};
        Dimension lineDimension = new Dimension(725, 30);

        String[] destinos = {
            "Aeroporto de Congonhas",
            "Aeroporto de Guarulhos",
            "Aeroporto de Melborn",
            "Aeroporto de Los Angeles"
        };
        JComboBox<String> destinosComboBox = new JComboBox<String>(destinos);

        Component[] components = {
            new JLabel("Destino:"),
            destinosComboBox,
            new JLabel("Data Partida:"),
            new JTextField(20)
        };
        addGridBagElement(
            buildColoredGridLayoutPanel(
                containerMatrix,
                allBorders,
                Color.BLACK,
                lineDimension,
                lineColumns,
                new Color(204, 204, 204),
                components
            ),
            gridBagLayout,
            gridBagConstraints
        );

        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        addGridBagElement(
            new ImageButton(
                "Validar Disponibilidade",
                "/images/buttonIcons/check.png"
            ),
            gridBagLayout,
            gridBagConstraints
        );

        addGridBagElement(
            new PassengerInformationsPanel(),
            gridBagLayout,
            gridBagConstraints
        );
    }

    private JLabel buildTitleLabel(String message)
    {
        JLabel label = new JLabel(message);
        label.setFont(new Font("Arial", Font.PLAIN, 19));
        return label;
    }

    private JPanel buildColoredGridLayoutPanel(Integer[] containerMatrix,
                                               Integer[] borderWeight,
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

        // Seta o background color;
        // Seta padding;
        // Adiciona os componentes.
        JPanel marginPanel = new JPanel(
            new GridLayout(lineColumns[0], lineColumns[1])
        );
        marginPanel.setBorder(BorderFactory.createEmptyBorder(0, 8, 0, 8));
        marginPanel.setBackground(backgroundColor);
        for (Component component : components) {
            marginPanel.add(component);
        }
        setBorderPanel.add(marginPanel);

        return setBorderPanel;
    }

    private void addGridBagElement(Component component,
                                   GridBagLayout gridBagLayout,
                                   GridBagConstraints gridBagConstraints)
    {
        gridBagLayout.setConstraints(component, gridBagConstraints);
        add(component);
    }
}
