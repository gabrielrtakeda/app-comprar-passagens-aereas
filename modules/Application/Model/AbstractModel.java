package project.modules.Application.Model;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Interface.ConfigurationInterface;
import project.modules.Menu.View.MenuSupervisorView;
import project.modules.Menu.View.MenuAtendenteView;

public abstract class AbstractModel implements ConfigurationInterface
{
    protected ConfigurationEntity config;

    public void setConfiguration(ConfigurationEntity configuration)
    {
        this.config = configuration;
    }

    public ConfigurationEntity getConfiguration()
    {
        return config;
    }

    public void goToMenu()
    {
        if (config.getUser().isSupervisor()) {
            new MenuSupervisorView(config);
        } else {
            new MenuAtendenteView(config);
        }
    }
}
