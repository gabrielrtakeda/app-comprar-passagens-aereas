package project.view.buttons.actions;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
// import project.GUI;
import project.view.pages.AuthenticationPage;
import project.translation.Translator;

public class ChooseLanguageButtonActions implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
    	String language = e.getActionCommand();
    	GUI.translator = new Translator(language);
        GUI.page.setVisible(false);
        GUI.page = new AuthenticationPage();
    }
}
