package project.modules.Flight.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Entity.ColoredGridDependencyEntity;
import project.modules.Application.View.Layout.AbstractGridBagLayout;
import project.modules.Application.View.Layout.ColoredGridLayout;
import project.modules.Application.View.Layout.ComponentCreatePattern;
import project.modules.Application.View.Button.ImageButton;
import project.modules.Flight.Controller.FlightController;
import project.modules.Flight.View.ActionListener.FlightConsultNavigationActionListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.BorderFactory;

public class FlightConsultPanel extends JPanel
{
    public FlightConsultPanel(ConfigurationEntity configuration)
    {
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        setLayout(gridBagLayout);

        // Entidade de Dependência ColoredGridLayout
        ColoredGridDependencyEntity gridEntity = new ColoredGridDependencyEntity();
        gridEntity.setGridBagLayout(gridBagLayout)
                  .setGridBagConstraints(gridBagConstraints)
                  .setPanelSize(new Dimension(300, 30))
                  .setLineColumns(new Integer[] {1, 2})
                  .setBackgroundColor("gray", new Color(204, 204, 204))
                  .setBackgroundColor("white", Color.WHITE);

        // Título
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        AbstractGridBagLayout.addGridBagElement(
            this,
            ComponentCreatePattern.buildTitleLabel(
                configuration.getTranslator().__("Consultar Voo")
            ),
            gridBagLayout,
            gridBagConstraints
        );

        // Formulário: Consultar Voo
        JTabbedPane tabPane = new JTabbedPane();

        // Tab: Consultar pelo ID do Voo
        gridBagConstraints = new GridBagConstraints();

        JPanel byIdPanel = new JPanel();
        byIdPanel.setLayout(gridBagLayout);
        byIdPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        Component[][] components = {
            new Component[] {
                new JLabel(configuration.getTranslator().__("Código") + ":"),
                new JTextField()
            },
            new Component[] {
                new ImageButton(
                    configuration.getTranslator().__("Voltar"),
                    "/images/buttonIcons/arrow-left.png",
                    new FlightConsultNavigationActionListener(configuration)
                ),
                new ImageButton(
                    configuration.getTranslator().__("Consultar"),
                    "/images/buttonIcons/search.png"
                )
            }
        };
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        ColoredGridLayout.make(
            byIdPanel,
            gridEntity.setGridBagConstraints(gridBagConstraints)
                      .setComponents(components)
        );
        tabPane.addTab(
            configuration.getTranslator().__("Por Código"),
            byIdPanel
        );

        // Tab: Consulta mais abrangente
        JPanel macroSearchPanel = new JPanel();
        macroSearchPanel.setLayout(gridBagLayout);
        macroSearchPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        components = new Component[][] {
            new Component[] {
                new JLabel(configuration.getTranslator().__("Aeroporto de Origem") + ":"),
                new JComboBox<String>(
                    getController(configuration).getAirports()
                )
            },
            new Component[] {
                new JLabel(configuration.getTranslator().__("Aeroporto de Destino") + ":"),
                new JComboBox<String>(
                    getController(configuration).getAirports()
                )
            },
            new Component[] {
                new JLabel(configuration.getTranslator().__("Data Partida") + ":"),
                new JTextField()
            },
            new Component[] {
                new ImageButton(
                    configuration.getTranslator().__("Voltar"),
                    "/images/buttonIcons/arrow-left.png",
                    new FlightConsultNavigationActionListener(configuration)
                ),
                new ImageButton(
                    configuration.getTranslator().__("Consultar"),
                    "/images/buttonIcons/search.png"
                )
            }
        };
        ColoredGridLayout.make(
            macroSearchPanel,
            gridEntity.setGridBagConstraints(gridBagConstraints)
                      .setComponents(components)
        );
        tabPane.addTab(
            "Macro Search",
            macroSearchPanel
        );

        // Cria Painel de Abas
        add(tabPane);
    }

    public FlightController getController(ConfigurationEntity configuration)
    {
        return (FlightController) configuration.getController();
    }
}
