package project;

import project.modules.Application.Controller.AbstractController;
import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.ChooseLanguage.View.ChooseLanguageView;

public class Main
{
    public Main()
    {
        new ChooseLanguageView(new ConfigurationEntity());
    }

    public static void main(String args[])
    {
        new Main();
    }
}
