package ar.edu.utn.vehiculo; 
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private final int ANIO_MINIMO = 1990;
    private final int ANIO_ACTUAL = 2026; // actualizar si cambia el anio

    private Scanner sc;
    private GestorVehiculos gestor;

    public Menu() {
        sc = new Scanner(System.in);
        gestor = new GestorVehiculos();
    }

    public void iniciar() {
        int opcion = 0;
        do {
            mostrarMenu();
            try {
                opcion = Integer.parseInt(sc.nextLine().trim());
                ejecutarOpcion(opcion);
            } catch (NumberFormatException e) {
                System.out.println("Opcion invalida: ingrese un numero del 1 al 8.");
                opcion = 0;
            }
        } while (opcion != 8);
        System.out.println("Hasta luego!");
    }

    private void mostrarMenu() {
        System.out.println("\n===== TRANSPORTE TURISTICO =====");
        System.out.println("1. Agregar vehiculo");
        System.out.println("2. Mostrar todos los vehiculos");
        System.out.println("3. Realizar servicios turisticos");
        System.out.println("4. Buscar vehiculo por patente");
        System.out.println("5. Mostrar vehiculos con capacidad mayor a un valor");
        System.out.println("6. Mostrar vehiculos ordenados por anio descendente");
        System.out.println("7. Mostrar vehiculos ordenados por capacidad descendente");
        System.out.println("8. Salir");
        System.out.print("Elija una opcion: ");
    }

    private void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                agregarVehiculo();
                break;
            case 2:
                gestor.mostrarTodos();
                break;
            case 3:
                gestor.realizarServicios();
                break;
            case 4:
                buscarPorPatente();
                break;
            case 5:
                mostrarPorCapacidad();
                break;
            case 6:
                gestor.mostrarLista(gestor.ordenadosPorAnioDesc());
                break;
            case 7:
                gestor.mostrarLista(gestor.ordenadosPorCapacidadDesc());
                break;
            case 8:
                break;
            default:
                System.out.println("Opcion fuera de rango: elija entre 1 y 8.");
        }
    }

    // ---------- ALTA ----------
    private void agregarVehiculo() {
        int tipo = leerEntero("Tipo (1=Colectivo, 2=Van, 3=Lancha): ");
        if (tipo < 1 || tipo > 3) {
            System.out.println("Tipo invalido.");
            return;
        }

        String patente = leerPatenteNueva();
        String marca = leerMarca();
        int capacidad = leerCapacidad();
        int anio = leerAnio();

        try {
            Vehiculo v;
            switch (tipo) {
                case 1:
                    int pisos = leerPisos();
                    v = new ColectivoTuristico(patente, marca, capacidad, anio, pisos);
                    break;
                case 2:
                    boolean aire = leerAire();
                    v = new VanEjecutiva(patente, marca, capacidad, anio, aire);
                    break;
                default:
                    String motor = leerMotor();
                    v = new LanchaTuristica(patente, marca, capacidad, anio, motor);
                    break;
            }
            gestor.agregar(v);
            System.out.println("Vehiculo agregado correctamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private String leerPatenteNueva() {
        while (true) {
            System.out.print("Patente: ");
            String patente = sc.nextLine().trim();
            if (patente.isBlank()) {
                System.out.println("Error: la patente no puede estar vacia.");
            } else if (gestor.buscarPorPatente(patente) != null) {
                System.out.println("Error: ya existe un vehiculo con esa patente.");
            } else {
                return patente;
            }
        }
    }

    private String leerMarca() {
        while (true) {
            System.out.print("Marca: ");
            String marca = sc.nextLine().trim();
            if (!marca.isBlank()) {
                return marca;
            }
            System.out.println("Error: la marca no puede estar vacia.");
        }
    }

    private int leerCapacidad() {
        while (true) {
            int c = leerEntero("Capacidad de pasajeros: ");
            if (c > 0) {
                return c;
            }
            System.out.println("Error: la capacidad debe ser mayor a cero.");
        }
    }

    private int leerAnio() {
        while (true) {
            int a = leerEntero("Anio de fabricacion: ");
            if (a < ANIO_MINIMO) {
                System.out.println("Error: el anio no puede ser menor a " + ANIO_MINIMO + ".");
            } else if (a > ANIO_ACTUAL) {
                System.out.println("Error: el anio no puede ser mayor a " + ANIO_ACTUAL + ".");
            } else {
                return a;
            }
        }
    }

    private int leerPisos() {
        while (true) {
            int p = leerEntero("Cantidad de pisos (1 o 2): ");
            if (p == 1 || p == 2) {
                return p;
            }
            System.out.println("Error: la cantidad de pisos debe ser 1 o 2.");
        }
    }

    private boolean leerAire() {
        while (true) {
            System.out.print("Aire acondicionado (S/N): ");
            String r = sc.nextLine().trim().toUpperCase();
            if (r.equals("S")) {
                return true;
            }
            if (r.equals("N")) {
                return false;
            }
            System.out.println("Error: responda S o N.");
        }
    }

    private String leerMotor() {
        while (true) {
            System.out.print("Tipo de motor (NAFTA, DIESEL, ELECTRICO): ");
            String m = sc.nextLine().trim().toUpperCase();
            if (m.equals("NAFTA") || m.equals("DIESEL") || m.equals("ELECTRICO")) {
                return m;
            }
            System.out.println("Error: motor invalido.");
        }
    }

    
    private void buscarPorPatente() {
        System.out.print("Patente a buscar: ");
        String patente = sc.nextLine().trim();
        if (patente.isBlank()) {
            System.out.println("Error: la patente no puede estar vacia.");
            return;
        }
        Vehiculo v = gestor.buscarPorPatente(patente);
        if (v == null) {
            System.out.println("No se encontro ningun vehiculo con esa patente.");
        } else {
            System.out.println("Encontrado: " + v);
        }
    }

    private void mostrarPorCapacidad() {
        int valor = leerEntero("Mostrar vehiculos con capacidad mayor a: ");
        ArrayList<Vehiculo> lista = gestor.filtrarPorCapacidadMayorA(valor);
        gestor.mostrarLista(lista);
    }

   
    private int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un numero entero valido.");
            }
        }
    }
}