package project.modules.Application.Entity;

import project.modules.Application.Controller.AbstractController;
import project.modules.Application.View.AbstractView;
import project.modules.Application.View.Template.AbstractTemplate;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Translation.Translator;

public class ConfigurationEntity
{
    protected AbstractController controller;
    protected AbstractView view;
    protected AbstractTemplate template;
    protected AbstractTemplate previousTemplate;
    protected AbstractActionListener actionListener;
    protected Translator translator;
    protected UserEntity user;

    public ConfigurationEntity() {}

    public ConfigurationEntity( AbstractController controller,
                                AbstractView view,
                                AbstractTemplate template,
                                AbstractActionListener actionListener,
                                Translator translator)
    {
        this.setController(controller)
            .setView(view)
            .setTemplate(template)
            .setActionListener(actionListener)
            .setTranslator(translator);
    }

    public ConfigurationEntity( AbstractView view,
                                Translator translator)
    {
        this.setView(view)
            .setTranslator(translator);
    }

    public ConfigurationEntity(AbstractController controller)
    { setController(controller); }

    public ConfigurationEntity(AbstractView view)
    { setView(view); }

    public ConfigurationEntity(AbstractTemplate template)
    { setTemplate(template); }

    public ConfigurationEntity(AbstractActionListener actionListener)
    { setActionListener(actionListener); }

    public ConfigurationEntity(Translator translator)
    { setTranslator(translator); }


    public ConfigurationEntity(ConfigurationEntity configuration)
    { build(configuration); }

    public ConfigurationEntity(ConfigurationEntity configuration, AbstractController controller)
    { build(configuration); setController(controller); }

    public ConfigurationEntity(ConfigurationEntity configuration, AbstractView view)
    { build(configuration); setView(view); }

    public ConfigurationEntity(ConfigurationEntity configuration, AbstractTemplate template)
    { build(configuration); setTemplate(template); }

    public ConfigurationEntity(ConfigurationEntity configuration, AbstractActionListener actionListener)
    { build(configuration); setActionListener(actionListener); }

    public ConfigurationEntity(ConfigurationEntity configuration, Translator translator)
    { build(configuration); setTranslator(translator); }



    public ConfigurationEntity setController(AbstractController controller)
    {
        this.controller = controller;
        return this;
    }

    public AbstractController getController()
    {
        return controller;
    }

    public ConfigurationEntity setView(AbstractView view)
    {
        this.view = view;
        return this;
    }

    public AbstractView getView()
    {
        return view;
    }

    public ConfigurationEntity setTemplate(AbstractTemplate template)
    {
        this.template = template;
        return this;
    }

    public AbstractTemplate getTemplate()
    {
        return template;
    }

    public ConfigurationEntity setPreviousTemplate(AbstractTemplate previousTemplate)
    {
        this.previousTemplate = previousTemplate;
        return this;
    }

    public AbstractTemplate getPreviousTemplate()
    {
        return previousTemplate;
    }

    public ConfigurationEntity setActionListener(AbstractActionListener actionListener)
    {
        this.actionListener = actionListener;
        return this;
    }

    public AbstractActionListener getActionListener()
    {
        return actionListener;
    }

    public ConfigurationEntity setTranslator(Translator translator)
    {
        this.translator = translator;
        return this;
    }

    public Translator getTranslator()
    {
        return translator;
    }

    private ConfigurationEntity build(ConfigurationEntity configuration)
    {
        return this .setController(configuration.getController())
                    .setView(configuration.getView())
                    .setTemplate(configuration.getTemplate())
                    .setActionListener(configuration.getActionListener())
                    .setTranslator(configuration.getTranslator());
    }
}
