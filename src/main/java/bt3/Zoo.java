package bt3;

import java.util.ArrayList;

class Zoo {
    private static ArrayList<Animal> animals = new ArrayList<>();

    public static void main(String[] args) {

        addAnimal(new Dog("Chó Vàng"));
        addAnimal(new Cat("Mèo Mun"));
        addAnimal(new Bird("Chim Sẻ"));
        addAnimal(new Dog("Chó Đen"));
        addAnimal(new Cat("Mèo Trắng"));

        System.out.println("\nDanh sách động vật:");
        showAllAnimals();

        System.out.println("\nThống kê số lượng:");
        countByType();
    }

    public static void addAnimal(Animal a) {
        animals.add(a);
    }

    public static void showAllAnimals() {
        for (Animal a : animals) {
            a.makeSound();
            a.move();
            System.out.println("------");
        }
    }

    public static void countByType() {
        int dogs = 0, cats = 0, birds = 0;
        for (Animal a : animals) {
            if (a instanceof Dog) dogs++;
            else if (a instanceof Cat) cats++;
            else if (a instanceof Bird) birds++;
        }
        System.out.println("Số chó: " + dogs);
        System.out.println("Số mèo: " + cats);
        System.out.println("Số chim: " + birds);
    }
}

