package buttons;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TransparentButtonMouseAdapter extends MouseAdapter
{
    private TransparentButton adaptee;

    public TransparentButtonMouseAdapter(TransparentButton adaptee)
    {
        this.adaptee = adaptee;
    }

    public void mousePressed(MouseEvent e)
    {
        adaptee.mousePressed(e);
    }

    public void mouseReleased(MouseEvent e)
    {
        adaptee.mouseReleased(e);
    }
}
