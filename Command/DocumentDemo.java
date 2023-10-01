package Command;

import java.util.Stack;

//receiver
class Document {
    public void openDocument() {
        System.out.println("Opening Document");
    }

    public void closeDocument() {
        System.out.println("Closing Document");
    }

    public void minimizeDocument() {
        System.out.println("Minimizing Document");
    }

    public void maximizeDocument() {
        System.out.println("Maximize Document");
    }
}

interface IWindowCommand {
    public void execute();

    public String getDes();
}

// commands
class OpenCommand implements IWindowCommand {
    Document doc;
    String des;

    OpenCommand(Document doc) {
        this.doc = doc;
        this.des = "Open";
    }

    @Override
    public void execute() {
        doc.openDocument();
    }

    public String getDes() {
        return this.des;
    }
}

class CloseCommand implements IWindowCommand {
    Document doc;
    String des;

    CloseCommand(Document doc) {
        this.doc = doc;
        this.des = "Close";
    }

    @Override
    public void execute() {
        doc.closeDocument();
    }

    public String getDes() {
        return this.des;
    }
}

class MaximizeCommand implements IWindowCommand {
    Document doc;
    String des;

    MaximizeCommand(Document doc) {
        this.doc = doc;
        this.des = "Maximize";
    }

    @Override
    public void execute() {
        doc.maximizeDocument();
    }

    public String getDes() {
        return this.des;
    }
}

class MinimizeCommand implements IWindowCommand {
    Document doc;
    String des;

    MinimizeCommand(Document doc) {
        this.doc = doc;
        this.des = "Maximize";
    }

    @Override
    public void execute() {
        doc.minimizeDocument();
    }

    public String getDes() {
        return this.des;
    }
}

class WindowInvoker {

    Stack<IWindowCommand> undoStack;
    Stack<IWindowCommand> redoStack;

    WindowInvoker() {
        this.undoStack = new Stack<>();
        this.redoStack = new Stack<>();
    }

    public void processCommand(IWindowCommand command) {
        undoStack.push(command);
        command.execute();
    }

    public void undoCommand() {
        redoStack.push(undoStack.pop());
    }

    public void redoCommand() {
        undoStack.push(redoStack.pop());
    }

    public void OperationsTillNow() {
        for (IWindowCommand command : undoStack) {
            System.out.println(command.getDes());
        }
    }

}

public class DocumentDemo {
    // Enter Your Methods Here

    public static void main(String[] args) {
        Document doc = new Document();
        WindowInvoker win = new WindowInvoker();

        win.processCommand(new OpenCommand(doc));
        win.processCommand(new MinimizeCommand(doc));
        win.processCommand(new MaximizeCommand(doc));
        win.processCommand(new CloseCommand(doc));

        win.OperationsTillNow();
        win.undoCommand();
        win.OperationsTillNow();
        win.undoCommand();
        win.redoCommand();
        win.OperationsTillNow();
        win.redoCommand();
        win.OperationsTillNow();

    }
}