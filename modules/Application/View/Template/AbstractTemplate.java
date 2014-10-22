package project.modules.Application.View.Template;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Interface.ConfigurationInterface;
import javax.swing.JPanel;

public abstract class AbstractTemplate extends JPanel
{
    protected ConfigurationEntity configuration;

    public AbstractTemplate()
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
