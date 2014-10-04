package project.modules.Passage.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.Button.ImageButton;
import project.modules.Application.View.Layout.AbstractGridBagLayout;
import project.modules.Application.View.Layout.ColoredGridLayout;
import project.modules.Passage.View.ActionListener.PassageInformationsNavigationActionListener;
import project.modules.Passenger.View.Panel.PassengerInformationsPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class PassageInformationsPanel extends JPanel
{
    public PassageInformationsPanel(ConfigurationEntity configuration)
    {
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        setLayout(gridBagLayout);

        JPanel navigationButton = new JPanel(new BorderLayout());
        navigationButton.add(
            buildNavigationButton(configuration),
            BorderLayout.WEST
        );
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.gridwidth  =GridBagConstraints.REMAINDER;
        AbstractGridBagLayout.addGridBagElement(
            this,
            navigationButton,
            gridBagLayout,
            gridBagConstraints
        );

        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        AbstractGridBagLayout.addGridBagElement(
            this,
            buildTitleLabel(
                configuration.getTranslator().__("Informações da Passagem")
            ),
            gridBagLayout,
            gridBagConstraints
        );

        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
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
            new JLabel(configuration.getTranslator().__("Destino") + ":"),
            destinosComboBox,
            new JLabel(configuration.getTranslator().__("Data Partida") + ":"),
            new JTextField(20)
        };
        AbstractGridBagLayout.addGridBagElement(
            this,
            ColoredGridLayout.build(
                ColoredGridLayout.allBorders,
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
        AbstractGridBagLayout.addGridBagElement(
            this,
            new ImageButton(
                configuration.getTranslator().__("Validar Disponibilidade"),
                "/images/buttonIcons/check.png"
            ),
            gridBagLayout,
            gridBagConstraints
        );

        AbstractGridBagLayout.addGridBagElement(
            this,
            new PassengerInformationsPanel(configuration),
            gridBagLayout,
            gridBagConstraints
        );
    }

    private JLabel buildTitleLabel(String message)
    {
        JLabel label = new JLabel(message);
        label.setFont(new Font("Arial", Font.PLAIN, 18));
        return label;
    }

    private JButton buildNavigationButton(ConfigurationEntity configuration)
    {
        JButton backButton = new JButton(
            new ImageIcon(getClass().getResource("/images/buttonIcons/arrow-left.png"))
        );
        backButton.setPreferredSize(new Dimension(25, 25));
        backButton.setFocusable(false);
        backButton.setActionCommand("back");
        backButton.addActionListener(
            new PassageInformationsNavigationActionListener(configuration)
        );
        return backButton;
    }
}
