package project.modules.Flight.View;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.AbstractView;
import project.modules.Flight.View.Template.FlightConsultResultTemplate;

public class FlightConsultResultView extends AbstractView
{
	public FlightConsultResultView(ConfigurationEntity configuration)
	{
		configuration.setView(this);
		setConfiguration(configuration);

		setTitle(configuration.getTranslator().__("Resultado da Pesquisa"));
		setTemplate(new FlightConsultResultTemplate(configuration));
		showTemplate();
	}
}
