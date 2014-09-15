package project.modules.Menu.View;

import project.Main;
import project.modules.Application.View.AbstractView;
import project.modules.Menu.View.Template.MenuAtendenteTemplate;
import project.modules.Menu.View.Template.MenuSupervisorTemplate;

public class MenuAtendenteView extends AbstractView
{
    public MenuAtendenteView()
    {
        setTitle("Menu Inicial");
        setTemplate(new MenuSupervisorTemplate());
        showTemplate();
    }
}
