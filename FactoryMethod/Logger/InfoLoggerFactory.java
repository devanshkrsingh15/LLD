package FactoryMethod.Logger;


public class InfoLoggerFactory implements ILoggerFactory{

    public static ILogger createLogger() {
        return new InfoLogger();
    }

}