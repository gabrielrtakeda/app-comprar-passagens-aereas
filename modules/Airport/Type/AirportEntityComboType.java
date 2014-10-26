package project.modules.Airport.Type;

import project.modules.Airport.Entity.AirportEntity;

public class AirportEntityComboType extends AirportEntity
{
    public String toString()
    {
        return getDescription();
    }
}
