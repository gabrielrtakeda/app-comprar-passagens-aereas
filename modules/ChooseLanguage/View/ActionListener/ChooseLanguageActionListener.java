package project.modules.ChooseLanguage.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.ChooseLanguage.Controller.ChooseLanguageController;
import java.awt.event.ActionEvent;

public class ChooseLanguageActionListener extends AbstractActionListener
{
    public ChooseLanguageActionListener(ConfigurationEntity configuration)
    {
        configuration.setActionListener(this);
        setConfiguration(configuration);
    }

    public void actionPerformed(ActionEvent e)
    {
        getController().translatorAction(e.getActionCommand());

        if (configuration.getQueryString("using-widget") == "yes") {
            getController().changeLanguageAction();
        } else {
            getController().authenticationAction();
        }
    }

    private ChooseLanguageController getController()
    {
        return new ChooseLanguageController(configuration);
    }
}
