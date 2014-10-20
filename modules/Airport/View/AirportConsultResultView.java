package project.modules.Airport.View;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.AbstractView;
import project.modules.Airport.View.Template.AirportConsultResultTemplate;

public class AirportConsultResultView extends AbstractView
{
	public AirportConsultResultView(ConfigurationEntity configuration)
	{
		configuration.setView(this);
		setConfiguration(configuration);

		setTitle(configuration.getTranslator().__("Resultado da Pesquisa"));
		setTemplate(new AirportConsultResultTemplate(configuration));
		showTemplate();
	}
}