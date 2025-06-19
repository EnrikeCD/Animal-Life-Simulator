package AnimalLifeSimulation;

@SimulationParameters(
        weight = 1, maxBreedForLocation = 200, speedMax = -1, limitFood = 0
)
public class Plant {
    private String name;

    public Plant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
