package panels;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JButton;

public class ChooseLanguageFlagsPanel extends JPanel implements JPanelInterface
{
    protected String[] arLanguages = {"en", "br", "sp", "jp"};

    public ChooseLanguageFlagsPanel()
    {
        super(new GridLayout(1, 4));
        for (String image : arLanguages) {
            JButton btLanguage =
                new JButton(
                    new ImageIcon(
                        getClass().getResource("/images/" + image + ".png")
                    )
                );
            btLanguage.setSize(130, 130);
            btLanguage.setBorderPainted(false);
            add(btLanguage);
        }
    }

    public JPanel get()
    {
        return this;
    }
}
