package  project.modules.Airplane.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Entity.ColoredGridDependencyEntity;
import project.modules.Application.View.Layout.AbstractGridBagLayout;
import project.modules.Application.View.Layout.ColoredGridLayout;
import project.modules.Application.View.Layout.ComponentCreatePattern;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Application.View.Button.ImageButton;
import project.modules.Airplane.Entity.AirplaneEntity;
import project.modules.Airplane.View.ActionListener.AirplaneMenuViewActionListener;
import project.modules.Airplane.View.ActionListener.AirplaneConsultSearchActionListener;
import project.modules.Airplane.View.ItemListener.AirplaneConsultSearchItemListener;
import project.modules.Airplane.Type.AirplaneConsultSearchComboType;
import project.modules.Airplane.Type.AirplaneStatusType;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class AirplaneConsultPanel extends JPanel
{
    public AirplaneConsultPanel(ConfigurationEntity configuration)
    {
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        setLayout(gridBagLayout);

        // Entidade de Dependências: ColoredGridLayout
        ColoredGridDependencyEntity gridEntity = new ColoredGridDependencyEntity();
        gridEntity.setGridBagLayout(gridBagLayout)
                  .setGridBagConstraints(gridBagConstraints)
                  .setPanelSize(new Dimension(400, 30))
                  .setLineColumns(new Integer[] {1, 2})
                  .setBackgroundColor("gray", new Color(204, 204, 204))
                  .setBackgroundColor("white", Color.WHITE);

        // Navigation Button
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        AbstractGridBagLayout.addGridBagElement(
            this,
            ComponentCreatePattern.buildNavigationButton(
                new AirplaneMenuViewActionListener(configuration)
            ),
            gridBagLayout,
            gridBagConstraints
        );

        // Title
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        AbstractGridBagLayout.addGridBagElement(
            this,
            ComponentCreatePattern.buildTitleLabel(
                configuration.getTranslator().__("Consultar")
            ),
            gridBagLayout,
            gridBagConstraints
        );

        // Formulário: Consultar
        AbstractActionListener consultSearchActionListener =
            new AirplaneConsultSearchActionListener(configuration);

        Component[][] components = {
            new Component[] {
                consultSearchActionListener.addComponent(
                    "column",
                    new JComboBox<AirplaneConsultSearchComboType>(
                        new AirplaneConsultSearchComboType[] {
                            new AirplaneConsultSearchComboType(configuration, "Modelo", "modelo"),
                            new AirplaneConsultSearchComboType(configuration, "Código", "idAeronave"),
                            new AirplaneConsultSearchComboType(configuration, "Descrição", "descricao"),
                            new AirplaneConsultSearchComboType(configuration, "Status", "status"),
                        }
                    )
                ),
                consultSearchActionListener.addComponent(
                    "search",
                    new JTextField()
                )
            }
        };
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        ColoredGridLayout.make(
            this,
            gridEntity.setGridBagConstraints(gridBagConstraints)
                      .setComponents(components)
        );

        // Buttons Panel
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        String buttonIconsDirectoryPath = "/images/buttonIcons/";
        Dimension buttonSize = new Dimension(200, 40);

        buttonsPanel.add(
            new ImageButton(
                configuration.getTranslator().__("Voltar"),
                buttonIconsDirectoryPath + "arrow-left.png",
                buttonSize,
                new AirplaneMenuViewActionListener(configuration)
            )
        );
        buttonsPanel.add(
            new ImageButton(
                configuration.getTranslator().__("Consultar"),
                buttonIconsDirectoryPath + "search.png",
                buttonSize,
                consultSearchActionListener
            )
        );
        AbstractGridBagLayout.addGridBagElement(
            this,
            buttonsPanel,
            gridBagLayout,
            gridBagConstraints
        );
    }
}
