package Command;

class UberReceiver {
    String user;
    String from;
    String to;

    UberReceiver(String user, String from, String to) {
        this.user = user;
        this.from = from;
        this.to = to;
    }

    public void bookRide() {
        System.out.println("Booking a ride for " + this.user + " from " + this.from + " to " + this.to);
    }

    public void cancelRide() {
        System.out.println("Cancelling thi ride done by " + this.user + " from " + this.from + " to " + this.to);
    }

}

interface ICommand {
    public void execute();
}

class BookCabCommand implements ICommand {
    UberReceiver receiver;

    BookCabCommand(UberReceiver receiver) {
        this.receiver = receiver;
    }

    public void execute() {
        this.receiver.bookRide();
    }

}

class CancelCabCommand implements ICommand {
    UberReceiver receiver;

    CancelCabCommand(UberReceiver receiver) {
        this.receiver = receiver;
    }

    public void execute() {
        this.receiver.cancelRide();
    }
    
}

class CabInvoker{
    public void processCommand(ICommand command){
        command.execute();
    }
}

public class UberRidesDemo {
    // Enter Your Methods Here
    public static void main(String[] args) {
        BookCabCommand command1 = new BookCabCommand(new UberReceiver("Tanvi", "Koramagla", "Indiranagar"));
        BookCabCommand command2 = new BookCabCommand(new UberReceiver("Devansh", "Gachibowli", "Raidurg"));
        BookCabCommand command3 = new BookCabCommand(new UberReceiver("Som", "Noida", "CP"));


        CabInvoker cb = new CabInvoker();
        cb.processCommand(command1);
        cb.processCommand(command2);
        cb.processCommand(command3);

    }
}