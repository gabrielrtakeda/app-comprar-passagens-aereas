package project.modules.Application.Entity;

import project.modules.Application.Controller.AbstractController;
import project.modules.Application.Model.AbstractModel;
import project.modules.Application.Entity.AbstractEntity;
import project.modules.Application.View.AbstractView;
import project.modules.Application.View.Modal.AbstractModal;
import project.modules.Application.View.Template.AbstractTemplate;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Translation.Translator;
import project.modules.Authentication.Entity.UserEntity;
import java.awt.Component;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JTextField;

public class ConfigurationEntity
{
    protected AbstractController controller;
    protected AbstractModel model;
    protected AbstractView view;
    protected Map<String, AbstractEntity> entities = new HashMap<String, AbstractEntity>();
    protected List<AbstractEntity> entitiesCollection = new ArrayList<AbstractEntity>();
    protected HashMap<String, AbstractModal> modals = new HashMap<String, AbstractModal>();
    protected AbstractTemplate template;
    protected AbstractTemplate previousTemplate;
    protected AbstractActionListener actionListener;
    protected Translator translator;
    protected UserEntity user;
    protected Map<String, Map<String, Component>> parameters = new HashMap<String, Map<String, Component>>();
    protected Map<String, String> queryString = new HashMap<String, String>();

    /**
     * Controller
     */
    public ConfigurationEntity setController(AbstractController controller)
    {
        this.controller = controller;
        return this;
    }

    public AbstractController getController()
    {
        return controller;
    }

    /**
     * Model
     */
    public ConfigurationEntity setModel(AbstractModel model)
    {
        this.model = model;
        return this;
    }

    public AbstractModel getModel()
    {
        return this.model;
    }

    /**
     * View
     */
    public ConfigurationEntity setView(AbstractView view)
    {
        this.view = view;
        return this;
    }

    public AbstractView getView()
    {
        return view;
    }

    public ConfigurationEntity disposeView()
    {
        this.getView().dispose();
        return this;
    }

    /**
     * Entities
     */
    public ConfigurationEntity setEntity(String name, AbstractEntity entity)
    {
        this.entities.put(name, entity);
        return this;
    }

    public AbstractEntity getEntity(String name)
    {
        return this.entities.get(name);
    }

    public Boolean hasEntity(String name)
    {
        return this.entities.containsKey(name);
    }

    public ConfigurationEntity removeEntity(String name)
    {
        this.entities.remove(name);
        return this;
    }

    public ConfigurationEntity setEntities(Map<String, AbstractEntity> entities)
    {
        this.entities = entities;
        return this;
    }

    public Map<String, AbstractEntity> getEntities()
    {
        return this.entities;
    }

    /**
     * Entities Collection
     */
    public ConfigurationEntity setEntitiesCollection(List<AbstractEntity> entitiesCollection)
    {
        this.entitiesCollection = entitiesCollection;
        return this;
    }

    public List<AbstractEntity> getEntitiesCollection()
    {
        return this.entitiesCollection;
    }

    public ConfigurationEntity addEntityInCollection(AbstractEntity entity)
    {
        this.entitiesCollection.add(entity);
        return this;
    }

    public AbstractEntity getEntityOfCollection(Integer index)
    {
        return this.entitiesCollection.get(index);
    }

    public ConfigurationEntity clearEntitiesCollection()
    {
        this.entitiesCollection.clear();
        return this;
    }

    /**
     * Modal
     */
    public ConfigurationEntity setModal(String name, AbstractModal modal)
    {
        modals.put(name, modal);
        return this;
    }

    public AbstractModal getModal(String name)
    {
        return modals.get(name);
    }

    public Boolean hasModal(String name)
    {
        return modals.containsKey(name);
    }

    public ConfigurationEntity removeModal(String name)
    {
        modals.remove(name);
        return this;
    }

    public ConfigurationEntity setModals(HashMap<String, AbstractModal> modals)
    {
        this.modals = modals;
        return this;
    }

    public HashMap<String, AbstractModal> getModals()
    {
        return modals;
    }

    public ConfigurationEntity clearModals()
    {
        this.modals.clear();
        return this;
    }

    public ConfigurationEntity disposeModal(String name)
    {
        this.getModal(name).dispose();
        this.removeModal(name);
        return this;
    }

    /**
     * Template
     */
    public ConfigurationEntity setTemplate(AbstractTemplate template)
    {
        this.template = template;
        return this;
    }

    public AbstractTemplate getTemplate()
    {
        return template;
    }

    /**
     * Previous Template
     */
    public ConfigurationEntity setPreviousTemplate(AbstractTemplate previousTemplate)
    {
        this.previousTemplate = previousTemplate;
        return this;
    }

    public AbstractTemplate getPreviousTemplate()
    {
        return previousTemplate;
    }

    /**
     * Action Listener
     */
    public ConfigurationEntity setActionListener(AbstractActionListener actionListener)
    {
        this.actionListener = actionListener;
        return this;
    }

    public AbstractActionListener getActionListener()
    {
        return actionListener;
    }

    /**
     * Translator
     */
    public ConfigurationEntity setTranslator(Translator translator)
    {
        this.translator = translator;
        return this;
    }

    public Translator getTranslator()
    {
        return translator;
    }

