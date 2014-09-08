package project.modules.Translation.Exception;

public class TranslationNotFoundException extends Exception
{
    public TranslationNotFoundException() {}

    public TranslationNotFoundException(String message)
    {
        super(message);
    }

    public void printMessage()
    {
        System.out.println(getMessage());
        System.exit(1);
    }
}
