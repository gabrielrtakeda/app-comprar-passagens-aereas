package project.modules.Application.View.Template;

import project.modules.Application.View.AbstractView;
import javax.swing.JPanel;

public abstract class AbstractTemplate extends JPanel
{
    private AbstractView view;

    public AbstractTemplate()
    {}

    public AbstractTemplate(AbstractView view)
    {
        setView(view);
    }

    public void setView(AbstractView view)
    {
        this.view = view;
    }

    public AbstractView getView()
    {
        return view;
    }
}
