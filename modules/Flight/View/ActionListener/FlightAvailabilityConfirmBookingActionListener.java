package project.modules.Flight.View.ActionListener;

import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Passenger.View.Modal.PassengerRegisterModal;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class FlightAvailabilityConfirmBookingActionListener extends AbstractActionListener
{
    public FlightAvailabilityConfirmBookingActionListener(ConfigurationEntity configuration)
    {
        configuration.setActionListener(this);
        setConfiguration(configuration);
    }

    public void actionPerformed(ActionEvent e)
    {
        JTextField passengerQuantity = (JTextField) getComponent("passenger-quantity");

        if (passengerQuantity.getText().equals("")) {
            JOptionPane.showMessageDialog(
                null,
                "Favor informe a quantidade de passageiros que deseja cadastrar.",
                "Campo obrigatório",
                JOptionPane.ERROR_MESSAGE
            );
        } else {
            Integer quantity = Integer.parseInt(passengerQuantity.getText());
            while (quantity != 0) {
                    new PassengerRegisterModal(config);
                    System.out.println(config.toString());
                    System.out.println(config.hasModal("passenger-register"));
                quantity--;
            }
        }
    }
}
