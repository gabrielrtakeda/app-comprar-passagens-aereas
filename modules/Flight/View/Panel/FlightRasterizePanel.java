package project.modules.Flight.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Entity.ColoredGridDependencyEntity;
import project.modules.Application.View.Layout.AbstractGridBagLayout;
import project.modules.Application.View.Layout.ColoredGridLayout;
import project.modules.Application.View.Layout.ComponentCreatePattern;
import project.modules.Application.View.Button.ImageButton;
import project.modules.Flight.Controller.FlightController;
import project.modules.Flight.Entity.FlightEntity;
import project.modules.Flight.View.ActionListener.FlightRasterizeNavigationActionListener;
import project.modules.Flight.View.ActionListener.FlightDeleteActionListener;
import project.modules.Flight.View.ActionListener.FlightRegisterActionListener;
import project.modules.Flight.Type.FlightStatusType;
import project.modules.Flight.Type.FlightButtonType;
import project.modules.Airplane.Type.AirplaneEntityComboType;
import project.modules.Airport.Type.AirportEntityComboType;
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

public class FlightRasterizePanel extends JPanel
{
    private ConfigurationEntity configuration;

    public FlightRasterizePanel(ConfigurationEntity configuration)
    {
        this.configuration = configuration;

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

        // Navigation Button
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        AbstractGridBagLayout.addGridBagElement(
            this,
            ComponentCreatePattern.buildNavigationButton(
                new FlightRasterizeNavigationActionListener(configuration)
            ),
            gridBagLayout,
            gridBagConstraints
        );

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
        FlightEntity flightEntity = (FlightEntity) configuration.getEntity("flight");

        Component[][] components = {
            new Component[] {
                new JLabel(configuration.getTranslator().__("Aeronave") + ":"),
                new JLabel(flightEntity.getAirplane().getDescription())
            },
            new Component[] {
                new JLabel(configuration.getTranslator().__("Aeroporto de Origem") + ":"),
                new JLabel(flightEntity.getAirportOrigin().getDescription())
            },
            new Component[] {
                new JLabel(configuration.getTranslator().__("Aeroporto de Destino") + ":"),
                new JLabel(flightEntity.getAirportDestination().getDescription())
            },
            new Component[] {
                new JLabel(configuration.getTranslator().__("Valor") + " (R$) :"),
                new JLabel(String.valueOf(flightEntity.getPrice()))
            },
            new Component[] {
                new JLabel(configuration.getTranslator().__("Status") + ":"),
                new JLabel(flightEntity.getStatus())
            },
            new Component[] {
                new JLabel(configuration.getTranslator().__("Data Partida") + " :"),
                new JLabel(flightEntity.getDateDeparture().toString())
            }
        };

        // Buttons
        FlightButtonType continueButton = getContinueButtonType(configuration);
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
                new FlightRasterizeNavigationActionListener(configuration)
            )
        );
        buttonsPanel.add(
            new ImageButton(
                configuration.getTranslator().__(continueButton.getText()),
                "/images/buttonIcons/check.png",
                new Dimension(225, 40),
                continueButton.getActionListener()
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

    private FlightButtonType getContinueButtonType(ConfigurationEntity configuration)
    {
        FlightButtonType continueType = new FlightButtonType();
        switch (configuration.getQueryString("flight-rasterize")) {
            case "delete":
                continueType.setText("Excluir");
                continueType.setActionListener(
                    new FlightDeleteActionListener(configuration)
                );
                break;
            default:
                continueType.setText("Confirmar");
                continueType.setActionListener(
                    new FlightRegisterActionListener(configuration)
                );
        }
        return continueType;
    }
}
