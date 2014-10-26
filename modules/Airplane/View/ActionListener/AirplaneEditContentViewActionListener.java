package project.modules.Airplane.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Airplane.Controller.AirplaneController;
import project.modules.Airplane.Entity.AirplaneEntity;
import java.awt.event.ActionEvent;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AirplaneEditContentViewActionListener extends AbstractActionListener
{
    public AirplaneEditContentViewActionListener(ConfigurationEntity configuration)
    {
        configuration.setActionListener(this);
        setConfiguration(configuration);
    }

    public void actionPerformed(ActionEvent e)
    {
        JTable searchResultTable = (JTable) getComponent("search-result");
        Integer row = searchResultTable.getSelectedRow();
        DefaultTableModel tableModel = (DefaultTableModel) searchResultTable.getModel();

        String seats = (String) tableModel.getValueAt(row, 4);
        AirplaneEntity airplaneEntity = new AirplaneEntity();
        airplaneEntity.setId(             (Integer) tableModel.getValueAt(row, 0))
                     .setDescription(     (String)  tableModel.getValueAt(row, 1))
                     .setFamily(          (String)  tableModel.getValueAt(row, 2))
                     .setModel(           (String)  tableModel.getValueAt(row, 3))
                     .setSeatsTotal(      (Integer) Integer.parseInt(seats.split("/")[0]))
                     .setSeatsVacantTotal((Integer) Integer.parseInt(seats.split("/")[1]))
                     .setStatus(          (String)  tableModel.getValueAt(row, 5))
                     .setDateRegister(    (Date)    tableModel.getValueAt(row, 6));

        getController().editAction(airplaneEntity);
    }

    private AirplaneController getController()
    {
        return new AirplaneController(configuration);
    }
}
