package project.modules.Application.Controller;

import project.modules.Application.View.AbstractView;

public abstract class AbstractController
{
    protected AbstractView view;

    public AbstractController()
    {
    }

    public void setView(AbstractView view)
    {
        this.view = view;
    }

    public AbstractView getView()
    {
        return this.view;
    }
}
