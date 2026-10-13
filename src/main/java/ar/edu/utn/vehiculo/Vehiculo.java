/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ar.edu.utn.vehiculo;

public abstract class Vehiculo {

    private final int ANIO_MINIMO = 1990;
    private final int ANIO_ACTUAL = 2026; // actualizar si cambia el anio

    private String patente;
    private String marca;
    private int capacidadPasajeros;
    private int anioFabricacion;

    public Vehiculo(String patente, String marca, int capacidadPasajeros, int anioFabricacion) {
        setPatente(patente);
        setMarca(marca);
        setCapacidadPasajeros(capacidadPasajeros);
        setAnioFabricacion(anioFabricacion);
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        if (patente == null || patente.isBlank()) {
            throw new IllegalArgumentException("La patente no puede estar vacia.");
        }
        this.patente = patente.trim().toUpperCase();
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        if (marca == null || marca.isBlank()) {
            throw new IllegalArgumentException("La marca no puede estar vacia.");
        }
        this.marca = marca.trim();
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public void setCapacidadPasajeros(int capacidadPasajeros) {
        if (capacidadPasajeros <= 0) {
            throw new IllegalArgumentException("La capacidad de pasajeros debe ser mayor a cero.");
        }
        this.capacidadPasajeros = capacidadPasajeros;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        if (anioFabricacion < ANIO_MINIMO) {
            throw new IllegalArgumentException("El anio no puede ser menor a " + ANIO_MINIMO + ".");
        }
        if (anioFabricacion > ANIO_ACTUAL) {
            throw new IllegalArgumentException("El anio no puede ser mayor al actual (" + ANIO_ACTUAL + ").");
        }
        this.anioFabricacion = anioFabricacion;
    }

    // Cada tipo de vehiculo realiza su servicio de forma distinta (polimorfismo)
    public abstract void realizarServicio();

    @Override
    public String toString() {
        return "Patente: " + patente + " | Marca: " + marca
                + " | Capacidad: " + capacidadPasajeros
                + " | Anio: " + anioFabricacion;
    }
}