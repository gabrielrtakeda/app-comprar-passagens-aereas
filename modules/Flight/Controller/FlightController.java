package project.modules.Flight.Controller;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.Controller.AbstractController;

public class FlightController extends AbstractController
{
	public FlightController(ConfigurationEntity configuration)
	{
		super();
		configuration.setController(this);
		setConfiguration(configuration);
	}

    /**
     * Mock
     */
    public static String[] getAirplanes()
    {
        return new String[]
        {
            "ERJ 135", "ERJ 140", "ERJ 145", "ERJ 145 XR",
            "E170", "E175", "E190", "E195",
            "E175-E2", "E190-E2", "E195-E2"
        };
    }

    /**
     * Mock
     */
	public static String[] getAirports()
	{
        return new String[]
        {
            "Aeroporto Internacional de San Francisco",
            "Aeroporto Internacional John F. Kennedy",
            "Aeroporto de LaGuardia",
            "Aeroporto Internacional de Newark",
            "Aeroporto Internacional Logan",
            "Aeroporto Internacional O'Hare",
            "Aeroporto Internacional Washington Dulles",
            "Aeroporto Ronald Reagan",
            "Aeroporto Internacional William B Hartsfield",
            "Aeroporto Internacional de Orlando",
            "Aeroporto Internacional de Miami",
            "Aeroporto Internacional George Bush",
            "Aeroporto Internacional de Dallas-Fort Worth",
            "Aeroporto Internacional de Los Angeles",
            "Aeroporto Internacional McCarran",
            "Aeroporto Internacional de Honolulu",
            "Aeroporto Internacional de San Francisco",
            "Aeroporto Internacional Tacoma",
            "Aeroporto Internacional de Denver",
            "Aeroporto Internacional de Sky Harbor",
            "Aeroporto Internacional Midway",
            "Aeroporto Internacional de Salt Lake City"
        };
	}

    /**
     * Mock
     */
    public static String[] getStatusOptions(ConfigurationEntity configuration)
    {
        return new String[]
        {
            configuration.getTranslator().__("Cancelado"),
            configuration.getTranslator().__("Adiado"),
            configuration.getTranslator().__("Prorrogado"),
            configuration.getTranslator().__("Suspenso"),
            configuration.getTranslator().__("Transferido"),
            configuration.getTranslator().__("Pendente")
        };
    }
}