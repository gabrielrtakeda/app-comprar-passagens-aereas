package project.modules.ChooseLanguage.View;

import project.modules.Application.View.AbstractView;
import project.modules.Application.View.Template.AbstractTemplate;
import project.modules.ChooseLanguage.View.Factory.ChooseLanguageTemplateFactory;

public class ChooseLanguageView extends AbstractView
{
    private static final String title = "Linguagem";

    private static ChooseLanguageTemplateFactory
        templateFactory = ChooseLanguageTemplateFactory.getInstance();

    public ChooseLanguageView()
    {
        setTitle(title);
        setTemplate(templateFactory.get("default"));
        showTemplate();
    }

    public static AbstractTemplate getTemplate(String templateFlavour)
    {
        return templateFactory.get(templateFlavour);
    }
}
