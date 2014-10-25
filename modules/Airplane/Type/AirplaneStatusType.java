package project.modules.Airplane.Type;

import project.modules.Application.Entity.ConfigurationEntity;

public class AirplaneStatusType
{
    private String label;
    private String value;

    public AirplaneStatusType(ConfigurationEntity configuration, String label)
    {
        setLabel(configuration.getTranslator().__(label));
        setValue(label);
    }

    public String getLabel() {
        return this.label;
    }

    public String getValue() {
        return this.value;
    }

    public AirplaneStatusType setLabel(String label) {
        this.label = label;
        return this;
    }

    public AirplaneStatusType setValue(String value) {
        this.value = value;
        return this;
    }

    public String toString()
    {
        return getLabel();
    }
}
