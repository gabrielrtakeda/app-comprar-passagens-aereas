package project.modules.Passage.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Entity.ColoredGridDependencyEntity;
import project.modules.Application.View.Layout.AbstractGridBagLayout;
import project.modules.Application.View.Layout.ColoredGridLayout;
import project.modules.Application.View.Layout.ComponentCreatePattern;
import project.modules.Passage.Entity.PassageEntity;
import project.modules.Flight.Entity.FlightEntity;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Component;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class PassagePurchaseRasterizeFlightInformationPanel extends JPanel
{
    public PassagePurchaseRasterizeFlightInformationPanel(ConfigurationEntity configuration)
    {
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
                  .setPanelSize(new Dimension(725, 25))
                  .setLineColumns(new Integer[] {1, 2})
                  .setBackgroundColor("gray", new Color(204, 204, 204))
                  .setBackgroundColor("white", Color.WHITE);

        /**
         * Dados
         */
        PassageEntity passageEntity = (PassageEntity) configuration.getEntity("passage-purchase");
        FlightEntity flightEntity = (FlightEntity) passageEntity.getFlight();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Component[][] components = {
            new Component[] {
                new JLabel(configuration.getTranslator().__("Aeroporto de Origem") + ":"),
                new JLabel(flightEntity.getAirportOrigin().getDescription())
            },
            new Component[] {
                new JLabel(configuration.getTranslator().__("Aeroporto de Destino") + ":"),
                new JLabel(flightEntity.getAirportDestination().getDescription())
            },
            new Component[] {
                new JLabel(configuration.getTranslator().__("Aeronave") + ":"),
                new JLabel(flightEntity.getAirplane().getDescription())
            },
            new Component[] {
                new JLabel(configuration.getTranslator().__("Subtotal") + ":"),
                new JLabel(String.valueOf(passageEntity.getPriceTotal()))
            },
            new Component[] {
                new JLabel(configuration.getTranslator().__("Data Partida") + ":"),
                new JLabel(dateFormat.format(flightEntity.getDateDeparture()))
            },
        };
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        ColoredGridLayout.make(
            gridEntity.setGridBagConstraints(gridBagConstraints)
                      .setComponents(components)
        );
    }
}
