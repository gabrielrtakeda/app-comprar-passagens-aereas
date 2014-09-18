package project.modules.Passenger.View.ActionListener;

import project.modules.Application.View.AbstractView;
import project.Main;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PassengerRegisterActionListener implements ActionListener
{
    private AbstractView view;

    public PassengerRegisterActionListener(AbstractView view)
    {
        this.view = view;
    }

    public void actionPerformed(ActionEvent e)
    {
        JOptionPane.showMessageDialog(null, "Passageiro cadastrado com sucesso!");
        view.dispose();
    }
}
