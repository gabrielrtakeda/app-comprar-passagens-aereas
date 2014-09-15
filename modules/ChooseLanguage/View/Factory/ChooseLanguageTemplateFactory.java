package project.modules.ChooseLanguage.View.Factory;

import project.modules.Application.View.Template.AbstractTemplate;
import project.modules.ChooseLanguage.View.Template.ChooseLanguageDefaultTemplate;
import project.modules.ChooseLanguage.View.Template.ChooseLanguageWidgetTemplate;
import java.util.Map;
import java.util.HashMap;

public class ChooseLanguageTemplateFactory
{
    public static final String DEFAULT_TEMPLATE_KEY = "default";
    public static final String WIDGET_TEMPLATE_KEY = "widget";

    private static ChooseLanguageTemplateFactory
        instance = new ChooseLanguageTemplateFactory();

    private Map<String, AbstractTemplate>
        strategies = new HashMap<String, AbstractTemplate>(2);

    private ChooseLanguageTemplateFactory()
    {
        strategies.put("default", new ChooseLanguageDefaultTemplate());
        strategies.put("widget", new ChooseLanguageWidgetTemplate());
    }

    public static ChooseLanguageTemplateFactory getInstance()
    {
        return instance;
    }

    public AbstractTemplate get(String templateKey)
    {
        return strategies.get(templateKey);
    }
}
