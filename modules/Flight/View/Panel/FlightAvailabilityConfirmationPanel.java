package project.modules.Flight.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.Layout.AbstractGridBagLayout;
import project.modules.Application.View.Layout.ColoredGridLayout;
import project.modules.Flight.View.ActionListener.FlightAvailabilityConfirmationNavigationActionListener;
import project.modules.Flight.Entity.FlightEntity;
import project.modules.Airplane.Entity.AirplaneEntity;
import project.modules.Airport.Entity.AirportEntity;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Component;
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class FlightAvailabilityConfirmationPanel extends JPanel
{
    public FlightAvailabilityConfirmationPanel(ConfigurationEntity configuration)
    {
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        setLayout(gridBagLayout);

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
        AbstractGridBagLayout.addGridBagElement(
            this,
            buildTitleLabel(configuration.getTranslator().__("Voo")),
            gridBagLayout,
            gridBagConstraints
        );

        FlightEntity flightEntity = buildFlightEntity();
        Component[] components = {
            new JLabel(configuration.getTranslator().__("Status") + ":"),
            new JLabel(flightEntity.getStatus())
        };

        Integer[] lineColumns = {1, 2};
        AbstractGridBagLayout.addGridBagElement(
            this,
            ColoredGridLayout.build(
                ColoredGridLayout.allBorders,
                Color.BLACK,
                new Dimension(364, 30),
                lineColumns,
                new Color(204, 204, 204),
                components
            ),
            gridBagLayout,
            gridBagConstraints
        );

        components = new Component[] {
            new JLabel(configuration.getTranslator().__("Valor") + ":"),
            new JLabel("R$" + flightEntity.getValor())
        };
    }

    private JLabel buildTitleLabel(String message)
    {
        JLabel title = new JLabel(message);
        title.setFont(new Font("Arial", Font.PLAIN, 18));
        return title;
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

    private AirplaneEntity buildAirplaneEntity()
    {
        AirplaneEntity airplaneEntity = new AirplaneEntity();
        return airplaneEntity.setId(1)
                             .setDescricao("Embraer ERJ 135")
                             .setModelo("ERJ 135")
                             .setAssentosTotal(37)
                             .setAssentosVagos(12)
                             .setDataCadastro(new Date());
    }

    private AirportEntity buildAirportEntity()
    {
        AirportEntity airportEntity = new AirportEntity();
        return airportEntity.setId(1)
                            .setDescricao("Aeroporto de Congonhas")
                            .setDataCadastro(new Date());
    }
}
