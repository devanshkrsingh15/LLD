package Builder.WithChaining;

class Desktop {
    private String ram;
    private String processor;
    private String monitor;
    private String keyboard;
    private String mouse;
    private String speaker;
    private String printer;

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    public String getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }

    public String getMouse() {
        return mouse;
    }

    public void setMouse(String mouse) {
        this.mouse = mouse;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getPrinter() {
        return printer;
    }

    public void setPrinter(String printer) {
        this.printer = printer;
    }

    public void Display() {
        System.out.println(this.ram);
        System.out.println(this.processor);
        System.out.println(this.monitor);
        System.out.println(this.keyboard);
        System.out.println(this.mouse);
        System.out.println(this.speaker);
        System.out.println(this.printer);
        System.out.println();
    }
}

abstract class DesktopBuilder {
    protected Desktop desktop = new Desktop();

    abstract public DesktopBuilder buildRAM();

    abstract public DesktopBuilder buildProcessor();

    abstract public DesktopBuilder buildMonitor();

    abstract public DesktopBuilder buildKeyboard();

    abstract public DesktopBuilder buildMouse();

    abstract public DesktopBuilder buildSpeaker();

    abstract public DesktopBuilder buildPrinter();

    public Desktop build() {
        return desktop;
    }
}

class HPDesktopBuilder extends DesktopBuilder {
    public DesktopBuilder buildRAM() {
        desktop.setRam("HP RAM");
        return this;
    }

    public DesktopBuilder buildProcessor() {
        desktop.setProcessor("HP Processor");
        return this;
    }

    public DesktopBuilder buildMonitor() {
        desktop.setMonitor("HP Monitor");
        return this;
    }

    public DesktopBuilder buildMouse() {
        desktop.setMouse("HP Mouse");
        return this;
    }

    public DesktopBuilder buildSpeaker() {
        desktop.setSpeaker("HP Speaker");
        return this;
    }

    public DesktopBuilder buildPrinter() {
        desktop.setPrinter("HP Printer");
        return this;
    }

    public DesktopBuilder buildKeyboard() {
        desktop.setKeyboard("HP Keyboard");
        return this;
    }
}

class DellDesktopBuilder extends DesktopBuilder {
    public DesktopBuilder buildRAM() {
        desktop.setRam("Dell RAM");
        return this;
    }

    public DesktopBuilder buildProcessor() {
        desktop.setProcessor("Dell Processor");
        return this;
    }

    public DesktopBuilder buildMonitor() {
        desktop.setMonitor("Dell Monitor");
        return this;
    }

    public DesktopBuilder buildMouse() {
        desktop.setMouse("Dell Mouse");
        return this;
    }

    public DesktopBuilder buildSpeaker() {
        desktop.setSpeaker("Dell Speaker");
        return this;
    }

    public DesktopBuilder buildPrinter() {
        desktop.setPrinter("Dell Printer");
        return this;
    }

    public DesktopBuilder buildKeyboard() {
        desktop.setKeyboard("Dell Keyboard");
        return this;
    }
}

class SonyDesktopBuilder extends DesktopBuilder {
    public DesktopBuilder buildRAM() {
        desktop.setRam("Sony RAM");
        return this;
    }

    public DesktopBuilder buildProcessor() {
        desktop.setProcessor("Sony Processor");
        return this;

    }

    public DesktopBuilder buildMonitor() {
        desktop.setMonitor("Sony Monitor");
        return this;

    }

    public DesktopBuilder buildMouse() {
        desktop.setMouse("Sony Mouse");
        return this;

    }

    public DesktopBuilder buildSpeaker() {
        desktop.setSpeaker("Sony Speaker");
        return this;

    }

    public DesktopBuilder buildPrinter() {
        desktop.setPrinter("Sony Printer");
        return this;

    }

    public DesktopBuilder buildKeyboard() {
        desktop.setKeyboard("Sony Keyboard");
        return this;

    }
}

class DesktopDirector {
    public Desktop buildDesktop(DesktopBuilder builder) {
        return builder.buildRAM().buildProcessor().buildMonitor().buildMouse().buildSpeaker().buildPrinter()
                .buildKeyboard().build();
    }
}

public class Main {
    public static void main(String[] args) {
        DesktopDirector director = new DesktopDirector();
        Desktop dellDesktop = director.buildDesktop(new DellDesktopBuilder());
        Desktop hpDesktop = director.buildDesktop(new HPDesktopBuilder());
        Desktop sonyDesktop = director.buildDesktop(new SonyDesktopBuilder());

        System.out.println("Dell Desktop  ---> ");
        dellDesktop.Display();

        System.out.println("HP Desktop  ---> ");
        hpDesktop.Display();

        System.out.println("Sony Desktop  ---> ");
        sonyDesktop.Display();
    }

}
