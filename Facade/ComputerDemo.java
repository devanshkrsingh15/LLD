package Facade;

public class ComputerDemo {
    // Enter Your Methods Here
    public static void main(String[] args) {
        Computer comp = new Computer();//facade for all loading computer complexities
        comp.execute();
    }
}

interface ComputerComponent {
    public void execute();
}

class CPU implements ComputerComponent {
    public void execute() {
        System.out.println("Loading CPU drivers and OS");
    }
}

class HardDisk implements ComputerComponent {
    public void execute() {
        System.out.println("Loading Hard-disk and memory");
    }
}

class NetworkDevice implements ComputerComponent {
    public void execute() {
        System.out.println("Making network connection");
    }
}

class RAM implements ComputerComponent {
    public void execute() {
        System.out.println("Loading RAM");
    }
}

class Computer implements ComputerComponent {
    CPU cpu;
    HardDisk hardDisk;
    NetworkDevice networkConnection;
    RAM ram;

    Computer() {
        cpu = new CPU();
        hardDisk = new HardDisk();
        networkConnection = new NetworkDevice();
        ram = new RAM();
    }

    public void execute() {
        cpu.execute();
        ram.execute();
        networkConnection.execute();
        hardDisk.execute();
    }
}