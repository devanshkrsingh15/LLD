package AbstractFactory.Furniture;

public class Furniture {
    public static void main(String[] args) {
        IFactory mfactory = IFactory.createFactory("Modern");
        IFurniture modernChair = mfactory.createChair();
        modernChair.sit();
        IFurniture modernSofa = mfactory.createSofa();
        modernSofa.sit();
        IFactory aFactory = IFactory.createFactory("Antique");
        IFurniture antiqueChair = aFactory.createChair();
        antiqueChair.sit();
    }
}

interface IFurniture {
    public void sit();
}

class Chair implements IFurniture {
    String type;

    public Chair() {
    }

    public Chair(String type) {
        this.type = type;
    }

    @Override
    public void sit() {
        System.out.println("Sitting on Chair " + type);
    }
}

class Sofa implements IFurniture {
    String type;

    public Sofa() {
    }

    public Sofa(String type) {
        this.type = type;
    }

    @Override
    public void sit() {
        System.out.println("Sitting on Sofa " + type);
    }
}

interface IFactory {
    IFurniture createChair();

    IFurniture createSofa();

    public static IFactory createFactory(String factoryType) {
        switch (factoryType) {
            case "Modern":
                return new ModernFactory();

            case "Antique":
                return new AntiqueFactory();

            default:
                return null;
        }
    }
}

class ModernFactory implements IFactory {

    @Override
    public IFurniture createChair() {
        return new Chair("Modern");
    }

    @Override
    public IFurniture createSofa() {
        return new Sofa("Modern");
    }

}

class AntiqueFactory implements IFactory {

    @Override
    public IFurniture createChair() {
        return new Chair("Antique");
    }

    @Override
    public IFurniture createSofa() {
        return new Sofa("Antique");
    }

}