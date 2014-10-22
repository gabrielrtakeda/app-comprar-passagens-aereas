package project.modules.Airport.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Airport.Controller.AirportController;
import project.modules.Airport.Entity.AirportEntity;
import java.awt.event.ActionEvent;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AirportEditContentViewActionListener extends AbstractActionListener
{
    public AirportEditContentViewActionListener(ConfigurationEntity configuration)
    {
        configuration.setActionListener(this);
        setConfiguration(configuration);
    }

    public void actionPerformed(ActionEvent e)
    {
        JTable searchResultTable = (JTable) getComponent("search-result");
        Integer row = searchResultTable.getSelectedRow();
        DefaultTableModel tableModel = (DefaultTableModel) searchResultTable.getModel();

        AirportEntity airportEntity = new AirportEntity();
        airportEntity.setId(            (Integer) tableModel.getValueAt(row, 0))
                     .setDescription(   (String) tableModel.getValueAt(row, 1))
                     .setAbbreviation(  (String) tableModel.getValueAt(row, 2))
                     .setAddress(       (String) tableModel.getValueAt(row, 3))
                     .setDateRegister(  (Date) tableModel.getValueAt(row, 4));

        configuration.setEntity("airport", airportEntity);
        setConfiguration(configuration);
        getController().editContentAction();
    }

    private AirportController getController()
    {
        return new AirportController(configuration);
    }
}
