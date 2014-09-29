package project.modules.Application.View;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.AbstractView;
import project.modules.Application.View.Template.AbstractTemplate;

public class GenericView extends AbstractView
{
    public GenericView(ConfigurationEntity configuration)
    {
        configuration.getView().dispose();

        setConfiguration(configuration);
        setTitle(configuration.getView().getTitle());
        setTemplate(configuration.getTemplate());
        showTemplate();
    }
}
