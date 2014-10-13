package project.modules.Flight.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Entity.ColoredGridDependencyEntity;
import project.modules.Application.View.Layout.AbstractGridBagLayout;
import project.modules.Application.View.Layout.ColoredGridLayout;
import project.modules.Application.View.Layout.ComponentCreatePattern;
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
        Component[][] components = {
            new Component[] {
                new JLabel(configuration.getTranslator().__("Código")),
                new JTextField()
            },
            new Component[] {
                new JButton(configuration.getTranslator().__("Voltar")),
                new JButton(configuration.getTranslator().__("Confirmar"))
            }
        };

        JPanel byIdPanel = new JPanel();

        // GridBagLayout gbl = new GridBagLayout();
        // GridBagConstraints gbc = new GridBagConstraints();
        // byIdPanel.setLayout(gbl);

        // gbc.insets = new Insets(10, 10, 10, 10);
        // gbc.gridwidth = GridBagConstraints.REMAINDER;
        // JLabel labelTeste = new JLabel("teste");
        // JLabel labelTeste2 = new JLabel("teste2");
        // JLabel labelTeste3 = new JLabel("teste3");
        // JLabel labelTeste4 = new JLabel("teste4");
        // gbl.setConstraints(labelTeste, gbc);
        // gbl.setConstraints(labelTeste2, gbc);
        // gbl.setConstraints(labelTeste3, gbc);
        // gbl.setConstraints(labelTeste4, gbc);
        // byIdPanel.add(labelTeste);
        // byIdPanel.add(labelTeste2);
        // byIdPanel.add(labelTeste3);
        // byIdPanel.add(labelTeste4);

        // Cria Painel de Abas
        tabPane.addTab(
            configuration.getTranslator().__("Por Código"),
            byIdPanel
        );
        add(tabPane);
    }
}
