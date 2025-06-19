package AnimalLifeSimulation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)//Tiempo de ejecución
public @interface SimulationParameters {
    double weight();
    int maxBreedForLocation();
    int speedMax();
    double limitFood();
}
