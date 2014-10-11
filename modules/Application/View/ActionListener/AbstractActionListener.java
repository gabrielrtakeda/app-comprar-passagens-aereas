package project.modules.Application.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Interface.ConfigurationInterface;
import project.modules.Menu.View.MenuSupervisorView;
import project.modules.Menu.View.MenuAtendenteView;
import java.util.Map;
import java.util.HashMap;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;

public abstract class AbstractActionListener
implements  ActionListener,
            ConfigurationInterface
{
    protected ConfigurationEntity config;
    private Map<String, Component> components = new HashMap<String, Component>();

    public AbstractActionListener()
    {}

    public Component addComponent(String key, Component component)
    {
        components.put(key, component);
        return component;
    }

    public Component getComponent(String key)
    {
        return components.get(key);
    }

    public Map<String, Component> getComponents()
    {
        return components;
    }

    public void setConfiguration(ConfigurationEntity config)
    {
        this.config = config;

    }

    public void goToMenu()
    {
        if (config.getUser().isSupervisor()) {
            new MenuSupervisorView(config);
        } else {
            new MenuAtendenteView(config);
        }
    }

    public ConfigurationEntity getConfiguration()
    {
        return config;
    }
}
