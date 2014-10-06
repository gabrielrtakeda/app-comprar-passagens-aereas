package project.modules.Flight.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Entity.ColoredGridDependencyEntity;
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
import java.awt.Insets;
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
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
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

        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        Dimension panelSize = new Dimension(364, 30);
        Integer[] lineColumns = {1, 2};
        AbstractGridBagLayout.addGridBagElement(
            this,
            ColoredGridLayout.build(
                ColoredGridLayout.allBorders,
                Color.BLACK,
                panelSize,
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
        AbstractGridBagLayout.addGridBagElement(
            this,
            ColoredGridLayout.build(
                ColoredGridLayout.exceptTopBorders,
                Color.BLACK,
                panelSize,
                lineColumns,
                Color.WHITE,
                components
            ),
            gridBagLayout,
            gridBagConstraints
        );

        // Dados do Aeroporto
        gridBagConstraints.insets = new Insets(20, 0, 10, 0);
        AbstractGridBagLayout.addGridBagElement(
            this,
            buildTitleLabel(configuration.getTranslator().__("Aeronave")),
            gridBagLayout,
            gridBagConstraints
        );

        components = new Component[] {
            new JLabel(configuration.getTranslator().__("Descrição") + ":"),
            new JLabel(flightEntity.getAirport().getDescricao())
        };

        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        AbstractGridBagLayout.addGridBagElement(
            this,
            ColoredGridLayout.build(
                ColoredGridLayout.allBorders,
                Color.BLACK,
                panelSize,
                lineColumns,
                new Color(204, 204, 204),
                components
            ),
            gridBagLayout,
            gridBagConstraints
        );

        // Dados Aeronave
        gridBagConstraints.insets = new Insets(20, 0, 10, 0);
        AbstractGridBagLayout.addGridBagElement(
            this,
            buildTitleLabel(configuration.getTranslator().__("Aeronave")),
            gridBagLayout,
            gridBagConstraints
        );

        components = new Component[] {
            new JLabel(configuration.getTranslator().__("Código") + ":"),
            new JLabel(String.valueOf(flightEntity.getAirplane().getId()))
        };

        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        AbstractGridBagLayout.addGridBagElement(
            this,
            ColoredGridLayout.build(
                ColoredGridLayout.allBorders,
                Color.BLACK,
                panelSize,
                lineColumns,
                new Color(204, 204, 204),
                components
            ),
            gridBagLayout,
            gridBagConstraints
        );

        Component[][] componentsRox = {
            new Component[] {
                new JButton(configuration.getTranslator().__("Código") + ":"),
                new JLabel(String.valueOf(flightEntity.getAirplane().getId()))
            },
            new Component[] {
                new JLabel(configuration.getTranslator().__("Código") + ":"),
                new JLabel(String.valueOf(flightEntity.getAirplane().getId()))
            },
            new Component[] {
                new JLabel(configuration.getTranslator().__("Código") + ":"),
                new JLabel(String.valueOf(flightEntity.getAirplane().getId()))
            },
            new Component[] {
                new JButton(configuration.getTranslator().__("Código") + ":"),
                new JButton(String.valueOf(flightEntity.getAirplane().getId()))
            }
        };

        ColoredGridDependencyEntity gridEntity = new ColoredGridDependencyEntity();
        gridEntity.setBorderColor(Color.BLACK)
                  .setPanelSize(new Dimension(364, 30))
                  .setLineColumns(new Integer[] {1, 2})
                  .setBackgroundColor("gray", new Color(204, 204, 204))
                  .setBackgroundColor("white", Color.WHITE)
                  .setComponents(components)
                  .setGridBagLayout(gridBagLayout)
                  .setGridBagConstraints(gridBagConstraints);

        buildZebraTable(this, gridEntity);
    }

    private void buildZebraTable(JPanel container, ColoredGridDependencyEntity gridEntity)
    {
        Integer count = 0;
        for (Component[] fatherComponents : gridEntity.getComponents()) {
            for (Component childComponents : fatherComponents) {
                if (count == 0) {
                    AbstractGridBagLayout.addGridBagElement(
                        container,
                        ColoredGridLayout.build(
                            ColoredGridLayout.allBorders,
                            gridEntity.getBorderColor(),
                            gridEntity.getPanelSize(),
                            gridEntity.getLineColumns(),
                            gridEntity.getBackgroundColor("gray"),
                            childComponents
                        ),
                        gridEntity.gridBagLayout,
                        gridEntity.gridBagConstraints
                    );
                    System.out.println("0: " + childComponents.getClass().getName());
                } else if (count == (components.length - 1)) {
                    System.out.println((components.length - 1) + ": " + childComponents.getClass().getName());
                } else {
                    System.out.println("midle: " + childComponents.getClass().getName());
                }
            }
            count++;
        }
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
