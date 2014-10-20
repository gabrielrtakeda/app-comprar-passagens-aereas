package project;

import project.modules.Application.Controller.AbstractController;
import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.ChooseLanguage.View.ChooseLanguageView;
import project.modules.Passage.View.PassagePurchaseView;
import project.modules.Translation.Translator;
import project.modules.Authentication.Controller.AuthenticationController;
import project.modules.Authentication.Entity.UserEntity;
import java.util.Date;
import java.text.DateFormat;

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
