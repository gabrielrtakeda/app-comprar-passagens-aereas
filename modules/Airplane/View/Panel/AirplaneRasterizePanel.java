package project.modules.Airplane.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Entity.ColoredGridDependencyEntity;
import project.modules.Application.View.Layout.AbstractGridBagLayout;
import project.modules.Application.View.Layout.ColoredGridLayout;
import project.modules.Application.View.Layout.ComponentCreatePattern;
import project.modules.Application.View.Button.ImageButton;
import project.modules.Airplane.Entity.AirplaneEntity;
import project.modules.Airplane.View.ActionListener.AirplaneRegisterConfirmationNavigationActionListener;
import project.modules.Airplane.View.ActionListener.AirplaneRegisterConfirmationActionListener;
import project.modules.Airplane.View.ActionListener.AirplaneDeleteConfirmationActionListener;
import project.modules.Airplane.Type.AirplaneButtonType;
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

public class AirplaneRasterizePanel extends JPanel
{
    public AirplaneRasterizePanel(ConfigurationEntity configuration)
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
                configuration.getTranslator().__("Dados da Aeronave")
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
        AirplaneEntity airplaneEntity = (AirplaneEntity) configuration.getEntity("airplane");

        Component[][] components = {
            new Component[] {
                new JLabel(configuration.getTranslator().__("Descrição") + ":"),
                new JLabel(airplaneEntity.getDescription())
            },
            new Component[] {
                new JLabel(configuration.getTranslator().__("Família") + ":"),
                new JLabel(airplaneEntity.getFamily())
            },
            new Component[] {
                new JLabel(configuration.getTranslator().__("Modelo") + ":"),
                new JLabel(airplaneEntity.getModel())
            },
            new Component[] {
                new JLabel(configuration.getTranslator().__("Status") + ":"),
                new JLabel(configuration.getTranslator().__(airplaneEntity.getStatus()))
            }
        };
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        ColoredGridLayout.make(
            this,
            gridEntity.setComponents(components)
        );

        // Buttons
        AirplaneButtonType continueButton = getContinueButtonType(configuration);
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        buttonsPanel.add(
            new ImageButton(
                configuration.getTranslator().__("Voltar"),
                "/images/buttonIcons/arrow-left.png",
                new Dimension(175, 40),
                new AirplaneRegisterConfirmationNavigationActionListener(configuration)
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

    private AirplaneButtonType getContinueButtonType(ConfigurationEntity configuration)
    {
        AirplaneButtonType continueType = new AirplaneButtonType();
        switch (configuration.getQueryString("airplane-consult-confirmation")) {
            case "delete":
                continueType.setText("Excluir");
                continueType.setActionListener(
                    new AirplaneDeleteConfirmationActionListener(configuration)
                );
                break;
            default:
                continueType.setText("Confirmar");
                continueType.setActionListener(
                    new AirplaneRegisterConfirmationActionListener(configuration)
                );
        }
        return continueType;
    }
}
