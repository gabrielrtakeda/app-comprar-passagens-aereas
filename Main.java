package project;

import project.modules.Application.Controller.AbstractController;
import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.ChooseLanguage.Controller.ChooseLanguageController;

public class Main
{
    public Main()
    {
        ConfigurationEntity configurationEntity = new ConfigurationEntity();
        ChooseLanguageController controller = new ChooseLanguageController(configurationEntity);
        controller.indexAction();
    }

    public static void main(String args[])
    {
        new Main();
    }
}
