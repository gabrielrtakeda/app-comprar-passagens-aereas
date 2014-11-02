package project.modules.Passage.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Entity.ColoredGridDependencyEntity;
import project.modules.Application.View.Layout.AbstractGridBagLayout;
import project.modules.Application.View.Layout.ColoredGridLayout;
import project.modules.Application.View.Button.ImageButton;
import project.modules.Airport.Type.AirportEntityComboType;
import project.modules.Flight.View.ActionListener.FlightAvailabilityConfirmationActionListener;
import project.modules.Passage.Controller.PassageController;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Component;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PassagePurchaseFlightAvailabilityPanel extends JPanel
{
    protected ConfigurationEntity configuration;

    public PassagePurchaseFlightAvailabilityPanel(ConfigurationEntity configuration)
    {
        this.configuration = configuration;
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        setLayout(gridBagLayout);

        /**
         * Entidade de Dependência: ColoredGridLayout
         */
        ColoredGridDependencyEntity gridEntity = new ColoredGridDependencyEntity();
        gridEntity.setContainer(this)
                  .setGridBagLayout(gridBagLayout)
                  .setGridBagConstraints(gridBagConstraints)
                  .setPanelSize(new Dimension(725, 30))
                  .setLineColumns(new Integer[] {1, 4})
                  .setBackgroundColor("gray", new Color(204, 204, 204))
                  .setBackgroundColor("white", Color.WHITE);

        /**
         * Types
         */
        AirportEntityComboType[] airportTypes = getController().getAirportEntitiesComboTypeAction();
        JComboBox<AirportEntityComboType>
            airportOriginCombo = new JComboBox<AirportEntityComboType>(airportTypes);

        JComboBox<AirportEntityComboType>
            airportDestinationCombo = new JComboBox<AirportEntityComboType>(airportTypes);

        /**
         * Formulário
         */
        FlightAvailabilityConfirmationActionListener
            flightAvailabilityActionListener =
                new FlightAvailabilityConfirmationActionListener(configuration);

        Component[][] components = {
            new Component[] {
                new JLabel(configuration.getTranslator().__("Aeroporto de Origem") + ":"),
                flightAvailabilityActionListener.addComponent(
                    "airport-origin",
                    airportOriginCombo
                ),
                new JLabel(configuration.getTranslator().__("Data Partida") + ":"),
                flightAvailabilityActionListener.addComponent(
                    "date-departure",
                    new JTextField(20)
                )
            },
            new Component[] {
                new JLabel(configuration.getTranslator().__("Aeroporto de Destino") + ":"),
                flightAvailabilityActionListener.addComponent(
                    "airport-destination",
                    airportDestinationCombo
                ),
                new JLabel(),
                new JLabel()
            }
        };
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        ColoredGridLayout.make(
            gridEntity.setGridBagConstraints(gridBagConstraints)
                      .setComponents(components)
        );

        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new Insets(10, 0, 0, 0);
        AbstractGridBagLayout.addGridBagElement(
            this,
            new ImageButton(
                configuration.getTranslator().__("Validar Disponibilidade"),
                "/images/buttonIcons/check.png",
                flightAvailabilityActionListener
            ),
            gridBagLayout,
            gridBagConstraints
        );
    }

    private PassageController getController()
    {
        return new PassageController(configuration);
    }
}
