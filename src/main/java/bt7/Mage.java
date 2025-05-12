package bt7;

class Mage implements Fighter {
    private String name;
    private int energy;

    public Mage(String name) {
        this.name = name;
        this.energy = 60;
    }

    @Override
    public void attack() {
        if (energy >= 15) {
            System.out.println(name + " casts a fireball!");
            energy -= 15;
        } else {
            System.out.println(name + " lacks mana to cast a spell.");
        }
    }
}
