package project;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import panels.ChooseLanguagePanel;

public class GUI extends JFrame
{
    protected Container container;

    public GUI()
    {
        super("Language");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        container = getContentPane();
        container.add(new ChooseLanguagePanel());
        pack();

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(
            (int) ((dimension.getWidth() - getWidth()) / 2),
            (int) ((dimension.getHeight() - getHeight()) / 2)
        );
        setVisible(true);
    }

    public static void main(String args[])
    {
        new GUI();
    }
}
