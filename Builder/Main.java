package Builder;

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

    abstract public void buildRAM();

    abstract public void buildProcessor();

    abstract public void buildMonitor();

    abstract public void buildKeyboard();

    abstract public void buildMouse();

    abstract public void buildSpeaker();

    abstract public void buildPrinter();

    public Desktop build() {
        return desktop;
    }
}

class HPDesktopBuilder extends DesktopBuilder {
    public void buildRAM() {
        desktop.setRam("HP RAM");
    }

    public void buildProcessor() {
        desktop.setProcessor("HP Processor");
    }

    public void buildMonitor() {
        desktop.setMonitor("HP Monitor");
    }

    public void buildMouse() {
        desktop.setMouse("HP Mouse");
    }

    public void buildSpeaker() {
        desktop.setSpeaker("HP Speaker");
    }

    public void buildPrinter() {
        desktop.setPrinter("HP Printer");
    }

    public void buildKeyboard() {
        desktop.setKeyboard("HP Keyboard");
    }
}

class DellDesktopBuilder extends DesktopBuilder {
    public void buildRAM() {
        desktop.setRam("Dell RAM");
    }

    public void buildProcessor() {
        desktop.setProcessor("Dell Processor");
    }

    public void buildMonitor() {
        desktop.setMonitor("Dell Monitor");
    }

    public void buildMouse() {
        desktop.setMouse("Dell Mouse");
    }

    public void buildSpeaker() {
        desktop.setSpeaker("Dell Speaker");
    }

    public void buildPrinter() {
        desktop.setPrinter("Dell Printer");
    }

    public void buildKeyboard() {
        desktop.setKeyboard("Dell Keyboard");
    }
}

class SonyDesktopBuilder extends DesktopBuilder {
    public void buildRAM() {
        desktop.setRam("Sony RAM");
    }

    public void buildProcessor() {
        desktop.setProcessor("Sony Processor");
    }

    public void buildMonitor() {
        desktop.setMonitor("Sony Monitor");
    }

    public void buildMouse() {
        desktop.setMouse("Sony Mouse");
    }

    public void buildSpeaker() {
        desktop.setSpeaker("Sony Speaker");
    }

    public void buildPrinter() {
        desktop.setPrinter("Sony Printer");
    }

    public void buildKeyboard() {
        desktop.setKeyboard("Sony Keyboard");
    }
}

class DesktopDirector {
    public Desktop buildDesktop(DesktopBuilder builder) {
        builder.buildRAM();
        builder.buildProcessor();
        builder.buildMonitor();
        builder.buildMouse();
        builder.buildSpeaker();
        builder.buildPrinter();
        builder.buildKeyboard();
        return builder.build();
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
