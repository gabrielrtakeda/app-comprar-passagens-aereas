package project.modules.Airport.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Airport.Controller.AirportController;
import project.modules.Airport.Entity.AirportEntity;
import project.modules.Airport.Type.AirportConsultSearchComboType;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class AirportConsultSearchActionListener extends AbstractActionListener
{
    public AirportConsultSearchActionListener(ConfigurationEntity configuration)
    {
        configuration.setActionListener(this);
        setConfiguration(configuration);
    }

    public void actionPerformed(ActionEvent e)
    {
        JComboBox column = (JComboBox) getComponent("column");
        JTextField  search = (JTextField) getComponent("search");

        getController().consultAction(
            (AirportConsultSearchComboType) column.getSelectedItem(),
            search.getText()
        );
    }

    private AirportController getController()
    {
        return new AirportController(configuration);
    }
}
