package project.modules.Passage.View;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.AbstractView;
import project.modules.Menu.View.Template.MenuSupervisorTemplate;
import project.modules.Passage.View.Template.PassageConsultTemplate;

public class PassageConsultView extends AbstractView
{
    public PassageConsultView(ConfigurationEntity configuration)
    {
        configuration.setPreviousTemplate(new MenuSupervisorTemplate(configuration))
                     .setView(this);
        setConfiguration(configuration);
        setTitle(config.getTranslator().__("Check In"));
        setTemplate(new PassageConsultTemplate(config));
        showTemplate();
    }
}
