package Observer;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class WeatherApp {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        CarDisplay myCarDisplay = new CarDisplay();
        weatherStation.register(myCarDisplay);
        weatherStation.register(new PhoneDisplay());
        weatherStation.register(new ClockDisplay());

        weatherStation.update("25 degC");

        System.out.println("Removing Car Display ------ ");
        weatherStation.unregister(myCarDisplay);

        weatherStation.update("37 degC");

    }
}

//Observer type
interface IDisplay {
    public void update(String temp);
}

//Subject
class WeatherStation {
    private ArrayList<IDisplay> observers;

    WeatherStation() {
        observers = new ArrayList<>();
    }

    public void register(IDisplay display) {
        observers.add(display);
    }

    public void unregister(IDisplay display) {
        observers.remove(display);
    }

    public void update(String temp) {
        for (IDisplay display : observers) {
            display.update(temp);
        }
    }
}

class CarDisplay implements IDisplay {

    @Override
    public void update(String temp) {
        System.out.println("Car Display Weather - " + temp);
    }

}

class PhoneDisplay implements IDisplay {

    @Override
    public void update(String temp) {
        System.out.println("Phone Display Weather - " + temp);
    }

}

class ClockDisplay implements IDisplay {

    @Override
    public void update(String temp) {
        System.out.println("Clock Display Weather - " + temp);
    }

}
