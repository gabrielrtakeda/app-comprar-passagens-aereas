package project.modules.Airport.Type;

import project.modules.Application.View.ActionListener.AbstractActionListener;

public class AirportConsultContinueButtonType
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

    public AirportConsultContinueButtonType setText(String text)
    {
        this.text = text;
        return this;
    }

    public AirportConsultContinueButtonType
        setActionListener(AbstractActionListener actionListener)
    {
        this.actionListener = actionListener;
        return this;
    }
}
