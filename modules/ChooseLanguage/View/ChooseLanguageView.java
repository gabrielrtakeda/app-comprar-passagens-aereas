package project.modules.ChooseLanguage.View;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.AbstractView;
import project.modules.Application.View.Template.AbstractTemplate;
import project.modules.ChooseLanguage.View.Template.ChooseLanguageDefaultTemplate;

public class ChooseLanguageView extends AbstractView
{
    public ChooseLanguageView(ConfigurationEntity configuration)
    {
        setConfiguration(configuration.setView(this));
        setTitle("Linguagem");
        setTemplate(new ChooseLanguageDefaultTemplate(configuration));
        showTemplate();
    }
}
