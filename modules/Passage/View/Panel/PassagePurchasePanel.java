package project.modules.Passage.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Entity.ColoredGridDependencyEntity;
import project.modules.Application.View.Button.ImageButton;
import project.modules.Application.View.Layout.AbstractGridBagLayout;
import project.modules.Application.View.Layout.ColoredGridLayout;
import project.modules.Application.View.Layout.ComponentCreatePattern;
import project.modules.Passage.Controller.PassageController;
import project.modules.Passage.Entity.PassageEntity;
import project.modules.Passage.View.ActionListener.PassageInformationsNavigationActionListener;
import project.modules.Passenger.View.Panel.PassengerInformationsPanel;
import project.modules.Flight.View.ActionListener.FlightAvailabilityConfirmationActionListener;
import project.modules.Airport.Type.AirportEntityComboType;
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

public class PassagePurchasePanel extends JPanel
{
    private ConfigurationEntity configuration;

    public PassagePurchasePanel(ConfigurationEntity configuration)
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
         * Navigation Button
         */
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        AbstractGridBagLayout.addGridBagElement(
            gridEntity.setGridBagConstraints(
                gridBagConstraints
            ),
            ComponentCreatePattern.buildNavigationButton(
                new PassageInformationsNavigationActionListener(configuration)
            )
        );

        /**
         * Título
         */
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        AbstractGridBagLayout.addGridBagElement(
            gridEntity.setGridBagConstraints(
                gridBagConstraints
            ),
            ComponentCreatePattern.buildTitleLabel(
                configuration.getTranslator().__("Informações da Passagem")
            )
        );

        /**
         * Types
         */
        if (configuration.hasEntity("passage-purchase")) {
            System.out.println("entrou");
            AbstractGridBagLayout.addGridBagElement(
                gridEntity,
                new PassagePurchaseRasterizeFlightInformationPanel(configuration)
            );
        } else {
            System.out.println("nao entrou");
            AbstractGridBagLayout.addGridBagElement(
                gridEntity,
                new PassagePurchaseFlightAvailabilityPanel(configuration)
            );
        }

        AbstractGridBagLayout.addGridBagElement(
            this,
            new PassengerInformationsPanel(configuration),
            gridBagLayout,
            gridBagConstraints
        );
    }

    private PassageController getController()
    {
        return new PassageController(configuration);
    }
}
