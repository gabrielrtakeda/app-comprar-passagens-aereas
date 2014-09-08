package project.modules.ChooseLanguage.View.Panel;

import project.modules.Application.View.Button.TransparentButton;
import project.modules.ChooseLanguage.View.ActionListener.ChooseLanguageActionListener;
import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class ChooseLanguageFlagsPanel extends JPanel
{
    protected String[] arLanguages = {"br", "uk", "es", "fr"};

    public ChooseLanguageFlagsPanel()
    {
        super(new GridLayout(1, 4));
        setBorder(new EmptyBorder(10, 0, 0, 0));
        for (String language : arLanguages) {
            TransparentButton button =
                new TransparentButton(
                    new ImageIcon(getClass().getResource("/images/" + language + "_128x128.png")),
                    new Dimension(130, 130)
                );
            button.addActionListener(new ChooseLanguageActionListener());
            button.setActionCommand(language);
            add(button);
        }
    }
}
