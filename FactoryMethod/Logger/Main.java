package FactoryMethod.Logger;
public class Main {
    public static void main(String[] args) {
        ILogger errorLogger = ErrorLoggerFactory.createLogger();
        errorLogger.log();
    }
}
