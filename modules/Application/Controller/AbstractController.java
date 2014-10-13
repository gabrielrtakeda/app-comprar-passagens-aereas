package project.modules.Application.Controller;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Interface.ConfigurationInterface;

public abstract class AbstractController implements ConfigurationInterface
{
    protected ConfigurationEntity config;

    public AbstractController()
    {}

    public void setConfiguration(ConfigurationEntity config)
    {
        this.config = config;
    }

    public ConfigurationEntity getConfiguration()
    {
        return config;
    }
}
