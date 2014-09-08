package project.modules.ChooseLanguage.View.ActionListener;

import project.Main;
import project.modules.Authentication.Controller.AuthenticationController;
import project.modules.Application.Translation.Translator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

public class ChooseLanguageActionListener implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        String language = e.getActionCommand();
        Main.translator = new Translator(language);
        Main.controller.getView().getTemplate().setVisible(false);
        Main.controller = new AuthenticationController();
    }
}
