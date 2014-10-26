package project.modules.Flight.Type;

import project.modules.Application.Entity.ConfigurationEntity;

public class FlightStatusType
{
    private ConfigurationEntity configuration;
    private String label;
    private String value;

    public FlightStatusType(ConfigurationEntity configuration, String status)
    {
        setConfiguration(configuration);
        setLabel(status);
        setValue(status);
    }

    public FlightStatusType setConfiguration(ConfigurationEntity configuration)
    {
        this.configuration = configuration;
        return this;
    }

    public String getLabel() {
        return this.label;
    }

    public String getValue() {
        return this.value;
    }

    public FlightStatusType setLabel(String label)
    {
        this.label = configuration.getTranslator().__(label);
        return this;
    }

    public FlightStatusType setValue(String value)
    {
        this.value = value;
        return this;
    }

    public String toString()
    {
        return getLabel();
    }
}
