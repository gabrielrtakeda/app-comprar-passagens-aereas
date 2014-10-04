package project.modules.Application.View;

import project.modules.Application.View.AbstractView;
import project.modules.Application.View.Template.AbstractTemplate;
import project.modules.Application.Entity.ConfigurationEntity;

public class NavigationView extends AbstractView
{
    public NavigationView(ConfigurationEntity configuration,
                          AbstractTemplate previousTemplate)
    {
        setTemplate(configuration.getPreviousTemplate());

        configuration.setPreviousTemplate(previousTemplate);
        setConfiguration(configuration);

        showTemplate();
    }
}
