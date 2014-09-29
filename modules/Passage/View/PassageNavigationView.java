package project.modules.Passage.View;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.AbstractView;
import project.modules.Application.View.Template.AbstractTemplate;

public class PassageNavigationView extends AbstractView
{
    public PassageNavigationView(   ConfigurationEntity configuration,
                                    String title,
                                    AbstractTemplate template)
    {
        setConfiguration(configuration);
        setTitle(title);
        setTemplate(template);
        showTemplate();
    }
}
