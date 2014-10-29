package project.modules.Flight.Type;

import project.modules.Application.View.ActionListener.AbstractActionListener;

public class FlightButtonType
{
    private String text;
    private AbstractActionListener actionListener;

    public String getText()
    {
        return this.text;
    }

    public AbstractActionListener getActionListener()
    {
        return this.actionListener;
    }

    public FlightButtonType setText(String text)
    {
        this.text = text;
        return this;
    }

    public FlightButtonType setActionListener(AbstractActionListener actionListener)
    {
        this.actionListener = actionListener;
        return this;
    }
}
