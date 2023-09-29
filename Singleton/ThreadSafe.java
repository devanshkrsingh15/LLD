import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafe {
    // Enter Your Methods Here
    public static void main(String[] args) {
        DB myInstance1 = DB.getInstance();
        myInstance1.saveInDb("kdjckjckje");

        DB myInstance2 = DB.getInstance();
        DB myInstance3 = DB.getInstance();
        System.out.println(myInstance3 == myInstance2 ? "myInstance3 and  myInstance2 are same" : "Both are different");
    }
}

class DB {
    private static DB dbInstance;
    private static Lock mtx = new ReentrantLock();

    private DB() {
        System.out.println("Initializing DB");
    }

    public void saveInDb(String val){
        System.out.println("SAVING....." + val);
    }

    public static DB getInstance() {
        // DOUBLE CHECK LOCKING
        if (dbInstance == null) {

            mtx.lock(); // expensive

            try {
                if (dbInstance == null) {
                    dbInstance = new DB();
                }
            } finally {

                mtx.unlock();

            }

        }

        return dbInstance;
    }

}
