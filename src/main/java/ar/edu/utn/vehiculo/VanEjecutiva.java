/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.utn.vehiculo;


public class VanEjecutiva extends Vehiculo {
    private boolean aireAcondicionado;
    
    public VanEjecutiva (String patente, String marca, int capacidadPasajeros, int anioFabricacion, boolean aireAcondicionado){
        super(patente, marca, capacidadPasajeros, anioFabricacion);
        this.aireAcondicionado = aireAcondicionado;
    }
    public boolean isAireAcondicionado(){
        return aireAcondicionado;
    }
    public void setAireAcondicionado(boolean aireAcondicionado){
        this.aireAcondicionado = aireAcondicionado;
    }
    @Override
    public void realizarServicio() {
        if (aireAcondicionado) {
            System.out.println("La van " + getPatente() + " realiza un traslado ejecutivo con aire acondicionado.");
        } else {
            System.out.println("La van " + getPatente() + " realiza un traslado ejecutivo sin aire acondicionado.");
        }
    }
    @Override 
    public String toString(){
        String aire = "No";
        if (aireAcondicionado){
            aire = "Si";
        }
        return "[Van" + super.toString() + "Aire: "+ aire;
        
    }
}
