package project.modules.Passenger.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Entity.ColoredGridDependencyEntity;
import project.modules.Application.View.Button.ImageButton;
import project.modules.Application.View.Layout.AbstractGridBagLayout;
import project.modules.Application.View.Layout.ColoredGridLayout;
import project.modules.Application.View.Layout.ComponentCreatePattern;
import project.modules.Passenger.Controller.PassengerController;
import project.modules.Passenger.Entity.PassengerEntity;
import project.modules.Passenger.View.ActionListener.PassengerRegisterModalActionListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Component;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class PassengerInformationsResultPanel extends JPanel
{
    private ConfigurationEntity configuration;

    public PassengerInformationsResultPanel(ConfigurationEntity configuration)
    {
        this.configuration = configuration;
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        setLayout(gridBagLayout);

        // Entidade do Grid
        ColoredGridDependencyEntity gridEntity = new ColoredGridDependencyEntity();
        gridEntity.setContainer(this)
                  .setGridBagLayout(gridBagLayout)
                  .setGridBagConstraints(gridBagConstraints)
                  .setPanelSize(new Dimension(725, 23))
                  .setLineColumns(new Integer[] {1, 4})
                  .setBackgroundColor("gray", new Color(204, 204, 204))
                  .setBackgroundColor("white", Color.WHITE);

        // Informações dos Passageiros
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        AbstractGridBagLayout.addGridBagElement(
            this,
            ComponentCreatePattern.buildTitleLabel(
                configuration.getTranslator().__("Informações dos Passageiros")
            ),
            gridBagLayout,
            gridBagConstraints
        );

        /**
         * Quantidade de Passageiros por perfil.
         */
        Map<String, Integer> profilesQuantityMap = getController().getQuantityOfEachProfileAction();
        List<Component[]> components = new ArrayList<Component[]>();
        /**
         * Perfil Adulto.
         */
        components.add(
            new Component[] {
                new JLabel(configuration.getTranslator().__("Perfil") + ":"),
                new JLabel(configuration.getTranslator().__("Adulto")),
                new JLabel(configuration.getTranslator().__("Total de Passageiros") + ":"),
                new JLabel(String.valueOf(profilesQuantityMap.get("adult")))
            }
        );
        /**
         * Perfil Criança.
         */
        components.add(
            new Component[] {
                new JLabel(configuration.getTranslator().__("Perfil") + ":"),
                new JLabel(configuration.getTranslator().__("Criança")),
                new JLabel(configuration.getTranslator().__("Total de Passageiros") + ":"),
                new JLabel(String.valueOf(profilesQuantityMap.get("child")))
            }
        );
        /**
         * Perfil Bebê.
         */
        components.add(
            new Component[] {
                new JLabel(configuration.getTranslator().__("Perfil") + ":"),
                new JLabel(configuration.getTranslator().__("Bebê")),
                new JLabel(configuration.getTranslator().__("Total de Passageiros") + ":"),
                new JLabel(String.valueOf(profilesQuantityMap.get("baby")))
            }
        );
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        ColoredGridLayout.make(
            gridEntity.setGridBagConstraints(gridBagConstraints)
                      .setComponents(components.toArray(new Component[components.size()][]))
        );

        /**
         * Passageiro Responsável
         */
        AbstractGridBagLayout.addGridBagElement(
            gridEntity.setGridBagConstraints(gridBagConstraints),
            new RasterizeResponsiblePassengerInformationPanel(
                configuration,
                getController().getResponsiblePassengerEntityAction()
            )
        );

        /**
         * Passageiros Simples
         */
        AbstractGridBagLayout.addGridBagElement(
            gridEntity.setGridBagConstraints(gridBagConstraints),
            new RasterizeSimplePassengerInformationPanel(
                configuration,
                getController().getSimplePassengerEntitiesAction()
            )
        );
    }

    private PassengerController getController()
    {
        return new PassengerController(configuration);
    }
}
