package project.modules.Application.Model;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Interface.ConfigurationInterface;
import project.modules.Menu.View.MenuSupervisorView;
import project.modules.Menu.View.MenuAtendenteView;

public abstract class AbstractModel implements ConfigurationInterface
{
    protected ConfigurationEntity configuration;

    public void setConfiguration(ConfigurationEntity configuration)
    {
        this.configuration = configuration;
    }

    public ConfigurationEntity getConfiguration()
    {
        return configuration;
    }

    public void goToMenu()
    {
        if (configuration.getUser().isSupervisor()) {
            new MenuSupervisorView(configuration);
        } else {
            new MenuAtendenteView(configuration);
        }
    }
}
