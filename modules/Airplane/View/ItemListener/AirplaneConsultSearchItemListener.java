package project.modules.Airplane.View.ItemListener;

import project.modules.Application.Entity.ConfigurationEntity;
import java.awt.Component;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class AirplaneConsultSearchItemListener implements ItemListener
{
    private ConfigurationEntity configuration;
    private Component[] components;

    public AirplaneConsultSearchItemListener(ConfigurationEntity configuration,
                                             Component[] components)
    {
        this.configuration = configuration;
        this.components = components;
    }

    public void itemStateChanged(ItemEvent e)
    {
        /**
         * Not Working
         */
        if (e.getStateChange() == ItemEvent.SELECTED && e.getItem().toString().equals("Status")) {
            components[0].setVisible(false);
            components[1].setVisible(true);
        } else {
            components[0].setVisible(true);
            components[1].setVisible(false);
        }
    }
}
