package project.modules.Application.Entity;

import project.modules.Application.Controller.AbstractController;
import project.modules.Application.View.AbstractView;
import project.modules.Application.View.Template.AbstractTemplate;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Translation.Translator;
import project.modules.Authentication.Entity.UserEntity;

public class ConfigurationEntity
{
    protected AbstractController controller;
    protected AbstractView view;
    protected AbstractTemplate template;
    protected AbstractTemplate previousTemplate;
    protected AbstractActionListener actionListener;
    protected Translator translator;
    protected UserEntity user;

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

    public ConfigurationEntity setUser(UserEntity user)
    {
        this.user = user;
        return this;
    }

    public UserEntity getUser()
    {
        return user;
    }

    private ConfigurationEntity build(ConfigurationEntity configuration)
    {
        return this .setController(configuration.getController())
                    .setView(configuration.getView())
                    .setTemplate(configuration.getTemplate())
                    .setActionListener(configuration.getActionListener())
                    .setTranslator(configuration.getTranslator())
                    .setUser(configuration.getUser());
    }
}
