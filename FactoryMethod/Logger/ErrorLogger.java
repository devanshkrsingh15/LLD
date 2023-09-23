package FactoryMethod.Logger;

public class ErrorLogger implements ILogger {
    @Override
    public void log() {
        System.out.println("I am ErrorLogger");
    }
    
}