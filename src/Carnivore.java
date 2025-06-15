public class Carnivore extends Animal{

    public Carnivore(double weight, int speedMax, double limitFood, double currentFood, int maxBreedForLocation, Location location) {
        super(weight, speedMax, limitFood, currentFood, maxBreedForLocation, location);
    }

    @Override
    public void eat() {
        super.eat();
    }


}
