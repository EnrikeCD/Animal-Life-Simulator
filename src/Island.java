import java.sql.Array;
import java.util.Random;

public class Island {
    private int x;
    private int y;
    private Location[][] populateLocation;

    public Island(int x, int y){
        this.x = x;
        this.y = y;
        populateLocation = new Location[this.x][this.y];
        inicializeLocation();

    }
    public Island(){
        this.x = 100;
        this.y = 20;
        populateLocation = new Location[this.x][this.y];
        inicializeLocation();
    }

    public void inicializeLocation(){
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                populateLocation[i][j] = new Location(i,j);
            }
        }
    }

    public void showLocations(){
        for(int i = 0 ; i < x ; i++){
            for (int j = 0; j < y; j++) {
                populateLocation[i][j].showAllLocation();
                //populateLocation[i][j].showPlants();
            }
            System.out.println();
        }
    }

    public Location getLocation(int x, int y){
        return populateLocation[x][y];
    }

    public void printGeneralState() {
        System.out.println("Estado general de la isla:");
        showLocations();
    }

    public void printLocationDetails(int fila, int columna) {
        if (fila < 0 || fila >= x || columna < 0 || columna >= y) {
            System.out.println("Ubicación fuera de los límites de la isla.");
            return;
        }

        System.out.println("Detalles de la ubicación [" + fila + "][" + columna + "]:");
        populateLocation[fila][columna].showAllLocation();
    }

    public void startSimulation(){}

    public void stopSimulation(){}
}
