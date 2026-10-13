/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.utn.vehiculo;

import java.util.ArrayList;
public class GestorVehiculos {
    private ArrayList <Vehiculo> vehiculos;
    public GestorVehiculos(){
        vehiculos = new ArrayList<>();
    }
    public void agregar (Vehiculo v){
        if (buscarPorPatente(v.getPatente()) != null){
            System.out.println("Ya existe un vehiculo con la patente");
        }
        vehiculos.add(v);
        
    }
     public Vehiculo buscarPorPatente(String patente) {
        String buscada = patente.trim();
        for (int i = 0; i < vehiculos.size(); i++) {
            if (vehiculos.get(i).getPatente().equalsIgnoreCase(buscada)) {
                return vehiculos.get(i);
            }
        }
        return null;
     }
     public void mostrarTodos() {
        mostrarLista(vehiculos);
    }

    public void realizarServicios() {
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehiculos cargados.");
            return;
        }
        for (int i = 0; i < vehiculos.size(); i++) {
            vehiculos.get(i).realizarServicio(); // polimorfismo
        }
    }

    public ArrayList<Vehiculo> filtrarPorCapacidadMayorA(int valor) {
        ArrayList<Vehiculo> resultado = new ArrayList<>();
        for (int i = 0; i < vehiculos.size(); i++) {
            if (vehiculos.get(i).getCapacidadPasajeros() > valor) {
                resultado.add(vehiculos.get(i));
            }
        }
        return resultado;
    }
    public ArrayList <Vehiculo> ordenadosPorAnioDesc() {
        ArrayList<Vehiculo> copia = new ArrayList<>(vehiculos);
        for (int i = 0; i < copia.size() - 1; i++) {
            for (int j = 0; j < copia.size() - 1 - i; j++) {
                if (copia.get(j).getAnioFabricacion() < copia.get(j + 1).getAnioFabricacion()) {
                    Vehiculo aux = copia.get(j);
                    copia.set(j, copia.get(j + 1));
                    copia.set(j + 1, aux);
                }
            }
        }
        return copia;
    }

    public ArrayList<Vehiculo> ordenadosPorCapacidadDesc() {
        ArrayList<Vehiculo> copia = new ArrayList<>(vehiculos);
        for (int i = 0; i < copia.size() - 1; i++) {
            for (int j = 0; j < copia.size() - 1 - i; j++) {
                if (copia.get(j).getCapacidadPasajeros() < copia.get(j + 1).getCapacidadPasajeros()) {
                    Vehiculo aux = copia.get(j);
                    copia.set(j, copia.get(j + 1));
                    copia.set(j + 1, aux);
                }
            }
        }
        return copia;
    }
      public void mostrarLista(ArrayList<Vehiculo> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay vehiculos para mostrar.");
            return;
        }
        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + ") " + lista.get(i));
        }
    }
}
    

