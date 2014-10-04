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

        setTitle(config.getTranslator().__("Check In"));
        setTemplate(new PassageConsultTemplate(config));
        showTemplate();
        System.out.println("Actual View: " + configuration.getView().getClass().getName());
        System.out.println("Actual Previous Template: " + configuration.getPreviousTemplate().getClass().getName());
        System.out.println("PassageConsultView");
        System.out.println("--------------------------------------");
    }
}
