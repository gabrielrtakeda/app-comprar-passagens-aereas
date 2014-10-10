package project.modules.Passage.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.Button.ImageButton;
import project.modules.Application.View.Layout.AbstractGridBagLayout;
import project.modules.Application.View.Layout.ColoredGridLayout;
import project.modules.Application.View.Layout.ComponentCreatePattern;
import project.modules.Passage.View.ActionListener.PassageInformationsResultNavigationActionListener;
import project.modules.Passenger.View.Panel.PassengerInformationsResultPanel;
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

public class PassageInformationsResultPanel extends JPanel
{
    public PassageInformationsResultPanel(ConfigurationEntity configuration)
    {
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        setLayout(gridBagLayout);

        // Informações da Passagem
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        AbstractGridBagLayout.addGridBagElement(
            this,
            ComponentCreatePattern.buildTitleLabel(
                configuration.getTranslator().__("Informações da Passagem")
            ),
            gridBagLayout,
            gridBagConstraints
        );

        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        Integer[] lineColumns = {1, 4};
        Dimension lineDimension = new Dimension(725, 30);

        Component[] components = {
            new JLabel(configuration.getTranslator().__("Destino") + ":"),
            new JLabel("Aeroporto de Congonhas (Temporário)"),
            new JLabel(configuration.getTranslator().__("Data Partida") + ":"),
            new JLabel("05/01/2015 (Temporário)")
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

        // Informações dos Passageiros
        AbstractGridBagLayout.addGridBagElement(
            this,
            new PassengerInformationsResultPanel(configuration),
            gridBagLayout,
            gridBagConstraints
        );
    }
}
