package project.modules.Application.Model;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Interface.ConfigurationInterface;

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
}
