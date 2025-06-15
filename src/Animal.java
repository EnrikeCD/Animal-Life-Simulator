public abstract class Animal {

    double weight;
    int speedMax;
    double limitFood;
    double currentFood;
    int maxBreedForLocation;
    Location location;

    public Animal(double weight, int speedMax, double limitFood, double currentFood, int maxBreedForLocation, Location location) {
        this.weight = weight;
        this.speedMax = speedMax;
        this.limitFood = limitFood;
        this.currentFood = currentFood;
        this.maxBreedForLocation = maxBreedForLocation;
        this.location = location;
    }

    public void eat(){}
    public void move(){}
    public void breed(){}
    public void die(){}
}
