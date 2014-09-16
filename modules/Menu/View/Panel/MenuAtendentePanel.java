package project.modules.Menu.View.Panel;

import project.modules.Application.View.Button.ImageButton;
import project.modules.Passage.View.ActionListener.PassagePurchaseActionListener;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class MenuAtendentePanel extends JPanel
{
    public MenuAtendentePanel()
    {
        super(new GridLayout(4, 1));
        setBorder(new EmptyBorder(0, 45, 0, 45));
        String imageDirectoryPath = "/images/buttonIcons/";

        add(new ImageButton(
            "Compra de Passagem",
            imageDirectoryPath + "basket.png",
            new PassagePurchaseActionListener()
        ));
        add(new ImageButton(
            "Check-in",
            imageDirectoryPath + "check.png"
        ));
        add(new ImageButton(
            "Cancelamento",
            imageDirectoryPath + "advertising.png"
        ));
        add(new ImageButton(
            "Transferência",
            imageDirectoryPath + "refresh.png"
        ));
    }
}
