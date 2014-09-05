package project.view.panels;

import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JButton;
import project.GUI;
import project.view.buttons.TransparentButton;
import project.view.buttons.actions.ChooseLanguageButtonActions;

public class ChooseLanguageFlagsPanel extends JPanel
{
    protected String[] arLanguages = {"en", "br", "sp", "jp"};

    public ChooseLanguageFlagsPanel()
    {
        super(new GridLayout(1, 4));
        for (String language : arLanguages) {
            TransparentButton button =
                new TransparentButton(
                    new ImageIcon(getClass().getResource("/images/" + language + ".png")),
                    new Dimension(130, 130)
                );
            button.addActionListener(new ChooseLanguageButtonActions());
            button.setActionCommand(language);
            add(button);
        }
    }
}
