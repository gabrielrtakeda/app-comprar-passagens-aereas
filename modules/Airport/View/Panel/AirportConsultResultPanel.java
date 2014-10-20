package project.modules.Airport.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.SwingConstants;

public class AirportConsultResultPanel extends JPanel
{
	public AirportConsultResultPanel(ConfigurationEntity configuration)
	{
		JScrollPane scrollTable = new JScrollPane();

		DefaultTableModel tableModel = new DefaultTableModel(
		new String[] {"Codigo", "Descrição", "Sigla", "Endereço", "Data Cadastro"}, 0) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};

		JTable table = new JTable(tableModel);
		customizeTableColumn(table, 0, 100, false);
		customizeTableColumn(table, 1, 100, false);
		customizeTableColumn(table, 2, 100, false);
		customizeTableColumn(table, 3, 100, false);
		customizeTableColumn(table, 4, 100, false);

		table.getTableHeader().setReorderingAllowed(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		scrollTable.setViewportView(table);
		add(scrollTable);
	}

	private void customizeTableColumn(JTable table,
									  Integer columnIndex,
									  Integer width,
									  Boolean resizable)
	{
		DefaultTableCellRenderer rightAlignment = new DefaultTableCellRenderer();
		rightAlignment.setHorizontalAlignment(SwingConstants.RIGHT);

		table.getColumnModel().getColumn(columnIndex).setPreferredWidth(width);
		table.getColumnModel().getColumn(columnIndex).setResizable(resizable);
		table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightAlignment);
	}
}