package project.modules.Passage.View;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.AbstractView;
import project.modules.Menu.View.Template.MenuSupervisorTemplate;
import project.modules.Menu.View.Template.MenuAtendenteTemplate;
import project.modules.Passage.View.Template.PassageConsultTemplate;

public class PassageConsultView extends AbstractView
{
    public PassageConsultView(ConfigurationEntity configuration)
    {
        configuration.setView(this);
        setConfiguration(configuration);

        setTitle(configuration.getTranslator().__("Check In"));
        setTemplate(new PassageConsultTemplate(configuration));
        showTemplate();
    }
}
