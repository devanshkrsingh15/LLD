package AbstractFactory.GUI;

public class GUI {
    public static void main(String[] args) {
        IFactory macOSFactory = IFactory.creaFactory(OS.MacOS);
        IButton macButton = macOSFactory.createButton();
        macButton.place();

        IFactory winOSFactory = IFactory.creaFactory(OS.WinOS);
        ITextBox winTextBox = winOSFactory.createTextBox();
        winTextBox.write();
    }
}

interface IButton {
    void place();
}

interface ITextBox {
    void write();
}

class MacButton implements IButton {

    @Override
    public void place() {
        System.out.println("Placing MacOS button");
    }

}

class WinButton implements IButton {

    @Override
    public void place() {
        System.out.println("Placing WinOS button");
    }

}

class MacTextButton implements ITextBox {

    @Override
    public void write() {
        System.out.println("Writing on MacOS text box");
    }

}

class WinTextButton implements ITextBox {
    @Override
    public void write() {
        System.out.println("Writing on WinOS text box");
    }
}

enum OS {
    MacOS, WinOS
}

interface IFactory {
    IButton createButton();

    ITextBox createTextBox();

    public static IFactory creaFactory(OS type) {
        if (type == OS.MacOS) {
            return new MacOSFactory();
        } else if (type == OS.WinOS) {
            return new WinOSFactory();
        } else {
            return null;
        }
    }
}

class MacOSFactory implements IFactory {

    @Override
    public IButton createButton() {
        return new MacButton();
    }

    @Override
    public ITextBox createTextBox() {
        return new MacTextButton();
    }

}

class WinOSFactory implements IFactory {

    @Override
    public IButton createButton() {
        return new WinButton();
    }

    @Override
    public ITextBox createTextBox() {
        return new WinTextButton();
    }

}