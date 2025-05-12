package bt7;

class Knight implements Fighter {
    private String name;
    private int energy;

    public Knight(String name) {
        this.name = name;
        this.energy = 100;
    }

    @Override
    public void attack() {
        if (energy >= 10) {
            System.out.println(name + " swings sword mightily!");
            energy -= 10;
        } else {
            System.out.println(name + " is too tired to attack.");
        }
    }
}
