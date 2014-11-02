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
    public ConfigurationEntity configuration;
    public Map<String, Component> components = new HashMap<String, Component>();

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

    public Boolean hasComponent(String key)
    {
        return components.containsKey(key);
    }

    public AbstractActionListener setComponents(Map<String, Component> components)
    {
        this.components = components;
        return this;
    }

    public Map<String, Component> getComponents()
    {
        return components;
    }

    public void setConfiguration(ConfigurationEntity configuration)
    {
        this.configuration = configuration;

    }

    public void goToMenu()
    {
        if (configuration.getUser().isSupervisor()) {
            new MenuSupervisorView(configuration);
        } else {
            new MenuAtendenteView(configuration);
        }
    }

    public ConfigurationEntity getConfiguration()
    {
        return configuration;
    }
}
