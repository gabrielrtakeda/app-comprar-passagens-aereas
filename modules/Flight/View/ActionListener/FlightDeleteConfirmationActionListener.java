package project.modules.Flight.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Flight.Controller.FlightController;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class FlightDeleteConfirmationActionListener extends AbstractActionListener
{
    public FlightDeleteConfirmationActionListener(ConfigurationEntity configuration)
    {
        configuration.setActionListener(this);
        setConfiguration(configuration);
    }

    public void actionPerformed(ActionEvent e)
    {
        JTable table           = (JTable)  getComponent("search-result");
        configuration.setEntity(
            "flight",
            configuration.getEntityOfCollection(table.getSelectedRow())
        );
        getController().deleteConfirmationAction();
    }

    private FlightController getController()
    {
        return new FlightController(configuration);
    }
}
