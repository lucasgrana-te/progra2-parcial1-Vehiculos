/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.utn.vehiculo;

/**
 *
 * @author user
 */
public class LanchaTuristica extends Vehiculo {

    private String tipoMotor;

    public LanchaTuristica(String patente, String marca, int capacidadPasajeros,
            int anioFabricacion, String tipoMotor) {
        super(patente, marca, capacidadPasajeros, anioFabricacion);
        setTipoMotor(tipoMotor);
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(String tipoMotor) {
        if (tipoMotor == null) {
            throw new IllegalArgumentException("El tipo de motor debe ser NAFTA, DIESEL o ELECTRICO.");
        }
        String motor = tipoMotor.trim().toUpperCase();
        if (!motor.equals("NAFTA") && !motor.equals("DIESEL") && !motor.equals("ELECTRICO")) {
            throw new IllegalArgumentException("El tipo de motor debe ser NAFTA, DIESEL o ELECTRICO.");
        }
        this.tipoMotor = motor;
    }

    @Override
    public void realizarServicio() {
        System.out.println("La lancha " + getPatente()
                + " realiza un paseo turistico por el rio con motor " + tipoMotor + ".");
    }

    @Override
    public String toString() {
        return "[Lancha] " + super.toString() + " | Motor: " + tipoMotor;
    }
}
    

