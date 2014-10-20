package project.modules.Flight.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Entity.ColoredGridDependencyEntity;
import project.modules.Application.View.Layout.AbstractGridBagLayout;
import project.modules.Application.View.Layout.ColoredGridLayout;
import project.modules.Application.View.Button.ImageButton;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Application.View.Layout.ComponentCreatePattern;
import project.modules.Passenger.View.ActionListener.ResponsiblePassengerRegistrationViewActionListener;
import project.modules.Flight.View.ActionListener.FlightAvailabilityConfirmationNavigationActionListener;
import project.modules.Flight.Entity.FlightEntity;
import project.modules.Airplane.Entity.AirplaneEntity;
import project.modules.Airport.Entity.AirportEntity;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;

public class FlightAvailabilityConfirmationPanel extends JPanel
{
    public FlightAvailabilityConfirmationPanel(ConfigurationEntity configuration)
    {
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        setLayout(gridBagLayout);

        ColoredGridDependencyEntity gridEntity = new ColoredGridDependencyEntity();
        gridEntity.setBorderColor(Color.BLACK)
                  .setPanelSize(new Dimension(364, 30))
                  .setLineColumns(new Integer[] {1, 2})
                  .setBackgroundColor("gray", new Color(204, 204, 204))
                  .setBackgroundColor("white", Color.WHITE)
                  .setGridBagLayout(gridBagLayout);

        // Navigation Button
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        AbstractGridBagLayout.addGridBagElement(
            this,
            ComponentCreatePattern.buildNavigationButton(
                new FlightAvailabilityConfirmationNavigationActionListener(configuration)
            ),
            gridBagLayout,
            gridBagConstraints
        );

        // Dados do Voo
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        AbstractGridBagLayout.addGridBagElement(
            this,
            ComponentCreatePattern.buildTitleLabel(
                configuration.getTranslator().__("Voo")
            ),
            gridBagLayout,
            gridBagConstraints
        );

        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        FlightEntity flightEntity = buildFlightEntity();
        Component[][] componentsMatrix = {
            new Component[] {
                new JLabel(configuration.getTranslator().__("Status") + ":"),
                new JLabel(flightEntity.getStatus())
            },
            new Component[] {
                new JLabel(configuration.getTranslator().__("Valor") + ":"),
                new JLabel("R$" + flightEntity.getValor())
            }
        };
        ColoredGridLayout.make(
            this,
            gridEntity.setGridBagConstraints(gridBagConstraints)
                      .setComponents(componentsMatrix)
        );

        // Dados do Aeroporto
        gridBagConstraints.insets = new Insets(20, 0, 10, 0);
        AbstractGridBagLayout.addGridBagElement(
            this,
            ComponentCreatePattern.buildTitleLabel(configuration.getTranslator().__("Aeronave")),
            gridBagLayout,
            gridBagConstraints
        );

        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        componentsMatrix = new Component[][] {
            new Component[] {
                new JLabel(configuration.getTranslator().__("Descrição") + ":"),
                new JLabel(flightEntity.getAirport().getDescription())
            }
        };
        ColoredGridLayout.make(
            this,
            gridEntity.setGridBagConstraints(gridBagConstraints)
                      .setComponents(componentsMatrix)
        );

        // Dados Aeronave
        gridBagConstraints.insets = new Insets(20, 0, 10, 0);
        AbstractGridBagLayout.addGridBagElement(
            this,
            ComponentCreatePattern.buildTitleLabel(
                configuration.getTranslator().__("Aeronave")
            ),
            gridBagLayout,
            gridBagConstraints
        );

        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        componentsMatrix = new Component[][] {
            new Component[] {
                new JLabel(configuration.getTranslator().__("Código") + ":"),
                new JLabel(String.valueOf(flightEntity.getAirplane().getId()))
            },
            new Component[] {
                new JLabel(configuration.getTranslator().__("Total de Assentos") + ":"),
                new JLabel(String.valueOf(flightEntity.getAirplane().getAssentosTotal()))
            },
            new Component[] {
                new JLabel(configuration.getTranslator().__("Assentos Vagos") + ":"),
                new JLabel(String.valueOf(flightEntity.getAirplane().getAssentosVagos()))
            },
            new Component[] {
                new JLabel(configuration.getTranslator().__("Status") + ":"),
                new JLabel(String.valueOf(flightEntity.getAirplane().getStatus()))
            }
        };
        ColoredGridLayout.make(
            this,
            gridEntity.setGridBagConstraints(gridBagConstraints)
                      .setComponents(componentsMatrix)
        );

        // Buttons
        JPanel buttons = new JPanel(new FlowLayout());
        buttons.add(
            new ImageButton(
                configuration.getTranslator().__("Voltar"),
                "/images/buttonIcons/arrow-left.png",
                new Dimension(180, 40),
                new FlightAvailabilityConfirmationNavigationActionListener(configuration)
            )
        );

        buttons.add(
            new ImageButton(
                configuration.getTranslator().__("Confirmar"),
                "/images/buttonIcons/check.png",
                new Dimension(180, 40),
                new ResponsiblePassengerRegistrationViewActionListener(configuration)
            )
        );
        gridBagConstraints.insets = new Insets(10, 0, 0, 0);
        AbstractGridBagLayout.addGridBagElement(
            this,
            buttons,
            gridBagLayout,
            gridBagConstraints
        );
    }

    /**
     * Mock
     */
    private FlightEntity buildFlightEntity()
    {
        FlightEntity flightEntity = new FlightEntity();
        return flightEntity.setId(1)
                           .setAirplane(buildAirplaneEntity())
                           .setAirport(buildAirportEntity())
                           .setStatus("Transferido")
                           .setValor(199.90f)
                           .setDataPartida(new Date());
    }

    /**
     * Mock
     */
    private AirplaneEntity buildAirplaneEntity()
    {
        AirplaneEntity airplaneEntity = new AirplaneEntity();
        return airplaneEntity.setId(1)
                             .setDescricao("Embraer ERJ 135")
                             .setModelo("ERJ 135")
                             .setAssentosTotal(37)
                             .setAssentosVagos(12)
                             .setStatus("Reservado")
                             .setDataCadastro(new Date());
    }

    /**
     * Mock
     */
    private AirportEntity buildAirportEntity()
    {
        AirportEntity airportEntity = new AirportEntity();
        return airportEntity.setId(1)
                            .setDescription("Aeroporto de Congonhas")
                            .setAbbreviation("CGH")
                            .setAddress("Av. Washigton Luís s/nº São Paulo-SP")
                            .setDateRegister(new Date());
    }
}
