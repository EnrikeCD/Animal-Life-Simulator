package AnimalLifeSimulation;

import AnimalLifeSimulation.carnivores.*;
import AnimalLifeSimulation.herbivores.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class PopulationManager {
    private static final int INITIAL_POPULATION_PER_LOCATION= 20;
    private static final Class<? extends Animal>[] supportedAnimals = new Class[]{
            Wolf.class,
            Boa.class,
            Fox.class,
            Bear.class,
            Eagle.class,
            Horse.class,
            Deer.class,
            Rabbit.class,
            Mouse.class,
            Goat.class,
            Sheep.class,
            WildBoar.class,
            Buffalo.class,
            Duck.class,
            Caterpillar.class
    };
    private final Random random = new Random();

    public void populate(Location location) {
        ArrayList<Class<? extends Animal>> universe = new ArrayList<>(Arrays.asList(supportedAnimals));

        //Poblar Animales
        while(location.currentPopulationAnimals() < INITIAL_POPULATION_PER_LOCATION && !universe.isEmpty()){
            Class<? extends Animal> classAnimal = getRandomClassAnimal(universe);
            SimulationParameters parameters = classAnimal.getAnnotation(SimulationParameters.class);
            int maxPerLocation = parameters.maxBreedForLocation();

            if(location.getPopulationByAnimal(classAnimal) < maxPerLocation){
                try{
                    location.addAnimal(classAnimal.getConstructor().newInstance());
                } catch (Exception ex){
                    System.out.println("No se pudo añadir al: "+classAnimal);
                }
            } else {
                universe.remove(classAnimal);
            }
        }

        //Poblar Plantas

        SimulationParameters plantParameters = Plant.class.getAnnotation(SimulationParameters.class);
        int maxPlants = plantParameters.maxBreedForLocation();

        for (int i = 0; i < maxPlants; i++) {
            location.addPlant(new Plant("planta"));
        }

    }

    private Class<? extends Animal> getRandomClassAnimal(ArrayList<Class<? extends Animal>> universe) {
        int typeIndex = random.nextInt(universe.size());
        return universe.get(typeIndex);
    }


}
