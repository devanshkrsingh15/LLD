
public class Main {
    public static void main(String[]args){
        ILogger infoLogger = LoggerFactory.createLogger(LogLevel.INFO);
        ILogger debugLogger = LoggerFactory.createLogger(LogLevel.DEBUG);
        ILogger errorLogger = LoggerFactory.createLogger(LogLevel.ERROR);
        
        infoLogger.log();
        debugLogger.log();
        errorLogger.log();

    }
}
