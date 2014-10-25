package project.modules.Airport.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Airport.Controller.AirportController;
import project.modules.Airport.Entity.AirportEntity;
import java.awt.event.ActionEvent;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AirportDeleteActionListener extends AbstractActionListener
{
    public AirportDeleteActionListener(ConfigurationEntity configuration)
    {
        configuration.setActionListener(this);
        setConfiguration(configuration);
    }

    public void actionPerformed(ActionEvent e)
    {
        JTable searchResult = (JTable) getComponent("search-result");
        Integer row = searchResult.getSelectedRow();
        DefaultTableModel tableModel = (DefaultTableModel) searchResult.getModel();

        AirportEntity airportEntity = new AirportEntity();
        airportEntity.setId(          (Integer) tableModel.getValueAt(row, 0))
                     .setDescription( (String) tableModel.getValueAt(row, 1))
                     .setAbbreviation((String) tableModel.getValueAt(row, 2))
                     .setAddress(     (String) tableModel.getValueAt(row, 3))
                     .setDateRegister((Date) tableModel.getValueAt(row, 4));

        getController().deleteConfirmationAction(airportEntity);
    }

    private AirportController getController()
    {
        return new AirportController(configuration);
    }
}
