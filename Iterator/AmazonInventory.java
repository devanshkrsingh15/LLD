package Iterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AmazonInventory {

}

class Product {
    String name;
    String uid;
    int cost;
    String rating;

    Product(String name, String uid, int cost, String rating) {
        this.name = name;
        this.uid = uid;
        this.cost = cost;
        this.rating = rating;
    }
}

interface IIterator {
    public Product first();

    public Product next();

    public boolean hasNext();
}

class ProductIterator implements IIterator {
    List<Product>list;
    int ptr;

    ProductIterator(List<Product>list) {
        this.list = list;
        this.ptr = 0;

        Collections.sort(this.list,(a,b)->{
            return a.name.compareTo(b.name);
        });
    }

    @Override
    public Product first() {
       return this.list.get(0);
    }

    @Override
    public Product next() {
        if(this.hasNext()){
              return this.list.get(this.ptr++);
        }else{
            return null;
        }

    }

    @Override
    public boolean hasNext() {
        return this.ptr  < this.list.size();
    }

}

class Inventory {
    List<Product>list;
    Inventory(){
        this.list = new ArrayList<>();
    }

    void addProduct(Product product){
        this.list.add(product);
    }

    ProductIterator getIterator(){
        return new ProductIterator(list);
    }

}