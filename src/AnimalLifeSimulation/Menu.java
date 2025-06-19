package AnimalLifeSimulation;

import java.util.Scanner;

public class Menu implements Runnable{
    private static final Menu INSTANCE = new Menu();
    private final Scanner scanner = new Scanner(System.in);
    private volatile boolean running = true; //bandera para detener la simulación
    private Island island;

    private Menu(){}

    public static Menu getInstance(){return INSTANCE;}

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted() && running) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            manejarOpcion(opcion);
        }
        System.out.println("AnimalLifeSimulation.Menu detenido.");
    }

    private void mostrarMenu() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Definir tamaño de la isla");
        System.out.println("2. Iniciar simulación");
        System.out.println("3. Mostrar estado general del mapa");
        System.out.println("4. Mostrar detalle de una ubicación");
        System.out.println("5. Detener simulación");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private void manejarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> definirTamanoIsla();
            case 2 -> iniciarSimulacion();
            case 3 -> mostrarEstadoGeneral();
            case 4 -> mostrarDetalleUbicacion();
            case 5 -> detenerSimulacion();
            case 6 -> salir();
            default -> System.out.println("Opción no válida.");
        }
    }

    private void definirTamanoIsla() {
        System.out.print("Filas: ");
        int rows = scanner.nextInt();
        System.out.print("Columnas: ");
        int columns = scanner.nextInt();
        scanner.nextLine();

        island = new Island(rows, columns);
        System.out.println("Isla creada con tamaño " + rows + "x" + columns);
    }

    private void iniciarSimulacion() {
        if (island == null) {
            System.out.println("Primero define la isla.");
            return;
        }
        island.startSimulation();
        System.out.println("Simulación iniciada.");
    }

    private void mostrarEstadoGeneral() {
        if (island == null) {
            System.out.println("Primero define la isla.");
            return;
        }
        island.printGeneralState();
    }

    private void mostrarDetalleUbicacion() {
        if (island == null) {
            System.out.println("Primero define la isla.");
            return;
        }
        System.out.print("Fila: ");
        int fila = scanner.nextInt();
        System.out.print("Columna: ");
        int columna = scanner.nextInt();
        scanner.nextLine();

        island.printLocationDetails(fila, columna);
    }

    private void detenerSimulacion() {
        if (island != null) {
            island.stopSimulation();
            System.out.println("Simulación detenida.");
        }
    }

    private void salir() {
        detenerSimulacion();
        running = false;
    }
}
