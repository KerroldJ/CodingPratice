package inheritance;

class Animal {
    String name;

    void eat() {
        System.out.println(name + "Animal is eating.");
    }
}

class Dog extends Animal {

    void bark() {
        System.out.println(name + "Dog is barking.");
    }
}
