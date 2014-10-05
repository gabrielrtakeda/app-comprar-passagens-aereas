package project.modules.Application.Entity;

import project.modules.Application.Controller.AbstractController;
import project.modules.Application.View.AbstractView;
import project.modules.Application.View.Modal.AbstractModal;
import project.modules.Application.View.Template.AbstractTemplate;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Translation.Translator;
import project.modules.Authentication.Entity.UserEntity;
import java.util.HashMap;
import java.util.Iterator;

public class ConfigurationEntity
{
    protected AbstractController controller;
    protected AbstractView view;
    protected HashMap<String, AbstractModal> modals = new HashMap<String, AbstractModal>();
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

    public ConfigurationEntity setModal(String name, AbstractModal modal)
    {
        modals.put(name, modal);
        return this;
    }

    public AbstractModal getModal(String name)
    {
        return modals.get(name);
    }

    public HashMap<String, AbstractModal> getModals()
    {
        return modals;
    }

    public ConfigurationEntity removeModal(String name)
    {
        modals.remove(name);
        return this;
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

    public String toString()
    {
        StringBuilder builder = new StringBuilder("[\n\t");
        // Controller
        builder.append("Controller: ");
        builder.append(
            getController() != null
             ? getController().getClass().getName()
             : "null"
        ).append("\n\t");

        // View
        builder.append("View: ");
        builder.append(
            getView() != null
             ? getView().getClass().getName()
             : "null"
        ).append("\n\t");

        // Modals
        builder.append("Modals: ");
        if (getModals().size() > 0) {
            builder.append("[");
            Iterator<String> keySetIterator = getModals().keySet().iterator();
            while (keySetIterator.hasNext()) {
                String name = keySetIterator.next();
                builder.append("\n\t\t");
                builder.append("\"" + name + "\": "+ getModal(name).getClass().getName());
            }
            builder.append("\n\t]");
        } else {
            builder.append("null");
        }
        builder.append("\n\t");

        // Template
        builder.append("Template: ");
        builder.append(
            getTemplate() != null
             ? getTemplate().getClass().getName()
             : "null"
        ).append("\n\t");

        // Previous Template
        builder.append("PreviousTemplate: ");
        builder.append(
            getPreviousTemplate() != null
             ? getPreviousTemplate().getClass().getName()
             : "null"
        ).append("\n\t");

        // Action Listener
        builder.append("ActionListener: ");
        builder.append(
            getActionListener() != null
             ? getActionListener().getClass().getName()
             : "null"
        ).append("\n\t");

        // Translator
        builder.append("Translator: ");
        builder.append(
            getTranslator() != null
             ? getTranslator().getClass().getName() + " : " + getTranslator().getLanguage()
             : "null"
        ).append("\n\t");

        // User
        builder.append("User: ");
        if (getUser() != null) {
            builder.append("[\n\t\t");
            builder.append("Id: " + getUser().getId()).append("\n\t\t");
            builder.append("User: " + getUser().getUser()).append("\n\t\t");
            builder.append("Password: " + getUser().getPassword()).append("\n\t\t");
            builder.append("Supervisor: " + getUser().isSupervisor()).append("\n\t\t");
            builder.append("Nome: " + getUser().getNome()).append("\n\t\t");
            builder.append("DataLogin: " + getUser().getDataLogin());
            builder.append("\n\t]");
        } else {
            builder.append("null");
        }

        builder.append("\n]");

        return builder.toString();
    }
}
