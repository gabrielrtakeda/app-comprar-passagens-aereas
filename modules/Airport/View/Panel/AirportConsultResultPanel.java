package project.modules.Airport.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Entity.AbstractEntity;
import project.modules.Application.View.Layout.AbstractGridBagLayout;
import project.modules.Application.View.Layout.ComponentCreatePattern;
import project.modules.Application.View.Button.ImageButton;
import project.modules.Airport.Entity.AirportEntity;
import project.modules.Airport.View.ActionListener.AirportMenuViewActionListener;
import project.modules.Airport.View.ActionListener.AirportConsultResultNavigationActionListener;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Insets;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.SwingConstants;

public class AirportConsultResultPanel extends JPanel
{
    public AirportConsultResultPanel(ConfigurationEntity configuration)
    {
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        setLayout(gridBagLayout);

        // Navigation Button
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        AbstractGridBagLayout.addGridBagElement(
            this,
            ComponentCreatePattern.buildNavigationButton(
                new AirportConsultResultNavigationActionListener(configuration)
            ),
            gridBagLayout,
            gridBagConstraints
        );

        // Título
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        AbstractGridBagLayout.addGridBagElement(
            this,
            ComponentCreatePattern.buildTitleLabel(
                configuration.getTranslator().__("Resultado da Pesquisa")
            ),
            gridBagLayout,
            gridBagConstraints
        );

        // Dados
        List<AbstractEntity> airportEntities = configuration.getEntitiesCollection();
        Object[][] components = new Object[airportEntities.size()][5];
        Integer count = 0;
        for (AbstractEntity entity : airportEntities) {
            AirportEntity airportEntity = (AirportEntity) entity;
            components[count] = new Object[] {
                airportEntity.getId(),
                airportEntity.getDescription(),
                airportEntity.getAbbreviation(),
                airportEntity.getAddress(),
                airportEntity.getDateRegister()
            };
            count++;
        }

        // Tabela
        JScrollPane scrollTable = new JScrollPane();

        DefaultTableModel tableModel = new DefaultTableModel(
            components,
            new String[] {"#", "Descrição", "Sigla", "Endereço", "Data Cadastro"}) {
                @Override
                public boolean isCellEditable(int row, int col) {
                    return false;
                }
        };

        JTable table = new JTable(tableModel);
        customizeTableColumn(table, 0,  30, true, SwingConstants.RIGHT);
        customizeTableColumn(table, 1, 320, true, SwingConstants.LEFT);
        customizeTableColumn(table, 2,  50, true, SwingConstants.CENTER);
        customizeTableColumn(table, 3, 400, true, SwingConstants.LEFT);
        customizeTableColumn(table, 4, 100, true, SwingConstants.CENTER);
        table.getTableHeader().setReorderingAllowed(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        scrollTable.setViewportView(table);
        scrollTable.setPreferredSize(new Dimension(900, 80));
        scrollTable.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        AbstractGridBagLayout.addGridBagElement(
            this,
            scrollTable,
            gridBagLayout,
            gridBagConstraints
        );

        // Action Buttons
        gridBagConstraints.insets = new Insets(0, 0, 0, 5);
        AbstractGridBagLayout.addGridBagElement(
            this,
            new ImageButton(
                "Ok",
                "/images/buttonIcons/arrow-right.png",
                new AirportMenuViewActionListener(configuration)
            ),
            gridBagLayout,
            gridBagConstraints
        );
    }

    private void customizeTableColumn(JTable table,
                                      Integer columnIndex,
                                      Integer width,
                                      Boolean resizable,
                                      Integer alignment)
    {
        DefaultTableCellRenderer rightAlignment = new DefaultTableCellRenderer();
        rightAlignment.setHorizontalAlignment(alignment);

        table.getColumnModel().getColumn(columnIndex).setPreferredWidth(width);
        table.getColumnModel().getColumn(columnIndex).setResizable(resizable);
        table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightAlignment);
    }
}
