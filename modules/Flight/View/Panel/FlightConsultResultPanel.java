package project.modules.Flight.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Entity.AbstractEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Application.View.Layout.AbstractGridBagLayout;
import project.modules.Application.View.Layout.ComponentCreatePattern;
import project.modules.Application.View.Button.ImageButton;
import project.modules.Flight.Controller.FlightController;
import project.modules.Flight.Entity.FlightEntity;
import project.modules.Flight.Type.FlightButtonType;
import project.modules.Flight.View.ActionListener.FlightMenuViewActionListener;
import project.modules.Flight.View.ActionListener.FlightConsultResultNavigationActionListener;
import project.modules.Flight.View.ActionListener.FlightEditContentViewActionListener;
import project.modules.Flight.View.ActionListener.FlightDeleteConfirmationActionListener;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.SwingConstants;

public class FlightConsultResultPanel extends JPanel
{
    ConfigurationEntity configuration;
    AbstractActionListener menuViewActionListener;

    public FlightConsultResultPanel(ConfigurationEntity configuration)
    {
        configuration = configuration;

        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        setLayout(gridBagLayout);

        // Navigation Button
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        AbstractGridBagLayout.addGridBagElement(
            this,
            ComponentCreatePattern.buildNavigationButton(
                new FlightConsultResultNavigationActionListener(configuration)
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
        List<AbstractEntity> entitiesCollection = configuration.getEntitiesCollection();
        Object[][] tableHeader = new Object[entitiesCollection.size()][8];
        Integer count = 0;
        for (AbstractEntity entity : entitiesCollection) {
            FlightEntity flightEntity = (FlightEntity) entity;
            tableHeader[count] = new Object[] {
                flightEntity.getId(),
                flightEntity.getAirplane().getModel(),
                flightEntity.getAirportOrigin().getDescription(),
                flightEntity.getAirportDestination().getDescription(),
                String.valueOf(flightEntity.getPrice()),
                flightEntity.getStatus(),
                flightEntity.getDateDeparture().toString(),
                flightEntity.getDateRegister().toString(),
            };
            count++;
        }

        // Tabela
        JScrollPane scrollTable = new JScrollPane();

        DefaultTableModel tableModel = new DefaultTableModel(
            tableHeader,
            new String[] {
                    "#",
                    "Aeronave",
                    "Aeroporto Orig.",
                    "Aeroporto Dest.",
                    "Valor",
                    "Status",
                    "Data Partida",
                    "Data Cadastro"}) {
                @Override
                public boolean isCellEditable(int row, int col) {
                    return false;
                }
        };

        menuViewActionListener = new FlightMenuViewActionListener(configuration);

        JTable table = new JTable(tableModel);
        customizeTableColumn(table, 0,  30, true, SwingConstants.RIGHT);
        customizeTableColumn(table, 1,  70, true, SwingConstants.LEFT);
        customizeTableColumn(table, 2, 230, true, SwingConstants.LEFT);
        customizeTableColumn(table, 3, 230, true, SwingConstants.LEFT);
        customizeTableColumn(table, 4,  70, true, SwingConstants.CENTER);
        customizeTableColumn(table, 5,  80, true, SwingConstants.CENTER);
        customizeTableColumn(table, 6,  90, true, SwingConstants.CENTER);
        customizeTableColumn(table, 7, 100, true, SwingConstants.CENTER);
        table.getTableHeader().setReorderingAllowed(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        menuViewActionListener.addComponent("search-result", table);

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
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        Dimension buttonSize = new Dimension(200, 40);
        FlightButtonType continueButtonType = getContinueButtonType(configuration);

        buttonsPanel.add(
            new ImageButton(
                configuration.getTranslator().__("Voltar"),
                "/images/buttonIcons/arrow-left.png",
                buttonSize,
                new FlightConsultResultNavigationActionListener(configuration)
            )
        );
        buttonsPanel.add(
            new ImageButton(
                configuration.getTranslator().__(continueButtonType.getText()),
                "/images/buttonIcons/arrow-right.png",
                buttonSize,
                continueButtonType.getActionListener()
            )
        );
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        AbstractGridBagLayout.addGridBagElement(
            this,
            buttonsPanel,
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

    private FlightButtonType getContinueButtonType(ConfigurationEntity configuration)
    {
        FlightButtonType continueType = new FlightButtonType();
        System.out.println(configuration.toString());
        switch (configuration.getQueryString("flight-consult")) {
            case "edit":
                AbstractActionListener editContentActionListener =
                    new FlightEditContentViewActionListener(configuration);
                editContentActionListener.setComponents(menuViewActionListener.getComponents());

                continueType.setText("Editar");
                continueType.setActionListener(editContentActionListener);
                break;
            case "delete":
                AbstractActionListener deleteConfirmationActionListener =
                    new FlightDeleteConfirmationActionListener(configuration);
                deleteConfirmationActionListener.setComponents(menuViewActionListener.getComponents());

                continueType.setText("Excluir");
                continueType.setActionListener(deleteConfirmationActionListener);
                break;
            default:
                continueType.setText("Ok");
                continueType.setActionListener(
                    menuViewActionListener
                );
        }
        return continueType;
    }

    private FlightController getController()
    {
        return new FlightController(configuration);
    }
}
