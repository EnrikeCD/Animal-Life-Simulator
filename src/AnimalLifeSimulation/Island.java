package AnimalLifeSimulation;

public class Island {
    private int x;
    private int y;
    private Location[][] location;
    private PopulationManager populateAnimal = new PopulationManager();

    public Island(int x, int y){
        this.x = x;
        this.y = y;
        location = new Location[this.x][this.y];
        inicializeLocation();

    }
    public Island(){
        this.x = 100;
        this.y = 20;
        location = new Location[this.x][this.y];
        inicializeLocation();
    }

    public void inicializeLocation(){
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                location[i][j] = new Location(i,j);
            }
        }
    }

    public void showLocations(){
        for(int i = 0 ; i < x ; i++){
            for (int j = 0; j < y; j++) {
                location[i][j].showAllLocation();
            }
            System.out.println();
        }
    }

    public Location getLocation(int x, int y){
        return location[x][y];
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
        location[fila][columna].showEspecificLocation();
    }

    public void startSimulation(){
        for(int i = 0 ; i < x ; i++) {
            for (int j = 0; j < y; j++) {
                populateAnimal.populate(getLocation(i,j));
            }
        }
    }

    public void stopSimulation(){}
}
