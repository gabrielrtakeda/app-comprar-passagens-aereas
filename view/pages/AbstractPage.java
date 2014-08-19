package project.view.pages;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class AbstractPage extends JFrame
{
    public AbstractPage(String title)
    {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void showPage()
    {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(
            (int) ((dimension.getWidth() - getWidth()) / 2),
            (int) ((dimension.getHeight() - getHeight()) / 2)
        );
        setVisible(true);
    }
}
