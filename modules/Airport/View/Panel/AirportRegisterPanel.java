package project.modules.Airport.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Entity.ColoredGridDependencyEntity;
import project.modules.Application.View.Button.ImageButton;
import project.modules.Application.View.Layout.AbstractGridBagLayout;
import project.modules.Application.View.Layout.ColoredGridLayout;
import project.modules.Application.View.Layout.ComponentCreatePattern;
import project.modules.Airport.Entity.AirportEntity;
import project.modules.Airport.View.ActionListener.AirportMenuViewActionListener;
import project.modules.Airport.View.ActionListener.AirportRegisterNavigationActionListener;
import project.modules.Airport.View.ActionListener.AirportRegisterRasterizeActionListener;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AirportRegisterPanel extends JPanel
{
    public AirportRegisterPanel(ConfigurationEntity configuration)
    {
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        setLayout(gridBagLayout);

        // Entidade de Dependência: ColoredGrid
        ColoredGridDependencyEntity gridEntity = new ColoredGridDependencyEntity();
        gridEntity.setGridBagLayout(gridBagLayout)
                  .setGridBagConstraints(gridBagConstraints)
                  .setPanelSize(new Dimension(400, 30))
                  .setLineColumns(new Integer[] {1, 2})
                  .setBackgroundColor("gray", new Color(204, 204, 204))
                  .setBackgroundColor("white", Color.WHITE);

        // Navigation Button
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        AbstractGridBagLayout.addGridBagElement(
            this,
            ComponentCreatePattern.buildNavigationButton(
                new AirportRegisterNavigationActionListener(configuration)
            ),
            gridBagLayout,
            gridBagConstraints
        );

        // Título
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new Insets(0, 0, 15, 0);
        AbstractGridBagLayout.addGridBagElement(
            this,
            ComponentCreatePattern.buildTitleLabel(
                configuration.getTranslator().__("Dados do Aeroporto")
            ),
            gridBagLayout,
            gridBagConstraints
        );

        // Formulário: Dados do Aeroporto
        AirportRegisterRasterizeActionListener registerRasterizeActionListener =
            new AirportRegisterRasterizeActionListener(configuration);

        String descriptionText  = "";
        String abbreviationText = "";
        String addressText      = "";

        if (configuration.hasEntity("airport")) {
            AirportEntity entity = (AirportEntity) configuration.getEntity("airport");

            descriptionText   = entity.getDescription();
            abbreviationText  = entity.getAbbreviation();
            addressText       = entity.getAddress();
        }

        Component[][] components = {
            new Component[] {
                new JLabel(configuration.getTranslator().__("Descrição")),
                registerRasterizeActionListener.addComponent(
                    "description",
                    new JTextField(descriptionText)
                )
            },
            new Component[] {
                new JLabel(configuration.getTranslator().__("Sigla")),
                registerRasterizeActionListener.addComponent(
                    "abbreviation",
                    new JTextField(abbreviationText)
                )
            },
            new Component[] {
                new JLabel(configuration.getTranslator().__("Endereço")),
                registerRasterizeActionListener.addComponent(
                    "address",
                    new JTextField(addressText)
                )
            }
        };
        gridBagConstraints.insets = new Insets(0, 10, 0, 10);
        ColoredGridLayout.make(
            this,
            gridEntity.setGridBagConstraints(gridBagConstraints)
                      .setComponents(components)
        );

        // Botões de Comando
        JPanel buttonsPanel = new JPanel(new GridLayout(1, 2));
        String buttonIconsDirectoryPath = "/images/buttonIcons/";
        Dimension buttonSize = new Dimension(200, 40);

        buttonsPanel.add(
            new ImageButton(
                configuration.getTranslator().__("Voltar"),
                buttonIconsDirectoryPath + "arrow-left.png",
                buttonSize,
                new AirportMenuViewActionListener(configuration)
            )
        );
        buttonsPanel.add(
            new ImageButton(
                configuration.getTranslator().__("Continuar"),
                buttonIconsDirectoryPath + "check.png",
                buttonSize,
                registerRasterizeActionListener
            )
        );
        gridBagConstraints.insets = new Insets(10, 0, 0, 0);
        AbstractGridBagLayout.addGridBagElement(
            this,
            buttonsPanel,
            gridBagLayout,
            gridBagConstraints
        );
    }
}
