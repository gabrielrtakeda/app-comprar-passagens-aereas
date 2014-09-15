package project.modules.Passage.View;

import project.modules.Application.View.AbstractView;
import project.modules.Passage.View.Template.PassagePurchaseTemplate;

public class PassagePurchaseView extends AbstractView
{
    public PassagePurchaseView()
    {
        setTitle("Compra de Passagem");
        setTemplate(new PassagePurchaseTemplate());
        showTemplate();
    }
}
