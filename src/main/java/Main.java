import java.util.Scanner;
class Car {
    private String name;
    private int speed;
    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
}
class Race {
    private String leaderName = "";
    private int maxDistance = 0;

    public void checkLeader(Car car) {
        int distance = car.getSpeed() * 24;
        if (distance > maxDistance) {
            maxDistance = distance;
            leaderName = car.getName();
        }
    }
    public String getLeaderName() {
        return leaderName;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();
        for (int i = 1; i <= 3; i++) {
            System.out.println("Введите название машины №" + i + ":");
            String name = scanner.next();

            int speed;
            while (true) {
                System.out.println("Введите скорость машины №" + i + ":");
                if (scanner.hasNextInt()) {
                    speed = scanner.nextInt();
                    if (speed > 0 && speed <= 250) {
                        break;
                    } else {
                        System.out.println("Неправильная скорость. Введите число от 1 до 250.");
                    }
                } else {
                    System.out.println("Ошибка ввода. Введите целое число.");
                    scanner.next();
                }
            }

            Car car = new Car(name, speed);
            race.checkLeader(car);
        }
        System.out.println("Самая быстрая машина: " + race.getLeaderName());
        scanner.close();
    }
}
