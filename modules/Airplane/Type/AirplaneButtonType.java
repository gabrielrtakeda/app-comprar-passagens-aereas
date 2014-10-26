package project.modules.Airplane.Type;

import project.modules.Application.View.ActionListener.AbstractActionListener;

public class AirplaneButtonType
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

    public AirplaneButtonType setText(String text)
    {
        this.text = text;
        return this;
    }

    public AirplaneButtonType setActionListener(AbstractActionListener actionListener)
    {
        this.actionListener = actionListener;
        return this;
    }
}
