package project.modules.Flight.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Entity.ColoredGridDependencyEntity;
import project.modules.Application.View.Layout.AbstractGridBagLayout;
import project.modules.Application.View.Layout.ColoredGridLayout;
import project.modules.Application.View.Layout.ComponentCreatePattern;
import project.modules.Application.View.Button.ImageButton;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Flight.Controller.FlightController;
import project.modules.Flight.View.ActionListener.FlightRegisterNavigationActionListener;
import project.modules.Flight.View.ActionListener.FlightRasterizeActionListener;
import project.modules.Flight.Type.FlightStatusType;
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

public class FlightRegisterPanel extends JPanel
{
    private ConfigurationEntity configuration;

    public FlightRegisterPanel(ConfigurationEntity configuration)
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
                new FlightRegisterNavigationActionListener(configuration)
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
        AirportEntityComboType[]
            airportTypes = getController().getAirportEntitiesComboTypeAction();

        AbstractActionListener
            rasterizeActionListener = new FlightRasterizeActionListener(configuration);

        Component[][] components = {
            new Component[] {
                new JLabel(configuration.getTranslator().__("Aeronave") + ":"),
                rasterizeActionListener.addComponent(
                    "airplane",
                    new JComboBox<AirplaneEntityComboType>(
                        getController().getAirplaneEntitiesComboTypeAction()
                    )
                )
            },
            new Component[] {
                new JLabel(configuration.getTranslator().__("Aeroporto de Origem") + ":"),
                rasterizeActionListener.addComponent(
                    "airport-origin",
                    new JComboBox<AirportEntityComboType>(airportTypes)
                )
            },
            new Component[] {
                new JLabel(configuration.getTranslator().__("Aeroporto de Destino") + ":"),
                rasterizeActionListener.addComponent(
                    "airport-destination",
                    new JComboBox<AirportEntityComboType>(airportTypes)
                )
            },
            new Component[] {
                new JLabel(configuration.getTranslator().__("Valor") + " (R$) :"),
                rasterizeActionListener.addComponent(
                    "price",
                    new JTextField()
                )
            },
            new Component[] {
                new JLabel(configuration.getTranslator().__("Status") + ":"),
                rasterizeActionListener.addComponent(
                    "status",
                    new JComboBox<FlightStatusType>(
                        getController().getFlightStatusTypesAction()
                    )
                )
            },
            new Component[] {
                new JLabel(configuration.getTranslator().__("Data Partida") + " :"),
                rasterizeActionListener.addComponent(
                    "date-departure",
                    new JTextField()
                )
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
                new Dimension(225, 40),
                rasterizeActionListener
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

    public FlightController getController()
    {
        return new FlightController(configuration);
    }
}
