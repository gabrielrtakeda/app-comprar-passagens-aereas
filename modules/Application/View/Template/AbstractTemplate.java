package project.modules.Application.View.Template;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Interface.ConfigurationInterface;
import javax.swing.JPanel;

public abstract class AbstractTemplate extends JPanel
{
    protected ConfigurationEntity config;

    public AbstractTemplate()
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
