package project.modules.Application.View.Button;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class ImageButton extends JButton
{
    public ImageButton( String message,
                        String imagePath)
    {
        super(message);
        setIcon(new ImageIcon(getClass().getResource(imagePath)));
        setPreferredSize(new Dimension(430, 45));
    }

    public ImageButton( String message,
                        String imagePath,
                        ActionListener actionListener)
    {
        super(message);
        setIcon(new ImageIcon(getClass().getResource(imagePath)));
        setPreferredSize(new Dimension(430, 45));
        addActionListener(actionListener);
    }

    public ImageButton( String message,
                        String imagePath,
                        Dimension dimension)
    {
        super(message);
        setIcon(new ImageIcon(getClass().getResource(imagePath)));
        setPreferredSize(dimension);
    }

    public ImageButton( String message,
                        String imagePath,
                        Dimension dimension,
                        ActionListener actionListener)
    {
        super(message);
        setIcon(new ImageIcon(getClass().getResource(imagePath)));
        setPreferredSize(dimension);
        addActionListener(actionListener);
    }
}
