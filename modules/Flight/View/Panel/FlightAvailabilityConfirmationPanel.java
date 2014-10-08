package project.modules.Flight.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Entity.ColoredGridDependencyEntity;
import project.modules.Application.View.Layout.AbstractGridBagLayout;
import project.modules.Application.View.Layout.ColoredGridLayout;
import project.modules.Flight.View.ActionListener.FlightAvailabilityConfirmationNavigationActionListener;
import project.modules.Flight.Entity.FlightEntity;
import project.modules.Airplane.Entity.AirplaneEntity;
import project.modules.Airport.Entity.AirportEntity;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
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
            buildNavigationButton(configuration),
            gridBagLayout,
            gridBagConstraints
        );

        // Dados do Voo
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        AbstractGridBagLayout.addGridBagElement(
            this,
            buildTitleLabel(configuration.getTranslator().__("Voo")),
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
            buildTitleLabel(configuration.getTranslator().__("Aeronave")),
            gridBagLayout,
            gridBagConstraints
        );

        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        componentsMatrix = new Component[][] {
            new Component[] {
                new JLabel(configuration.getTranslator().__("Descrição") + ":"),
                new JLabel(flightEntity.getAirport().getDescricao())
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
            buildTitleLabel(configuration.getTranslator().__("Aeronave")),
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

        // Reserva
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new Insets(20, 5, 10, 0);
        AbstractGridBagLayout.addGridBagElement(
            this,
            buildTitleLabel(configuration.getTranslator().__("Reserva")),
            gridBagLayout,
            gridBagConstraints
        );

        gridBagConstraints.insets = new Insets(0, 5, 0, 0);
        JPanel bookingPanel = new JPanel(new GridLayout(1, 2));
        bookingPanel.add(buildTextLabel(configuration.getTranslator().__("Quantidade de assentos a reservar") + ":"));
        bookingPanel.add(new JTextField(2));
        AbstractGridBagLayout.addGridBagElement(
            this,
            bookingPanel,
            gridBagLayout,
            gridBagConstraints
        );
    }

    private JLabel buildTitleLabel(String message)
    {
        JLabel title = new JLabel(message);
        title.setFont(new Font("Arial", Font.PLAIN, 18));
        return title;
    }

    private JLabel buildTextLabel(String message)
    {
        JLabel text = new JLabel(message);
        text.setFont(new Font("Arial", Font.PLAIN, 10));
        return text;
    }

    private JButton buildNavigationButton(ConfigurationEntity configuration)
    {
        JButton navigationButton = new JButton(
            new ImageIcon(getClass().getResource("/images/buttonIcons/arrow-left.png"))
        );
        navigationButton.setPreferredSize(new Dimension(25, 25));
        navigationButton.setFocusable(false);
        navigationButton.setActionCommand("back");
        navigationButton.addActionListener(
            new FlightAvailabilityConfirmationNavigationActionListener(configuration)
        );
        return navigationButton;
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
                            .setDescricao("Aeroporto de Congonhas")
                            .setDataCadastro(new Date());
    }
}
