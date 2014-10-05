package project.modules.Passenger.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PassengerRegisterActionListener extends AbstractActionListener
{
    protected String nameModal = "passenger-register";

    public PassengerRegisterActionListener(ConfigurationEntity configuration)
    {
        setConfiguration(configuration.setActionListener(this));
    }

    public void actionPerformed(ActionEvent e)
    {
        JOptionPane.showMessageDialog(
            null,
            config.getTranslator().__("Passageiro cadastrado com sucesso!")
        );
        config.getModal(nameModal).dispose();
        config.removeModal(nameModal);
    }
}
