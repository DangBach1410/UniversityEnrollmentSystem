package homework;

public abstract class GameObject {
    protected int health;
    protected int x, y;

    public GameObject(int health, int x, int y) {
        this.health = health;
        this.x = x;
        this.y = y;
    }

    public void takeDamage(int amount) {
        health -= amount;
        if (health < 0) health = 0;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public abstract void update();
}

