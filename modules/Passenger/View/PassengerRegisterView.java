package project.modules.Passenger.View;

import project.modules.Application.View.AbstractView;
import project.modules.Passenger.View.Template.PassengerRegisterTemplate;

public class PassengerRegisterView extends AbstractView
{
    public PassengerRegisterView()
    {
        setTitle("Cadastro de Passageiro");
        setTemplate(new PassengerRegisterTemplate());
        showTemplate();
    }
}
