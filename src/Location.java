import java.util.ArrayList;
import java.util.List;

public class Location{
    private int x;
    private int y;
    List<Animal> animals = new ArrayList<>();
    List<Plant> plants = new ArrayList<>();

    public Location(int x, int y){
        this.x = x;
        this.y = y;
        generatePlants();
    }

    public void addAnimal(Animal animal){
        animals.add(animal);
    }

    public void removeAnimal(Animal animal){
        animals.remove(animal);
    }

    public void addPlant(Plant plant){
        plants.add(plant);
    }

    public void removePlant(Plant plant){
        plants.remove(plant);
    }

    public void generateAnimals(){

    }

    public void generatePlants(){
        Plant plant1 = new Plant("tulipán");
        Plant plant2 = new Plant("girasol");
        Plant plant3 = new Plant("margarita");
        Plant plant4 = new Plant("lirio");
        Plant plant5 = new Plant("helecho");
        Plant plant6 = new Plant("musgo");
        Plant plant7 = new Plant("alfalfa");
        Plant plant8 = new Plant("romero");
        Plant plant9 = new Plant("cilantro");
        Plant plant10 = new Plant("pasto");
        addPlant(plant1);
        addPlant(plant2);
        addPlant(plant3);
        addPlant(plant4);
        addPlant(plant5);
        addPlant(plant6);
        addPlant(plant7);
        addPlant(plant8);
        addPlant(plant9);
        addPlant(plant10);
    }

    public void showAllLocation(){
        System.out.print("|- Locación: ["+x+"],["+y+"] -|");
    }

    public void showPlants(){

        for (Plant plant : plants) {
            System.out.print(plant.getName());
        }
    }
}
