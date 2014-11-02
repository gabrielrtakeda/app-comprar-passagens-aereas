package project.modules.Passenger.Type;

import project.modules.Application.Entity.ConfigurationEntity;

public class SalutationType
{
    private ConfigurationEntity configuration;
    private String label;
    private String value;

    public SalutationType(ConfigurationEntity configuration, String label, String value)
    {
        setConfiguration(configuration);
        setLabel(label);
        setValue(value);
    }

    public ConfigurationEntity getConfiguration() {
        return this.configuration;
    }

    public String getLabel() {
        return this.label;
    }

    public String getValue() {
        return this.value;
    }

    public SalutationType setConfiguration(ConfigurationEntity configuration) {
        this.configuration = configuration;
        return this;
    }

    public SalutationType setLabel(String label) {
        this.label = getConfiguration().getTranslator().__(label);
        return this;
    }

    public SalutationType setValue(String value) {
        this.value = value;
        return this;
    }

    public String toString()
    {
        return this.getLabel();
    }
}
