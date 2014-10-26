package project.modules.Airplane.Type;

import project.modules.Application.Entity.ConfigurationEntity;

public class AirplaneConsultSearchComboType
{
    private final String label;
    private final String value;

    public AirplaneConsultSearchComboType(
        ConfigurationEntity configuration,
        String label,
        String value)
    {
        this.label = configuration.getTranslator().__(label);
        this.value = value;
    }

    public String toString()
    {
        return getLabel();
    }

    public String getLabel()
    {
        return label;
    }

    public String getValue()
    {
        return value;
    }
}
