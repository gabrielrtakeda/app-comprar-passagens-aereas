package panels;

import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JButton;
import buttons.TransparentButton;

public class ChooseLanguageFlagsPanel extends JPanel
{
    protected String[] arLanguages = {"en", "br", "sp", "jp"};

    public ChooseLanguageFlagsPanel()
    {
        super(new GridLayout(1, 4));
        for (String image : arLanguages) {
            add(
                new TransparentButton(
                    new ImageIcon(getClass().getResource("/images/" + image + ".png")),
                    new Dimension(130, 130)
                )
            );
        }
    }
}
