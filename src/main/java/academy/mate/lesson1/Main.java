package academy.mate.lesson1;

import java.util.ArrayList;
import java.util.List;

public class Main {


    static class Car {
        private String color;
        private int age;
        private double gasLevel;

        public Car(String color, int age, double gasLevel) {
            this.color = color;
            this.age = age;
            this.gasLevel = gasLevel;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public double getGasLevel() {
            return gasLevel;
        }

        public void setGasLevel(double gasLevel) {
            this.gasLevel = gasLevel;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "color='" + color + '\'' +
                    ", age=" + age +
                    ", gasLevel=" + gasLevel +
                    '}';
        }
    }

    public static void main(String[] args) {
        Car redCar = new Car("Red", 2, 5.5);
        Car blueCar = new Car("Blue", 4, 7.2);
        Car yellowCar = new Car("Yellow", 1, 8.6);
        Car greyCar = new Car("Grey", 2, 5.2);

        List<Car> cars = new ArrayList<>();
        cars.add(redCar);
        cars.add(blueCar);
        cars.add(yellowCar);
        cars.add(greyCar);

        Person alex = new Person("Alex", 30);
        Person vladislav = new Person("Vladislav", 22);
        Person vova = new Person("Vova", 17);
        Person anton = new Person("Anton", 25);

        List<Person> people = new ArrayList<>();
        people.add(alex);
        people.add(vladislav);
        people.add(vova);
        people.add(anton);

        /*List<Car> notOlderThen4 = findByAge(car -> car.getAge() <= 4, cars);
        System.out.println(notOlderThen4);

        List<Person> nameShorterThen5 = findByNameLenght(p -> p.getName().length() < 5, people);
        System.out.println(nameShorterThen5);*/

        List<Car> notOlderThen4 = findByCriteria(car -> car.getAge() <= 4, cars);
        System.out.println(notOlderThen4);

        List<Person> nameShorterThen5 = findByCriteria(person -> person.getName().length() < 5, people);
        System.out.println(nameShorterThen5);
    }

    private static List<Person> findByNameLenght(Criteria<Person> c, List<Person> people) {
        List<Person> result = new ArrayList<>();
        for (Person person : people) {
            if (c.test(person)) {
                result.add(person);
            }
        }
        return result;
    }

    private static List<Car> findByAge(Criteria<Car> c, List<Car> cars) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            if (c.test(car)) {
                result.add(car);
            }
        }
        return null;
    }

    private static <T> List<T> findByCriteria(Criteria<T> c, List<T> tList) {
        ArrayList<T> result = new ArrayList<>();
        for (T t : tList) {
            if (c.test(t)) {
                result.add(t);
            }
        }

        return tList;
    }

    @FunctionalInterface
    interface Criteria<T> {
        boolean test(T t);
    }

    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
