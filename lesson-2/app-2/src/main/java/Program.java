import java.util.stream.Stream;

public class Program {

    public static void main(String[] args) {
        Transport car = new Car();
        Transport airplane = new Airplane();
        Transport bicycle = new Bicycle();
        Transport tank = () -> System.out.println("Tank is moving and shooting...");

        car.move();
        airplane.move();
        bicycle.move();
        tank.move();

        Stream.of(car, airplane, bicycle, tank).forEach(Transport::move);
    }
}

interface Transport {

    void move();
}

class Car implements Transport {

    @Override
    public void move() {
        System.out.println("Car is moving...");
    }
}

class Airplane implements Transport {

    @Override
    public void move() {
        System.out.println("Airplane is flying...");
    }
}

class Bicycle implements Transport {

    @Override
    public void move() {
        System.out.println("Bicycle is rolling...");
    }
}