    /**
     * User
     */
    public ConfigurationEntity setUser(UserEntity user)
    {
        this.user = user;
        return this;
    }

    public UserEntity getUser()
    {
        return user;
    }

    /**
     * Parameters
     */
    public ConfigurationEntity setParameter(String name, Map<String, Component> parameter)
    {
        this.parameters.put(name, parameter);
        return this;
    }

    public Map<String, Component> getParameter(String name)
    {
        return this.parameters.get(name);
    }

    public Boolean hasParameter(String name)
    {
        return parameters.containsKey(name);
    }

    public ConfigurationEntity setParameters(Map<String, Map<String, Component>> parameters)
    {
        this.parameters = parameters;
        return this;
    }

    public Map<String, Map<String, Component>> getParameters()
    {
        return this.parameters;
    }

    public ConfigurationEntity clearParameters()
    {
        this.parameters.clear();
        return this;
    }

    /**
     * Query String
     */
    public ConfigurationEntity setQueryString(String name, String query)
    {
        this.queryString.put(name, query);
        return this;
    }

    public String getQueryString(String name)
    {
        return this.queryString.get(name);
    }

    public Boolean hasQueryString(String name)
    {
        return this.queryString.containsKey(name);
    }

    public ConfigurationEntity removeQueryString(String name)
    {
        this.queryString.remove(name);
        return this;
    }

    public ConfigurationEntity setQueryStrings(Map<String, String> queryStrings)
    {
        this.queryString = queryStrings;
        return this;
    }

    public Map<String, String> getQueryStrings()
    {
        return this.queryString;
    }

    public ConfigurationEntity clearQueryStrings()
    {
        this.queryString.clear();
        return this;
    }

    /**
     * Build Entire Configuration
     */
    private ConfigurationEntity build(ConfigurationEntity configuration)
    {
        return this .setController(configuration.getController())
                    .setModel(configuration.getModel())
                    .setView(configuration.getView())
                    .setEntities(configuration.getEntities())
                    .setEntitiesCollection(configuration.getEntitiesCollection())
                    .setModals(configuration.getModals())
                    .setTemplate(configuration.getTemplate())
                    .setActionListener(configuration.getActionListener())
                    .setTranslator(configuration.getTranslator())
                    .setUser(configuration.getUser())
                    .setParameters(configuration.getParameters())
                    .setQueryStrings(configuration.getQueryStrings());
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

        // Model
        builder.append("Model: ");
        builder.append(
            getModel() != null
             ? getModel().getClass().getName()
             : "null"
        ).append("\n\t");

        // View
        builder.append("View: ");
        builder.append(
            getView() != null
             ? getView().getClass().getName()
             : "null"
        ).append("\n\t");

        // Entities
        builder.append("Entities: ");
        if (getEntities().size() > 0) {
            builder.append("[");
            Iterator<String> keySetIterator = getEntities().keySet().iterator();
            while (keySetIterator.hasNext()) {
                String name = keySetIterator.next();
                builder.append("\n\t\t");
                builder.append("\"" + name + "\": "+ getEntity(name).getClass().getName());
            }
            builder.append("\n\t]");
        } else {
            builder.append("null");
        }
        builder.append("\n\t");

        // Entities Collection
        builder.append("Entities Collection: ");
        if (getEntitiesCollection().size() > 0) {
            builder.append("[");
            Iterator<AbstractEntity> iterator = getEntitiesCollection().iterator();
            Integer index = 0;
            while (iterator.hasNext()) {
                builder.append("\n\t\t");
                builder.append(index + ": [\n");
                builder.append(iterator.next().toString());
                builder.append("]");
                index++;
                builder.append("\n\t\t]");
            }
        } else {
            builder.append("null");
        }
        builder.append("\n\t");

        // Modals
        builder.append("Modals: ");
        if (getModals().size() > 0) {
            builder.append("[\n");
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
        builder.append("\n\t");

        // Parameters
        builder.append("Parameters: ");
        if (getParameters().size() > 0) {
            builder.append("[");
            Iterator<String> keySetIterator = getParameters().keySet().iterator();
            while (keySetIterator.hasNext()) {
                String name = keySetIterator.next();
                builder.append("\n\t\t");
                builder.append("\"" + name + "\": [");

                Iterator<String> parameterKeySetIterator = getParameter(name).keySet().iterator();
                while (parameterKeySetIterator.hasNext()) {
                    String parameterName = parameterKeySetIterator.next();
                    builder.append("\n\t\t\t");
                    JTextField textField = (JTextField) getParameter(name).get(parameterName);
                    builder.append("\"" + parameterName + "\"" + ": " + textField.getText());
                }

                builder.append("\n\t\t]");
            }
            builder.append("\n\t]");
        } else {
            builder.append("null");
        }
        builder.append("\n\t");

        // Query String
        builder.append("Query String: ");
        if (getQueryStrings().size() > 0) {
            builder.append("[");
            Iterator<String> keySetIterator = getQueryStrings().keySet().iterator();
            while (keySetIterator.hasNext()) {
                String name = keySetIterator.next();
                builder.append("\n\t\t");
                builder.append("\"" + name + "\": "+ getQueryString(name));
            }
            builder.append("\n\t]");
        } else {
            builder.append("null");
        }
        builder.append("\n\t");

        builder.append("\n]");

        return builder.toString();
    }
}
