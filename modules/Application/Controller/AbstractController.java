package project.modules.Application.Controller;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Interface.ConfigurationInterface;

public abstract class AbstractController implements ConfigurationInterface
{
    protected ConfigurationEntity configuration;

    public AbstractController()
    {}

    public void setConfiguration(ConfigurationEntity configuration)
    {
        this.configuration = configuration;
    }

    public ConfigurationEntity getConfiguration()
    {
        return configuration;
    }
}
