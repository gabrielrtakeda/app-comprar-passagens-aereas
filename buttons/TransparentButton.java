package buttons;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class TransparentButton extends JButton
{
    public TransparentButton(ImageIcon image)
    {
        super(image);
        stylize();
        this.addMouseListener(new TransparentButtonMouseAdapter(this));
    }

    public TransparentButton(ImageIcon image, Dimension dimension)
    {
        this(image);
        setSize(dimension);
    }

    public TransparentButton(ImageIcon image, int width, int height)
    {
        this(image);
        setSize(width, height);
    }

    private void stylize()
    {
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setBorder(null);
        setFocusPainted(false);
    }

    public void mousePressed(MouseEvent e)
    {
        setBackground(
            new Color(0xCCCCCC)
        );
        setBorder(
            new LineBorder(
                new Color(0xCCCCCC), 1, true
            )
        );
        setOpaque(true);
        setContentAreaFilled(true);
        setBorderPainted(true);
    }

    public void mouseReleased(MouseEvent e)
    {
        setBorder(null);
    }
}
