package project.modules.Flight.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Entity.ColoredGridDependencyEntity;
import project.modules.Application.View.Layout.AbstractGridBagLayout;
import project.modules.Application.View.Layout.ColoredGridLayout;
import project.modules.Application.View.Layout.ComponentCreatePattern;
import project.modules.Application.View.Button.ImageButton;
import project.modules.Flight.View.ActionListener.FlightRegisterNavigationActionListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class FlightRegisterPanel extends JPanel
{
    public FlightRegisterPanel(ConfigurationEntity configuration)
    {
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        setLayout(gridBagLayout);

        ColoredGridDependencyEntity gridEntity = new ColoredGridDependencyEntity();
        gridEntity.setGridBagLayout(gridBagLayout)
                  .setGridBagConstraints(gridBagConstraints)
                  .setPanelSize(new Dimension(450, 30))
                  .setLineColumns(new Integer[] {1, 2})
                  .setBackgroundColor("gray", new Color(204, 204, 204))
                  .setBackgroundColor("white", Color.WHITE);

        // Título
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        AbstractGridBagLayout.addGridBagElement(
            this,
            ComponentCreatePattern.buildTitleLabel(
                configuration.getTranslator().__("Dados do Voo")
            ),
            gridBagLayout,
            gridBagConstraints
        );

        // Form
        Component[][] components = {
            new Component[] {
                new JLabel(configuration.getTranslator().__("Aeronave") + ":"),
                new JComboBox<String>(buildAirplaneData())
            },
            new Component[] {
                new JLabel(configuration.getTranslator().__("Aeroporto de Destino") + ":"),
                new JComboBox<String>(buildAirportData())
            },
            new Component[] {
                new JLabel(configuration.getTranslator().__("Status") + ":"),
                new JComboBox<String>(buildStatusOptions(configuration))
            },
            new Component[] {
                new JLabel(configuration.getTranslator().__("Valor") + " (R$) :"),
                new JTextField()
            }
        };

        // Buttons
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        ColoredGridLayout.make(
            this,
            gridEntity.setComponents(components)
        );

        JPanel buttonsPanel = new JPanel(new FlowLayout());
        buttonsPanel.add(
            new ImageButton(
                configuration.getTranslator().__("Voltar"),
                "/images/buttonIcons/arrow-left.png",
                new Dimension(225, 40),
                new FlightRegisterNavigationActionListener(configuration)
            )
        );
        buttonsPanel.add(
            new ImageButton(
                configuration.getTranslator().__("Continuar"),
                "/images/buttonIcons/check.png",
                new Dimension(225, 40)
            )
        );
        gridBagConstraints.insets = new Insets(10, 0, 0, 0);
        AbstractGridBagLayout.addGridBagElement(
            this,
            buttonsPanel,
            gridBagLayout,
            gridBagConstraints
        );
    }

    /**
     * Mock
     */
    private String[] buildAirplaneData()
    {
        return new String[]
        {
            "ERJ 135", "ERJ 140", "ERJ 145", "ERJ 145 XR",
            "E170", "E175", "E190", "E195",
            "E175-E2", "E190-E2", "E195-E2"
        };
    }

    /**
     * Mock
     */
    private String[] buildAirportData()
    {
        return new String[]
        {
            "Aeroporto Internacional de San Francisco",
            "Aeroporto Internacional John F. Kennedy",
            "Aeroporto de LaGuardia",
            "Aeroporto Internacional de Newark",
            "Aeroporto Internacional Logan",
            "Aeroporto Internacional O'Hare",
            "Aeroporto Internacional Washington Dulles",
            "Aeroporto Ronald Reagan",
            "Aeroporto Internacional William B Hartsfield",
            "Aeroporto Internacional de Orlando",
            "Aeroporto Internacional de Miami",
            "Aeroporto Internacional George Bush",
            "Aeroporto Internacional de Dallas-Fort Worth",
            "Aeroporto Internacional de Los Angeles",
            "Aeroporto Internacional McCarran",
            "Aeroporto Internacional de Honolulu",
            "Aeroporto Internacional de San Francisco",
            "Aeroporto Internacional Tacoma",
            "Aeroporto Internacional de Denver",
            "Aeroporto Internacional de Sky Harbor",
            "Aeroporto Internacional Midway",
            "Aeroporto Internacional de Salt Lake City"
        };
    }

    /**
     * Mock
     */
    private String[] buildStatusOptions(ConfigurationEntity configuration)
    {
        return new String[]
        {
            configuration.getTranslator().__("Cancelado"),
            configuration.getTranslator().__("Adiado"),
            configuration.getTranslator().__("Prorrogado"),
            configuration.getTranslator().__("Suspenso"),
            configuration.getTranslator().__("Transferido"),
            configuration.getTranslator().__("Pendente")
        };
    }
}
