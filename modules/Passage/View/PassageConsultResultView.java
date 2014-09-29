package project.modules.Passage.View;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.AbstractView;
import project.modules.Passage.View.Template.PassageConsultResultTemplate;

public class PassageConsultResultView extends AbstractView
{
    public PassageConsultResultView(ConfigurationEntity configuration)
    {
        configuration.setPreviousTemplate(configuration.getTemplate());
        configuration.setView(this);
        setConfiguration(configuration);

        setTitle(
            config.getTranslator().__("Check In")
        );
        setTemplate(new PassageConsultResultTemplate(config));
        showTemplate();
    }
}
