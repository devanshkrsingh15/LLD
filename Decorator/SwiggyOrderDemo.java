package Decorator;

public class SwiggyOrderDemo {
    // Enter Your Methods Here
    public static void main(String[] args) {
        FoodItem myPizza = new Pizza("Farm House Pizza", 300);
        myPizza = new ExtraCheeseAddOn(myPizza, 45);
        myPizza = new ExtraVeggiesAddOn(myPizza, 20);
        System.out.println(myPizza.getDescription() + " - " + myPizza.getCost());
        System.out.println("--------------");
        FoodItem myBurger = new Burger("Chicken Burger", 190);
        myBurger = new ExtraCheeseAddOn(myBurger, 45);
        System.out.println(myBurger.getDescription() + " - " + myBurger.getCost());
    }
}

interface FoodItem {
    public String getDescription();

    public int getCost();
}

class Pizza implements FoodItem {
    String desc;
    int cost;

    Pizza(String desc, int cost) {
        this.desc = desc;
        this.cost = cost;
    }

    @Override
    public String getDescription() {
        return desc;
    }

    @Override
    public int getCost() {
        return cost;

    }

}

class Burger implements FoodItem {
    String desc;
    int cost;

    Burger(String desc, int cost) {
        this.desc = desc;
        this.cost = cost;
    }

    @Override
    public String getDescription() {
        return desc;
    }

    @Override
    public int getCost() {
        return cost;

    }

}

abstract class FoodAddOns implements FoodItem {
    protected FoodItem baseFoodItem;

    FoodAddOns(FoodItem baseFoodItem) {
        this.baseFoodItem = baseFoodItem;
    }
}

class ExtraCheeseAddOn extends FoodAddOns {
    int cost;

    ExtraCheeseAddOn(FoodItem baseFoodItem, int cost) {
        super(baseFoodItem);
        this.cost = cost;
    }

    @Override
    public String getDescription() {
        return baseFoodItem.getDescription() + " with Extra Cheese";
    }

    @Override
    public int getCost() {
        return baseFoodItem.getCost() + this.cost;
    }

}

class ExtraVeggiesAddOn extends FoodAddOns {
    int cost;

    ExtraVeggiesAddOn(FoodItem baseFoodItem, int cost) {
        super(baseFoodItem);
        this.cost = cost;
    }

    @Override
    public String getDescription() {
        return baseFoodItem.getDescription() + " with Extra Veggies";
    }

    @Override
    public int getCost() {
        return baseFoodItem.getCost() + this.cost;
    }

}