package project;

import java.awt.Container;
import javax.swing.JFrame;
import panels.ChooseLanguagePanel;

public class GUI extends JFrame
{
    protected Container container;

    public GUI()
    {
        super("Language");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(565, 256);

        container = getContentPane();
        container.add(new ChooseLanguagePanel().get());

        setVisible(true);
    }

    public static void main(String args[])
    {
        new GUI();
    }
}
