package FactoryMethod.Logger;

public class DebugLogger implements ILogger {

    public void log() {
        System.out.println("I am a DebugLogger");;
    }
}