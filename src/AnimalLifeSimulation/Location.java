package AnimalLifeSimulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Location{
    private int x;
    private int y;
    private List<Animal> animals = new ArrayList<>();
    private List<Plant> plants = new ArrayList<>();
    private Map<Class<? extends Animal>,Integer> countByAnimal = new HashMap<>();

    public Location(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void addAnimal(Animal animal){
        animals.add(animal);
        countByAnimal.compute(animal.getClass(), (key, val) -> val == null ? 1 : val + 1);
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

    public void showAllLocation(){
        System.out.print("|- Locación: ["+x+"],["+y+"] ");
        System.out.print("*Animales: "+currentPopulationAnimals());
        System.out.print(" *Plantas: "+currentPopulationPlants()+"-|");
    }

    public void showEspecificLocation(){
        showAllLocation();
        if(animals.isEmpty()){
            System.out.println("\n Vacío");
        } else {
            System.out.print("\n *****Plantas: "+plants.size());
            System.out.println(" *****Animales: ");
            for(Map.Entry<Class<? extends Animal>, Integer> entry : countByAnimal.entrySet()){
                System.out.println("   " + entry.getKey().getSimpleName() + ": " + entry.getValue());
            }
        }
    }

    public int currentPopulationAnimals() {
        return animals.size();
    }

    private int currentPopulationPlants() {
        return plants.size();
    }

    public int getPopulationByAnimal(Class<? extends Animal> classAnimal){
        return countByAnimal.getOrDefault(classAnimal,0);
    }
}
