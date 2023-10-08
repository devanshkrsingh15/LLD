package Composite;

import java.util.ArrayList;

public class FileSystemDemo {
    // Enter Your Methods Here
    public static void main(String[] args) {
        File file1 = new File("myFile", 123);
        File file2 = new File("myOtherFile", 341);
        File file3 = new File("mySomeOtherFile", 415);
        File file4 = new File("mySomeOtherFileInAFolder", 100);

        Folder folder_1 = new Folder("myFirstFolder");
        Folder folder_2 = new Folder("mySecondFolder");
        Folder folder_3 = new Folder("myThirdFolder");

        folder_3.addComponent(file4);
        folder_3.addComponent(file3);

        folder_2.addComponent(folder_3);
        folder_2.addComponent(file2);
        
        folder_1.addComponent(folder_2);
        folder_1.addComponent(file1);

        folder_1.display();

    }

}

interface FileSystemComponent {
    public String getName();
    public int getSize();
    public void display();
    public String getType();
}

class File implements FileSystemComponent{
    String name;
    int size;

    File(String name,int size){
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
       return this.name;
    }

    @Override
    public int getSize() {
       return this.size;
    }

    public void display(){
        System.out.println("File " + this.name +  " - " + getSize() + "kb") ;
    }

    public String getType(){
        return "File";
    }
    
}

class Folder implements FileSystemComponent {
    String name;
    ArrayList<FileSystemComponent> subfolder;

    Folder(String name) {
        this.name = name;
        this.subfolder = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getSize() {
        int size = 0;
        for (FileSystemComponent comp : subfolder) {
            size += comp.getSize();
        }

        return size;
    }

    public void addComponent(FileSystemComponent comp){
        this.subfolder.add(comp);
    }

     public void removeComponent(FileSystemComponent comp){
        this.subfolder.remove(comp);
    }

     public String getType(){
        return "Folder";
    }

     public void display(){
        System.out.println("Folder - " + this.name + " - " + getSize() + "kb");
        for (FileSystemComponent comp : subfolder) {
            comp.display();
        }
        System.out.println("----------");
    }

}