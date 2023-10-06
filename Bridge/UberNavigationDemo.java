package Bridge;

public class UberNavigationDemo {
    // Enter Your Methods Here
    public static void main(String[] args) {
        UberApp uberEats = new UberEats(new AppleMapsImplementation());
        uberEats.requestService();

        UberApp uberRides = new UberEats(new GoogleMapsImplementation());
        uberRides.requestService();
    }
}

interface UberApp {
    public void requestService();
}

class UberEats implements UberApp {

    INavigation navigationImplementation;

    UberEats(INavigation navigationImplementation) {
        this.navigationImplementation = navigationImplementation;
    }

    @Override
    public void requestService() {
        navigationImplementation.navigate();
    }

}

class UberRide implements UberApp {

    INavigation navigationImplementation;

    UberRide(INavigation navigationImplementation) {
        this.navigationImplementation = navigationImplementation;
    }

    @Override
    public void requestService() {
        navigationImplementation.navigate();
    }

}

interface INavigation {
    public void navigate();
}


class GoogleMapsImplementation implements INavigation{

    @Override
    public void navigate() {
        System.out.println("Navigating through Google Maps");
    }
    
}

class AppleMapsImplementation implements INavigation{

    @Override
    public void navigate() {
        System.out.println("Navigating through Apple Maps");
    }
    
}