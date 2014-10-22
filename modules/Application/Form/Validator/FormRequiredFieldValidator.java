package project.modules.Application.Form.Validator;

import project.modules.Application.Entity.ConfigurationEntity;
import javax.swing.JOptionPane;

public class FormRequiredFieldValidator
{
    public static ConfigurationEntity configuration;
    public static String errorFields = "";
    public static Integer errorCount = 0;

    public static void validateField(String name, String text)
    {
        String errorField = "";
        if (text.isEmpty()) {
            errorFields += (errorCount > 0 ? ", " : "") + name;
            errorCount++;
        }
    }

    public static void showErrorMessage()
    {
        String errorMessage = getErrorCount() > 1
            ? "Preencha os campos"
            : "Preencha o campo";
        JOptionPane.showMessageDialog(
            null,
            configuration.getTranslator().__(errorMessage) + ": [" + errorFields +"]",
            configuration.getTranslator().__("Campo Obrigatório"),
            JOptionPane.ERROR_MESSAGE
        );
        clear();
    }

    public static void clear()
    {
        errorFields = "";
        errorCount = 0;
    }

    public static void setConfiguration(ConfigurationEntity configuration)
    {
        FormRequiredFieldValidator.configuration = configuration;
    }

    public static String getErrorFields()
    {
        return errorFields;
    }

    public static Integer getErrorCount()
    {
        return errorCount;
    }
}
