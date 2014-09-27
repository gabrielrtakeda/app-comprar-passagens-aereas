package project.modules.Passage.View;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.AbstractView;
import project.modules.Passage.View.Template.PassagePurchaseTemplate;

public class PassagePurchaseView extends AbstractView
{
    public PassagePurchaseView(ConfigurationEntity configuration)
    {
        setConfiguration(configuration.setView(this));
        setTitle(
            config.getTranslator().__("Compra de Passagem")
        );
        setTemplate(new PassagePurchaseTemplate(config));
        showTemplate();
    }
}
