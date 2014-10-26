package project.modules.Airplane.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Airplane.Controller.AirplaneController;
import project.modules.Airplane.Entity.AirplaneEntity;
import project.modules.Airplane.Type.AirplaneConsultSearchComboType;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class AirplaneConsultSearchActionListener extends AbstractActionListener
{
    public AirplaneConsultSearchActionListener(ConfigurationEntity configuration)
    {
        configuration.setActionListener(this);
        setConfiguration(configuration);
    }

    public void actionPerformed(ActionEvent e)
    {
        JComboBox   column = (JComboBox) getComponent("column");
        JTextField  search = (JTextField) getComponent("search");

        getController().consultByAction(
            (AirplaneConsultSearchComboType) column.getSelectedItem(),
            search.getText()
        );
    }

    private AirplaneController getController()
    {
        return new AirplaneController(configuration);
    }
}
