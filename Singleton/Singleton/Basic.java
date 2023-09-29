package Singleton;

class DB{
    private static DB dbInstance;
    private DB(){
        System.out.println("Initializing DB");
    }

    public static DB getInstance(){
        if(dbInstance==null){
            dbInstance = new DB();
        }
        return dbInstance;
    }

}

public class Basic {
    // Enter Your Methods Here
    public static void main(String[] args) {
        DB myInstance1 = DB.getInstance();
        DB myInstance2 = DB.getInstance();

        System.out.println(myInstance1 == myInstance2 ? "myInstance1 and  myInstance2 are same" : "Both are different");
        
        DB myInstance3 = DB.getInstance();
        System.out.println(myInstance3 == myInstance2 ? "myInstance3 and  myInstance2 are same" : "Both are different");


    }
}