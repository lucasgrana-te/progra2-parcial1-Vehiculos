/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.utn.vehiculo;

public class ColectivoTuristico extends Vehiculo {

    private int cantidadPisos;

    public ColectivoTuristico(String patente, String marca, int capacidadPasajeros,
            int anioFabricacion, int cantidadPisos) {
        super(patente, marca, capacidadPasajeros, anioFabricacion);
        setCantidadPisos(cantidadPisos);
    }

    public int getCantidadPisos() {
        return cantidadPisos;
    }

    public void setCantidadPisos(int cantidadPisos) {
        if (cantidadPisos != 1 && cantidadPisos != 2) {
            throw new IllegalArgumentException("La cantidad de pisos debe ser 1 o 2.");
        }
        this.cantidadPisos = cantidadPisos;
    }

    @Override
    public void realizarServicio() {
        System.out.println("El colectivo " + getPatente()
                + " realiza un recorrido turistico por la ciudad (" + cantidadPisos + " piso/s).");
    }

    @Override
    public String toString() {
        return "[Colectivo] " + super.toString() + " | Pisos: " + cantidadPisos;
    }
}
