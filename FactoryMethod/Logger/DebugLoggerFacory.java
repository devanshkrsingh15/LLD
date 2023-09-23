package FactoryMethod.Logger;

public class DebugLoggerFacory implements ILoggerFactory{

    public static ILogger createLogger() {
        return new DebugLogger();
    }
}