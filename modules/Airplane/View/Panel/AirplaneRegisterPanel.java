package project.modules.Airplane.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Entity.ColoredGridDependencyEntity;
import project.modules.Application.View.Layout.AbstractGridBagLayout;
import project.modules.Application.View.Layout.ColoredGridLayout;
import project.modules.Application.View.Layout.ComponentCreatePattern;
import project.modules.Application.View.Button.ImageButton;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Airplane.View.ActionListener.AirplaneRegisterNavigationActionListener;
import project.modules.Airplane.View.ActionListener.AirplaneRegisterRasterizeActionListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Component;
import java.util.Map;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AirplaneRegisterPanel extends JPanel
{
    public AirplaneRegisterPanel(ConfigurationEntity configuration)
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
        AbstractActionListener rasterizeActionListener =
            new AirplaneRegisterRasterizeActionListener(configuration);

        String descriptionText   = "";
        String modelText         = "";
        String amountOfSeatsText = "";

        if (configuration.hasParameter("airplane-register-form-data")) {
            Map<String, Component> parameter = configuration.getParameter("airplane-register-form-data");
            JTextField description = (JTextField) parameter.get("description");
            JTextField model = (JTextField) parameter.get("model");
            JTextField amountOfSeats = (JTextField) parameter.get("amount-of-seats");

            descriptionText   = description.getText();
            modelText         = model.getText();
            amountOfSeatsText = amountOfSeats.getText();
        }

        Component[][] components = {
            new Component[] {
                new JLabel(configuration.getTranslator().__("Descrição") + ":"),
                rasterizeActionListener.addComponent(
                    "description",
                    new JTextField(descriptionText)
                )
            },
            new Component[] {
                new JLabel(configuration.getTranslator().__("Modelo") + ":"),
                rasterizeActionListener.addComponent(
                    "model",
                    new JTextField(modelText)
                )
            },
            new Component[] {
                new JLabel(configuration.getTranslator().__("Quantidade de Assentos") + ":"),
                rasterizeActionListener.addComponent(
                    "amount-of-seats",
                    new JTextField(amountOfSeatsText)
                )
            }
        };
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        ColoredGridLayout.make(
            this,
            gridEntity.setComponents(components)
        );

        // Buttons
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        buttonsPanel.add(
            new ImageButton(
                configuration.getTranslator().__("Voltar"),
                "/images/buttonIcons/arrow-left.png",
                new Dimension(175, 40),
                new AirplaneRegisterNavigationActionListener(configuration)
            )
        );
        buttonsPanel.add(
            new ImageButton(
                configuration.getTranslator().__("Continuar"),
                "/images/buttonIcons/check.png",
                new Dimension(175, 40),
                rasterizeActionListener
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
