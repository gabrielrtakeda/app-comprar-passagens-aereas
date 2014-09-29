package project.modules.ChooseLanguage.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.Button.TransparentButton;
import project.modules.ChooseLanguage.View.ActionListener.ChooseLanguageActionListener;
import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class AbstractChooseLanguageFlagsPanel extends JPanel
{
    protected String[] arLanguages = {"br", "uk", "es", "fr"};
    protected String resourceDirectory = "/images/flags/";

    public AbstractChooseLanguageFlagsPanel(ConfigurationEntity configuration,
                                            EmptyBorder margin,
                                            String iconSize,
                                            Dimension flagButtonSize)
    {
        super(new GridLayout(1, 4));
        setBorder(margin);
        for (String language : arLanguages) {
            TransparentButton button =
                new TransparentButton(
                    new ImageIcon(
                        getClass().getResource(
                            resourceDirectory + language + "_" + iconSize + ".png"
                        )
                    ),
                    flagButtonSize
                );
            button.addActionListener(new ChooseLanguageActionListener(configuration));
            button.setActionCommand(language);
            add(button);
        }
    }
}
