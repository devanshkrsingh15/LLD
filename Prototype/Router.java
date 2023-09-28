package Prototype;

class RouterProduct{
    private String name;
    private String key;

    RouterProduct( String name, String key){
        this.name = name;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public RouterProduct clone(){
        return new RouterProduct(this.name,this.key);
    }

    public void display() {
        System.out.println("Name :" + this.name);
        System.out.println("Key :" + this.key);

    }

}

public class Router {
    public static void main(String[] args) {
        RouterProduct router = new RouterProduct("TP Link", "123***");
        System.out.println("Original");
        router.display();

        RouterProduct dup_router = router.clone();
        System.out.println("Duplicate");
        dup_router.display();
        dup_router.setName("TP Link Duplicate");

        dup_router.display();

        System.out.println("Original");
        router.display();
    }


}
