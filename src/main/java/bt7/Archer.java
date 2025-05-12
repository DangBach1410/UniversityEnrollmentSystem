package bt7;

class Archer implements Fighter {
    private String name;
    private int energy;

    public Archer(String name) {
        this.name = name;
        this.energy = 80;
    }

    @Override
    public void attack() {
        if (energy >= 5) {
            System.out.println(name + " fires an arrow swiftly!");
            energy -= 5;
        } else {
            System.out.println(name + " is out of arrows (energy)!");
        }
    }
}
