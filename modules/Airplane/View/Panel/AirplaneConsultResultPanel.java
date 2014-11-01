package project.modules.Airplane.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Entity.AbstractEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Application.View.Layout.AbstractGridBagLayout;
import project.modules.Application.View.Layout.ComponentCreatePattern;
import project.modules.Application.View.Button.ImageButton;
import project.modules.Airplane.Controller.AirplaneController;
import project.modules.Airplane.Entity.AirplaneEntity;
import project.modules.Airplane.Type.AirplaneButtonType;
import project.modules.Airplane.View.ActionListener.AirplaneMenuViewActionListener;
import project.modules.Airplane.View.ActionListener.AirplaneConsultResultNavigationActionListener;
import project.modules.Airplane.View.ActionListener.AirplaneEditContentViewActionListener;
import project.modules.Airplane.View.ActionListener.AirplaneDeleteActionListener;
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

public class AirplaneConsultResultPanel extends JPanel
{
    ConfigurationEntity configuration;
    AbstractActionListener menuViewActionListener;

    public AirplaneConsultResultPanel(ConfigurationEntity configuration)
    {
        configuration = configuration;
        menuViewActionListener = new AirplaneMenuViewActionListener(configuration);

        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        setLayout(gridBagLayout);

        // Navigation Button
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        AbstractGridBagLayout.addGridBagElement(
            this,
            ComponentCreatePattern.buildNavigationButton(
                new AirplaneConsultResultNavigationActionListener(configuration)
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
        List<AbstractEntity> airplaneEntities = configuration.getEntitiesCollection();
        Object[][] components = new Object[airplaneEntities.size()][7];
        Integer count = 0;
        for (AbstractEntity entity : airplaneEntities) {
            AirplaneEntity airplaneEntity = (AirplaneEntity) entity;
            components[count] = new Object[] {
                airplaneEntity.getId(),
                airplaneEntity.getDescription(),
                airplaneEntity.getFamily(),
                airplaneEntity.getModel(),
                airplaneEntity.getSeatsTotal() +"/"+ airplaneEntity.getSeatsVacantTotal(),
                airplaneEntity.getStatus(),
                airplaneEntity.getDateRegister(),
            };
            count++;
        }

        // Tabela
        JScrollPane scrollTable = new JScrollPane();

        DefaultTableModel tableModel = new DefaultTableModel(
            components,
            new String[] {
                    "#",
                    configuration.getTranslator().__("Descrição"),
                    configuration.getTranslator().__("Família"),
                    configuration.getTranslator().__("Modelo"),
                    configuration.getTranslator().__("D/R"),
                    configuration.getTranslator().__("Status"),
                    configuration.getTranslator().__("Data Cadastro")
                }) {
                    @Override
                    public boolean isCellEditable(int row, int col) {
                        return false;
                }
        };

        JTable table = new JTable(tableModel);
        customizeTableColumn(table, 0,  30, true, SwingConstants.CENTER);
        customizeTableColumn(table, 1, 460, true, SwingConstants.LEFT);
        customizeTableColumn(table, 2,  60, true, SwingConstants.LEFT);
        customizeTableColumn(table, 3, 100, true, SwingConstants.LEFT);
        customizeTableColumn(table, 4,  50, true, SwingConstants.CENTER);
        customizeTableColumn(table, 5,  80, true, SwingConstants.LEFT);
        customizeTableColumn(table, 6, 120, true, SwingConstants.CENTER);
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
        AirplaneButtonType continueButtonType = getContinueButtonType(configuration);

        buttonsPanel.add(
            new ImageButton(
                configuration.getTranslator().__("Voltar"),
                "/images/buttonIcons/arrow-left.png",
                buttonSize,
                new AirplaneConsultResultNavigationActionListener(configuration)
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

    private AirplaneButtonType getContinueButtonType(ConfigurationEntity configuration)
    {
        AirplaneButtonType continueType = new AirplaneButtonType();
        switch (configuration.getQueryString("airplane-consult")) {
            case "edit":
                AbstractActionListener editActionListener =
                    new AirplaneEditContentViewActionListener(configuration);
                editActionListener.setComponents(menuViewActionListener.getComponents());

                continueType.setText("Editar");
                continueType.setActionListener(editActionListener);
                break;
            case "delete":
                AbstractActionListener deleteActionListener =
                    new AirplaneDeleteActionListener(configuration);
                deleteActionListener.setComponents(menuViewActionListener.getComponents());

                continueType.setText("Excluir");
                continueType.setActionListener(deleteActionListener);
                break;
            default:
                continueType.setText("Ok");
                continueType.setActionListener(
                    menuViewActionListener
                );
        }
        return continueType;
    }

    private AirplaneController getController()
    {
        return new AirplaneController(configuration);
    }
}
