package project.modules.ChooseLanguage.View;

import project.modules.Application.View.AbstractView;
import project.modules.ChooseLanguage.View.Template.ChooseLanguageTemplate;

public class ChooseLanguageView extends AbstractView
{
    public ChooseLanguageView()
    {
        setTitle("Linguagem");
        setTemplate(new ChooseLanguageTemplate());
        showPage();
    }
}
