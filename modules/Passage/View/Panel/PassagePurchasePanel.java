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
import project.modules.Passenger.View.Panel.PassengerInformationsResultPanel;
import project.modules.Passenger.View.ActionListener.PassengerRegisterModalActionListener;
import project.modules.Passenger.View.ActionListener.ResponsiblePassengerRegistrationModalActionListener;
import project.modules.Flight.View.ActionListener.FlightAvailabilityConfirmationActionListener;
import project.modules.Airport.Type.AirportEntityComboType;
import java.awt.FlowLayout;
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
            gridEntity.setGridBagConstraints(gridBagConstraints),
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
            gridEntity.setGridBagConstraints(gridBagConstraints),
            ComponentCreatePattern.buildTitleLabel(
                configuration.getTranslator().__("Informações da Passagem")
            )
        );

        /**
         * Exibe informações do Voo.
         */
        if (configuration.hasEntity("passage-purchase")) {
            AbstractGridBagLayout.addGridBagElement(
                gridEntity.setGridBagConstraints(gridBagConstraints),
                new PassagePurchaseRasterizeFlightInformationPanel(configuration)
            );
        } else {
            AbstractGridBagLayout.addGridBagElement(
                gridEntity.setGridBagConstraints(gridBagConstraints),
                new PassagePurchaseFlightAvailabilityPanel(configuration)
            );
        }

        /**
         * Exibe informações dos Passageiros.
         */
        AbstractGridBagLayout.addGridBagElement(
            gridEntity.setGridBagConstraints(gridBagConstraints),
            configuration.getEntitiesCollection().size() < 1
             ? new PassengerInformationsPanel(configuration)
             : new PassengerInformationsResultPanel(configuration)
        );

        /**
         * Botões de ação.
         */
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        AbstractGridBagLayout.addGridBagElement(
            gridEntity.setGridBagConstraints(gridBagConstraints),
            buildButtonsPanel()
        );
    }

    private JPanel buildButtonsPanel()
    {
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        buttonsPanel.add(
            new ImageButton(
                configuration.getTranslator().__("Cadastrar Passageiros"),
                "/images/buttonIcons/user.png",
                new Dimension(145, 45),
                configuration.hasQueryString("passenger-register:responsible-passenger")
                    ? new PassengerRegisterModalActionListener(configuration)
                    : new ResponsiblePassengerRegistrationModalActionListener(configuration)
            )
        );
        buttonsPanel.add(
            new ImageButton(
                configuration.getTranslator().__("Efetuar Compra"),
                "/images/buttonIcons/basket.png",
                new Dimension(145, 45)
            )
        );
        return buttonsPanel;
    }

    private PassageController getController()
    {
        return new PassageController(configuration);
    }
}
