package project.modules.Airport.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Entity.ColoredGridDependencyEntity;
import project.modules.Application.View.Layout.AbstractGridBagLayout;
import project.modules.Application.View.Layout.ColoredGridLayout;
import project.modules.Application.View.Layout.ComponentCreatePattern;
import project.modules.Application.View.Button.ImageButton;
import project.modules.Airport.Entity.AirportEntity;
import project.modules.Airport.View.ActionListener.AirportRegisterViewActionListener;
import project.modules.Airport.View.ActionListener.AirportRegisterConfirmationActionListener;
import project.modules.Airport.View.ActionListener.AirportDeleteConfirmationActionListener;
import project.modules.Airport.Type.AirportButtonType;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Component;
import java.util.Map;
import java.util.HashMap;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AirportRegisterRasterizePanel extends JPanel
{
    public AirportRegisterRasterizePanel(ConfigurationEntity configuration)
    {
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        setLayout(gridBagLayout);

        // Título
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        AbstractGridBagLayout.addGridBagElement(
            this,
            ComponentCreatePattern.buildTitleLabel(
                configuration.getTranslator().__("Dados do Aeroporto")
            ),
            gridBagLayout,
            gridBagConstraints
        );

        ColoredGridDependencyEntity gridEntity = new ColoredGridDependencyEntity();
        gridEntity.setGridBagLayout(gridBagLayout)
                  .setGridBagConstraints(gridBagConstraints)
                  .setPanelSize(new Dimension(350, 30))
                  .setLineColumns(new Integer[] {1, 2})
                  .setBackgroundColor("gray", new Color(204, 204, 204))
                  .setBackgroundColor("white", Color.WHITE);

        // Formulário: Dados da Aeronave
        AirportEntity airportEntity = (AirportEntity) configuration.getEntity("airport");

        Component[][] components = {
            new Component[] {
                new JLabel(configuration.getTranslator().__("Descrição") + ":"),
                new JLabel(airportEntity.getDescription())
            },
            new Component[] {
                new JLabel(configuration.getTranslator().__("Sigla") + ":"),
                new JLabel(airportEntity.getAbbreviation())
            },
            new Component[] {
                new JLabel(configuration.getTranslator().__("Endereço") + ":"),
                new JLabel(airportEntity.getAddress())
            }
        };
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        ColoredGridLayout.make(
            this,
            gridEntity.setComponents(components)
        );

        // Buttons
        AirportButtonType continueButton = getContinueButtonType(configuration);
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        buttonsPanel.add(
            new ImageButton(
                configuration.getTranslator().__("Voltar"),
                "/images/buttonIcons/arrow-left.png",
                new Dimension(175, 40),
                new AirportRegisterViewActionListener(configuration)
            )
        );
        buttonsPanel.add(
            new ImageButton(
                configuration.getTranslator().__(continueButton.getText()),
                "/images/buttonIcons/check.png",
                new Dimension(175, 40),
                continueButton.getActionListener()
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

    private AirportButtonType getContinueButtonType(ConfigurationEntity configuration)
    {
        AirportButtonType continueType = new AirportButtonType();
        switch (configuration.getQueryString("airport-consult-confirmation")) {
            case "delete":
                continueType.setText("Excluir");
                continueType.setActionListener(
                    new AirportDeleteConfirmationActionListener(configuration)
                );
                break;
            default:
                continueType.setText("Confirmar");
                continueType.setActionListener(
                    new AirportRegisterConfirmationActionListener(configuration)
                );
        }
        return continueType;
    }
}
