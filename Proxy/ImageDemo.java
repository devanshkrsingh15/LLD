package Proxy;

public class ImageDemo {
    // Enter Your Methods Here
    public static void main(String[] args) {
        ImageProxy myImage = new ImageProxy("my-image");
        myImage.display(); //will only load once

        myImage.display();
    }
}

interface Image{
    public void display();
}

class ImageProxy implements Image{
    String name;
    RealImage image;
    ImageProxy(String name){
        this.name =  name;;
    }
    
    public void display(){
        if(this.image==null){
            this.image= new RealImage(this.name);
            this.image.loadImage();
        }
        System.out.println("Displaying image " + this.name);
    }
}

class RealImage implements Image{
    String name;
    RealImage(String name){
        this.name = name;
    }

    public void display(){
        this.loadImage();
        System.out.println("Displaying image " + this.name);
    }

    public void loadImage(){
         System.out.println("Loading image " + this.name);
    }
}