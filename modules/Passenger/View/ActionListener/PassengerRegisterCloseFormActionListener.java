package project.modules.Passenger.View.ActionListener;

import project.modules.Application.View.AbstractView;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PassengerRegisterCloseFormActionListener implements ActionListener
{
    private AbstractView view;

    public PassengerRegisterCloseFormActionListener(AbstractView view)
    {
        this.view = view;
    }

    public void actionPerformed(ActionEvent e)
    {
        view.dispose();
    }
}
