package project.modules.Passage.Model;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Model.AbstractModel;
import project.modules.Passage.Entity.PassageEntity;
import project.modules.Passage.View.PassagePurchaseView;
import project.modules.Flight.Entity.FlightEntity;

public class PassageModel extends AbstractModel
{
    public PassageModel(ConfigurationEntity configuration)
    {
        configuration.setModel(this);
        setConfiguration(configuration);
    }

    public void flightConfirmation()
    {
        FlightEntity flightEntity = (FlightEntity) configuration.getEntity("passage-purchase-flight");
        PassageEntity passageEntity = new PassageEntity();
        passageEntity.setFlight(flightEntity);
        passageEntity.setPriceTotal(flightEntity.getPrice());
        configuration.removeEntity("passage-purchase-flight");
        configuration.setEntity("passage-purchase", passageEntity);
        configuration.disposeView();
        new PassagePurchaseView(configuration);
    }
}
