package project.modules.Passenger.View.ActionListener;

import project.Main;
import project.modules.Application.View.AbstractView;
import project.modules.Passenger.View.PassengerRegisterView;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

public class PassengerRegisterShowFormActionListener implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        AbstractView view = new PassengerRegisterView();
        view.setAlwaysOnTop(true);
        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
