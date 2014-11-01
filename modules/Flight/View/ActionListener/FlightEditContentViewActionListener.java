package project.modules.Flight.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Flight.Controller.FlightController;
import project.modules.Flight.Entity.FlightEntity;
import project.modules.Airplane.Entity.AirplaneEntity;
import project.modules.Airport.Entity.AirportEntity;
import java.awt.event.ActionEvent;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FlightEditContentViewActionListener extends AbstractActionListener
{
    public FlightEditContentViewActionListener(ConfigurationEntity configuration)
    {
        configuration.setActionListener(this);
        setConfiguration(configuration);
    }

    public void actionPerformed(ActionEvent e)
    {
        JTable searchResultTable = (JTable) getComponent("search-result");

        FlightEntity entity =
            (FlightEntity) configuration.getEntityOfCollection(
                searchResultTable.getSelectedRow()
            );
        configuration.setEntity(
            "flight",
            (FlightEntity) configuration.getEntityOfCollection(
                searchResultTable.getSelectedRow()
            )
        );

        getController().navigateAction("register");
    }

    private FlightController getController()
    {
        return new FlightController(configuration);
    }
}
