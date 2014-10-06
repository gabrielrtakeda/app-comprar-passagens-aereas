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
    // public Main()
    // {
    //     new ChooseLanguageView(new ConfigurationEntity());
    // }

    public Main()
    {
        AuthenticationController authenticationController = new AuthenticationController();
        UserEntity userEntity = authenticationController.authenticate("gabrieltakeda", "eusoeu");
        userEntity.setDataLogin(DateFormat.getDateTimeInstance().format(new Date()));

        ConfigurationEntity configurationEntity = new ConfigurationEntity();
        configurationEntity.setTranslator(new Translator("br"));
        configurationEntity.setUser(userEntity);

        new PassagePurchaseView(configurationEntity);
    }

    public static void main(String args[])
    {
        new Main();
    }
}
