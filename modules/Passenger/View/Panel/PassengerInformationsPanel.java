package project.modules.Passenger.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Entity.ColoredGridDependencyEntity;
import project.modules.Application.Entity.AbstractEntity;
import project.modules.Application.View.Button.ImageButton;
import project.modules.Application.View.Layout.AbstractGridBagLayout;
import project.modules.Application.View.Layout.ComponentCreatePattern;
import project.modules.Passenger.Entity.PassengerEntity;
import project.modules.Passenger.View.ActionListener.ResponsiblePassengerRegistrationModalActionListener;
import project.modules.Passenger.View.ActionListener.PassengerRegisterModalActionListener;
import project.modules.Passenger.View.Panel.RasterizeResponsiblePassengerInformationPanel;
import project.modules.Passenger.View.Panel.RasterizeSimplePassengerInformationPanel;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.util.List;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class PassengerInformationsPanel extends JPanel
{
    public PassengerInformationsPanel(ConfigurationEntity configuration)
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
                  .setPanelSize(new Dimension(725, 30))
                  .setLineColumns(new Integer[] {1, 4})
                  .setBackgroundColor("gray", new Color(204, 204, 204))
                  .setBackgroundColor("white", Color.WHITE);

        /**
         * Título.
         */
        gridBagConstraints.fill = GridBagConstraints.CENTER;
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new Insets(10, 0, 0, 0);
        AbstractGridBagLayout.addGridBagElement(
            this,
            ComponentCreatePattern.buildTitleLabel(
                configuration.getTranslator().__("Informações dos Passageiros")
            ),
            gridBagLayout,
            gridBagConstraints
        );

        /**
         * Informações do Passageiro Responsável.
         */
        if (configuration.getEntitiesCollection().size() > 0) {
            gridBagConstraints.insets = new Insets(0, 0, 15, 0);
            AbstractGridBagLayout.addGridBagElement(
                gridEntity.setGridBagConstraints(gridBagConstraints),
                new RasterizeResponsiblePassengerInformationPanel(
                    configuration,
                    (PassengerEntity) configuration.getEntityOfCollection(0)
                )
            );
        }

        /**
         * Informações do restante dos Passageiros
         */
        List<AbstractEntity> passengerEntitiesCollection = configuration.getEntitiesCollection();
        if (passengerEntitiesCollection.size() > 1) {
            gridBagConstraints.insets = new Insets(0, 0, 15, 0);
            AbstractGridBagLayout.addGridBagElement(
                gridEntity.setGridBagConstraints(gridBagConstraints),
                new RasterizeSimplePassengerInformationPanel(
                    configuration,
                    passengerEntitiesCollection.toArray(
                        new PassengerEntity[passengerEntitiesCollection.size()]
                    )
                )
            );
        }

        /**
         * Botão para cadastro de um novo Passageiro.
         */
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
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
        AbstractGridBagLayout.addGridBagElement(
            gridEntity.setGridBagConstraints(gridBagConstraints),
            buttonsPanel
        );
    }
}
