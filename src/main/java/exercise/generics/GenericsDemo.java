package exercise.generics;

import java.util.ArrayList;

public class GenericsDemo {
    public static void main(String[] args) {
        // 배열은 차를 더 추가할 수가 없어요.
        Car[] cars = new Car[3];
        cars[0] = new Taxi();
        cars[1] = new Bus();
        cars[2] = new ElecCar();

        for (int i = 0; i<3; i++) {
            cars[i].bbang();
        }

        ArrayList<Car> carArrayList = new ArrayList<>();
        carArrayList.add(new Taxi());
        carArrayList.add(new Bus());
        carArrayList.add(new ElecCar());

        for (int i = 0; i < carArrayList.size(); i++) {
            carArrayList.get(i).bbang();
        }

        CarList<Car> carList = new CarList<>();
        carList.add(new Taxi());
        carList.add(new Bus());
        carList.add(new ElecCar());

        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).bbang();
        }
    }
}

class CarList<T> {

    ArrayList<T> arrayList = new ArrayList<>();

    void add(T data) {
        arrayList.add(data);
    }

    T get(int idx) {
        return arrayList.get(idx);
    }

    int size() {
        return arrayList.size();
    }
}

class Car { void bbang() {
    System.out.println("경적 소리");}}
class Taxi extends Car { void bbang() {
    System.out.println("뛰뛰");}}
class Bus extends Car { void bbang() {
    System.out.println("빵빵");
}}
class ElecCar extends Car { void bbang() {
    System.out.println("지지징");
}}