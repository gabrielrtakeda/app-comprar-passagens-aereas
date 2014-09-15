package project.modules.Menu.View;

import project.Main;
import project.modules.Application.View.AbstractView;
import project.modules.Translation.Exception.TranslationNotFoundException;
import project.modules.Menu.View.Template.MenuSupervisorTemplate;

public class MenuSupervisorView extends AbstractView
{
    public MenuSupervisorView()
    {
        setTitle("Menu Inicial");
        setTemplate(new MenuSupervisorTemplate());
        showTemplate();
    }
}
