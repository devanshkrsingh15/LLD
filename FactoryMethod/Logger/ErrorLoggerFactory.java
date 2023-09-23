package FactoryMethod.Logger;

public class ErrorLoggerFactory implements ILoggerFactory {

    public static ILogger createLogger() {
        return new ErrorLogger();
    }

}