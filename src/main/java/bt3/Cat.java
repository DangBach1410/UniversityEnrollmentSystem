package bt3;

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
    @Override
    public void makeSound() {
        System.out.println(getName() + " kêu: Meo meo~");
    }
    @Override
    public void move() {
        System.out.println(getName() + " chạy bằng bốn chân.");
    }
}
